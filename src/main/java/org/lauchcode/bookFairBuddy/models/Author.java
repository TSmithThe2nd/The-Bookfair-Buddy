package org.lauchcode.bookFairBuddy.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

//    establish one to many relationship to book
    @OneToMany
    @JoinColumn(name="author_id")
    private List<Book> books= new ArrayList<>();

//    no arg constructor
   public Author(){

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
}
