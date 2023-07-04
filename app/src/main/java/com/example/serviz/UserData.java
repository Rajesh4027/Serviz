package com.example.serviz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class UserData extends AppCompatActivity {

    private TextView name,username,email,phoneno,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        name = findViewById(R.id.text_name);
        username = findViewById(R.id.text_username);
        email = findViewById(R.id.text_email);
        phoneno= findViewById(R.id.text_phoneno);
        password = findViewById(R.id.text_password);

        String Name = getIntent().getStringExtra("keyname");
        String Username = getIntent().getStringExtra("keyUsername");
        String Email = getIntent().getStringExtra("keyEmail");
        String PhoneNo = getIntent().getStringExtra("keyPhoneNo");
        String Password = getIntent().getStringExtra("keyPassword");

        name.setText(Name);
        username.setText(Name);
        email.setText(Name);
        phoneno.setText(PhoneNo);
        password.setText(Password);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }
    }


}