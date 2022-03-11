package org.lauchcode.bookFairBuddy.controllers;

import org.lauchcode.bookFairBuddy.models.data.BookRepository;
import org.lauchcode.bookFairBuddy.models.data.StudentRepository;
import org.lauchcode.bookFairBuddy.models.data.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("view/{teacherId}")
    public String displayViewTeacher(Model model, @PathVariable int teacherId) {

        return "view";
    }
}
