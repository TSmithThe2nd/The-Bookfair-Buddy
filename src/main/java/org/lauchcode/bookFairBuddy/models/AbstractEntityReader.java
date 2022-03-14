package org.lauchcode.bookFairBuddy.models;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.util.List;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public class AbstractEntityReader extends AbstractEntity {

    @NotNull
    private String gradeLevel;

    @ManyToMany
    private List<Book> books;



    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
