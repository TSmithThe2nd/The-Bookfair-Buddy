package org.lauchcode.Gradle.Models;

public class Book {
//    may be changed to isbn later
    int id;

    private String name;
//    update to author class
    private String author;
//    update to genre class
    private String genre;

//    no arg constructor
    public Book(){

    }

//    getters and setters


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
