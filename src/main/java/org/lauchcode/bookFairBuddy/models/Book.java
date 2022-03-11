package org.lauchcode.bookFairBuddy.models;

import javax.persistence.*;

@Entity
public class Book {
//    may be changed to isbn later
    @Id
    @GeneratedValue
    int id;


    private String title;
//    update to author class
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
//    update to genre class
    private String genre;

//    no arg constructor
    public Book(){

    }

//    getters and setters


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
