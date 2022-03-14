package org.lauchcode.bookFairBuddy.models;

import com.sun.istack.NotNull;

public class User extends AbstractEntity{
//    revisit password getters and setters



    @NotNull
    @Size(min=5, max=20)
    private String userName;

    @NotNull
    @Size(min=5, max=20)
    private String password;

    public User(){

    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
// revisit password getter and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
