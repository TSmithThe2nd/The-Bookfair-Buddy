package org.lauchcode.bookFairBuddy.models;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends AbstractEntityReader {



//    teacher should be a class with a many to one relationship

    @ManyToOne
    private Teacher teacher;

//    books should be an array of book class



//    no arg constructor
    public Student(){

    }
//getters and setters


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
