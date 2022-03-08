package org.lauchcode.Gradle.Models;

public class Author {

    private int id;

    private String firstName;
    private String lastName;

//    no arg constructor
   public Author(){

    }
//getters and setters
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
