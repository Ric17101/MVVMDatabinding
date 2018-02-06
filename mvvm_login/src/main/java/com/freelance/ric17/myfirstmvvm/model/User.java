package com.freelance.ric17.myfirstmvvm.model;

/**
 * Created by firstcom on 2/5/2018.
 */

public class User {

    private String email;
    private String password;


    private String emailHint;
    private String passwordHint;

    public User(String email, String password) {
        this.emailHint = email;
        this.passwordHint = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(String emailHint) {
        this.emailHint = emailHint;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

}
