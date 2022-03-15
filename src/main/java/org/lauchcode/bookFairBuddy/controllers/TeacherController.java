package org.lauchcode.bookFairBuddy.controllers;

import org.lauchcode.bookFairBuddy.models.Teacher;
import org.lauchcode.bookFairBuddy.models.data.BookRepository;
import org.lauchcode.bookFairBuddy.models.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("teachers")
public class TeacherController {
//    todo add error validation

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private BookRepository bookRepository;

//    show form
    @GetMapping("add")
    public String displayAddTeacherForm(Model model){
        model.addAttribute(new Teacher());
        return "teachers/add";
    }


//    submit form

    @PostMapping("add")
    public String createTeacher(@ModelAttribute @Valid Teacher newTeacher,
                                Errors errors,
                                Model model){

        if(errors.hasErrors()){
            return "teachers/add";}

        teacherRepository.save(newTeacher);
//        currently points to home index change to go to teacher that is created or back to form
        return "redirect:";

    }

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("teachers", teacherRepository.findAll());

                return "teachers/index";
    }
    @GetMapping("view/{teacherId}")
    public String displayTeacher(Model model, @PathVariable int teacherId){

        model.addAttribute("books", bookRepository.findAll());

        Optional teacherOpt = teacherRepository.findById(teacherId);
        if(teacherOpt.isPresent()){
            Teacher teacher =(Teacher) teacherOpt.get();
            model.addAttribute("teacher", teacher);
            return "teachers/view";
        } else {
            return "redirect:../";
        }
    }
}




