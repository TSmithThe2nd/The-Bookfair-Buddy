package org.lauchcode.bookFairBuddy.models.dto;

import org.lauchcode.bookFairBuddy.models.Book;
import org.lauchcode.bookFairBuddy.models.Student;

import javax.validation.constraints.NotNull;

public class AddBookDTO {
    @NotNull
    private Student student;

    @NotNull
    private Book book;

    public AddBookDTO() {}

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
