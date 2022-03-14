package org.lauchcode.bookFairBuddy.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher extends AbstractEntityReader {


    private String prefix;



    //    array of students
    @OneToMany
    @JoinColumn(name="teacher_id")
    private List<Student> students;


    //    no arg constructor
    public Teacher(){

    }
//    getter and setters

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
