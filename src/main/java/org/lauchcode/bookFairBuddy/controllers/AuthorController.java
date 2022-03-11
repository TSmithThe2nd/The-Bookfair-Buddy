package org.lauchcode.bookFairBuddy.controllers;


import org.lauchcode.bookFairBuddy.models.Author;
import org.lauchcode.bookFairBuddy.models.data.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("add")
    public String displayAuthorForm(Model model){
        model.addAttribute(new Author());
        return "authors/add";
    }

    @PostMapping("add")
    public String createAuthor(@ModelAttribute Author newAuthor,
                               Model model){
        authorRepository.save(newAuthor);
        return "redirect:";

    }

    @GetMapping("view/{authorId}")
    public String displayAuthor(Model model,
                                @PathVariable int authorId){
        Optional authorOpt= authorRepository.findById(authorId);
        if (authorOpt.isPresent()){
            Author author= (Author) authorOpt.get();
            model.addAttribute("author", author);
            return "authors/view";
        } else {return "redirect:../";}
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors/index";
    }
}
