package org.lauchcode.bookFairBuddy.controllers;

import org.lauchcode.bookFairBuddy.models.Book;
import org.lauchcode.bookFairBuddy.models.Student;
import org.lauchcode.bookFairBuddy.models.Teacher;
import org.lauchcode.bookFairBuddy.models.data.BookRepository;
import org.lauchcode.bookFairBuddy.models.data.StudentRepository;
import org.lauchcode.bookFairBuddy.models.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
//todo add error validation
@Controller
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("add")
    public String displayCreateStudentForm(Model model){
        model.addAttribute(new Student());
        model.addAttribute("teachers",teacherRepository.findAll());
        return "students/add";
    }

    @PostMapping("add")
    public String createStudent(@ModelAttribute @Valid Student newStudent,
                                Errors errors,
                                Model  model,
                                @RequestParam int teacherId){

        if(errors.hasErrors()){
            return "students/add";
        }
        Optional teacherOpt= teacherRepository.findById(teacherId);
        if (teacherOpt.isPresent()){
            Teacher teacher =(Teacher) teacherOpt.get();
            newStudent.setTeacher(teacher);
        }

        studentRepository.save(newStudent);
//        todo modify to go to edit student once created
        return "redirect:";
    }

    @GetMapping("view/{studentId}")
    public String displayStudent (Model model, @PathVariable int studentId) {

        model.addAttribute("books", bookRepository.findAll());

        Optional studentOpt = studentRepository.findById(studentId);
        if (studentOpt.isPresent()) {
            Student student = (Student) studentOpt.get();
            model.addAttribute("student", student);
            return "students/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "students/index";
    }

//    add book to student
//    @GetMapping("view")
//    public String studentFormAddBook(Model model){
//
//        model.addAttribute("books", bookRepository.findAll());
//        return "students/view";
//    }
//
    @PostMapping("view/{studentId}")
    public String addBookToStudent( @ModelAttribute Student student,
                                   Model model,
                                   @RequestParam List<Integer> books
                                   ){
        List<Book> booksObjs= (List<Book>) bookRepository.findAllById(books);
        student.setBooks(booksObjs);

    Optional<Student> studentObj= studentRepository.findById(student.getId());
    if (studentObj.isPresent()){
        Student studentCurrent=(Student) studentObj.get();
        studentCurrent.setBooks(booksObjs);
        studentRepository.save(studentCurrent);
    }


     studentRepository.save(student);

        return "students/view";
    }
}
