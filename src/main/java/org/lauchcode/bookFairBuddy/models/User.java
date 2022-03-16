package org.lauchcode.bookFairBuddy.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
//    revisit password getters and setters

    @Id
    @GeneratedValue
    private int id;



    private String userName;


    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){

    }

    public User(String userName, String password){
        this.userName= userName;
        this.pwHash= encoder.encode(password);
    }


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUserName() {
        return userName;
    }



    public int getId() {
        return id;
    }
}
