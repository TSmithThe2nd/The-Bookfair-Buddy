package org.lauchcode.Gradle.Models;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private int id;

    private String lastName;
    private String firstInitial;
    private String prefix;

//    array of students
    private List<Student> students;

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
