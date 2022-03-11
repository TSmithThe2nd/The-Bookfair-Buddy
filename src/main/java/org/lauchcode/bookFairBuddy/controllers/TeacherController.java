package org.lauchcode.bookFairBuddy.controllers;

import org.lauchcode.bookFairBuddy.models.Teacher;
import org.lauchcode.bookFairBuddy.models.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("teachers")
public class TeacherController {
//    todo add error validation

    @Autowired
    private TeacherRepository teacherRepository;

//    show form
    @GetMapping("add")
    public String displayAddTeacherForm(Model model){
        model.addAttribute(new Teacher());
        return "teachers/add";
    }


//    submit form

    @PostMapping("add")
    public String createTeacher(@ModelAttribute Teacher newTeacher, Model model){

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

        Optional teacherOpt = teacherRepository.findById(teacherId);
        if(teacherOpt.isPresent()){
            Teacher teacher =(Teacher) teacherOpt.get();
            model.addAttribute("teacher", teacher);
            return "teacher/view";
        } else {
            return "redirect:../";
        }
    }
}




