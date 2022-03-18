package org.lauchcode.bookFairBuddy.controllers;

import org.lauchcode.bookFairBuddy.models.Author;
import org.lauchcode.bookFairBuddy.models.Book;
import org.lauchcode.bookFairBuddy.models.data.AuthorRepository;
import org.lauchcode.bookFairBuddy.models.data.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("add")
    public String displayBookForm(Model model){
        model.addAttribute(new Book());
        model.addAttribute("authors",authorRepository.findAll());
        return "books/add";
    }

    @PostMapping("add")
    public String createBook(@ModelAttribute @Valid Book newBook,
                             Errors errors,
                             Model model,
                             @RequestParam int authorId){

        Optional authorOpt= authorRepository.findById(authorId);
        if(authorOpt.isPresent()){
            Author author= (Author) authorOpt.get();
            newBook.setAuthor(author);
        }
        if(errors.hasErrors()){
            return "books/add";
        }
        bookRepository.save(newBook);

        return "redirect:..";
    }

    @GetMapping("view/{bookId}")
    public String displayBook (Model model,
                               @PathVariable int bookId){
        Optional bookOpt= bookRepository.findById(bookId);
        if (bookOpt.isPresent()){
            Book book= (Book) bookOpt.get();
            model.addAttribute("book", book);
            return "books/view";
        } else { return "redirect:../";}
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/index";
    }
}
