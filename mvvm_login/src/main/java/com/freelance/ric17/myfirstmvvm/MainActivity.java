package com.freelance.ric17.myfirstmvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.freelance.ric17.myfirstmvvm.commands.userLogin;
import com.freelance.ric17.myfirstmvvm.databinding.ActivityMainBinding;
import com.freelance.ric17.myfirstmvvm.model.User;
import com.freelance.ric17.myfirstmvvm.viewModel.UserModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserModel userModel =  new UserModel(new User("Email", "Password"));
        activityMainBinding.setLogin(userModel);

        activityMainBinding.setUserLoginEvent(new userLogin() {
            @Override
            public void onClickLogin() {
                Toast.makeText(MainActivity.this, "" + activityMainBinding.getLogin().getEmail(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
