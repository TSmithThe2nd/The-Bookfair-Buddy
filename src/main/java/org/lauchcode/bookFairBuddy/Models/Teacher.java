package org.lauchcode.bookFairBuddy.Models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

public class Teacher {

    private int id;

    private String lastName;
    private String firstInitial;
    private String prefix;

//    array of students
    @OneToMany
    @JoinColumn(name="teacher_id")
    private List<Student> students;

    @ManyToMany
    List<Book>books;



    //    no arg constructor
    public Teacher(){

    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstInitial() {
        return firstInitial;
    }

    public void setFirstInitial(String firstInitial) {
        this.firstInitial = firstInitial;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
