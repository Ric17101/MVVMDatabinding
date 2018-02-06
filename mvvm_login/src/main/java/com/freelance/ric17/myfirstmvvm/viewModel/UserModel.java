package com.freelance.ric17.myfirstmvvm.viewModel;

import android.databinding.BaseObservable;

import com.freelance.ric17.myfirstmvvm.R;
import com.freelance.ric17.myfirstmvvm.model.User;

/**
 * Created by firstcom on 2/5/2018.
 */

public class UserModel extends BaseObservable {


    private String email;
    private String password;
    private String emailHint;
    private String passwordHint;

    public UserModel(User user) {
        this.emailHint = user.getEmailHint();
        this.passwordHint = user.getPasswordHint();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.emailId);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.passId);
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
