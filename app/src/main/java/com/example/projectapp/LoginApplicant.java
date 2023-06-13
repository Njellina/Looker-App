package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

public class LoginApplicant extends AppCompatActivity{

    private DatabaseJava db;
    private EditText textEmail;
    private EditText textPass;
    private String email;
    private String password;
    private ImageButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginapplicant);

        login = (ImageButton) findViewById(R.id.login);
        textEmail = findViewById(R.id.textEmail);
        textPass = findViewById(R.id.textPassword);
        db = new DatabaseJava(this);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v){
                email = textEmail.getText().toString();
                password = textPass.getText().toString();

                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = db.checkLoginApplicant(email, password);
                    if (checkuserpass == true){
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(getApplicationContext(), ApplicantMain.class);
                        login.putExtra("name", email);
                        startActivity(login);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}



