package org.lauchcode.bookFairBuddy.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String fname;
    private String lInitial;

//    teacher should be a class with a many to one relationship
    @ManyToOne
    private Teacher teacher;

//    books should be an array of book class
    @ManyToMany
    private List<Book> books;


//    no arg constructor
    public Student(){

    }
//getters and setters


    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlInitial() {
        return lInitial;
    }

    public void setlInitial(String lInitial) {
        this.lInitial = lInitial;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
