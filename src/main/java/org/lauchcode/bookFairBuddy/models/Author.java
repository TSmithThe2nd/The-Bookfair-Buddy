package org.lauchcode.bookFairBuddy.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Author extends AbstractEntity {

//    establish one to many relationship to book
    @OneToMany
    @JoinColumn(name="author_id")
    private List<Book> books= new ArrayList<>();

//    no arg constructor
   public Author(){

    }
//getters and setters



}
