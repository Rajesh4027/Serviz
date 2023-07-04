package com.example.serviz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables
    EditText regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn;



    private final int request = 10;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_Username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);




        //Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("User Register Details");


                //Get All Value
                String Name = regName.getText().toString();
                String Username = regUsername.getText().toString();
                String Email = regEmail.getText().toString();
                String PhoneNo = regPhoneNo.getText().toString();
                String Password = regPassword.getText().toString();


                UserHelperClass helperClass = new UserHelperClass(Name, Username, Email, PhoneNo, Password);



                reference.child(PhoneNo).setValue(helperClass);
                Toast.makeText(SignUp.this,"Register Successful",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorBackground));
        }
    }

}