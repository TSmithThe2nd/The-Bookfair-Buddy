package org.lauchcode.bookFairBuddy.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String gradeLevel;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
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
