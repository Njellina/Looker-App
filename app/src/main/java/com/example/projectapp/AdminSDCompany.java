package com.example.projectapp;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminSDCompany extends AppCompatActivity {
    public DatabaseJava db;
    private ImageButton searchButton;
    private ImageButton deleteButton;
    private EditText textEmail;
    private EditText textUsername;
    private EditText textPassword;
    private EditText textPhone;
    private EditText textAddress;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String address;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminsdcompany);
        db = new DatabaseJava(this);

        textEmail = findViewById(R.id.textEmail);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        textPhone = findViewById(R.id.textPhone);
        textAddress = findViewById(R.id.textAddress);

        searchButton = findViewById(R.id.searchButton);
        deleteButton = findViewById(R.id.deleteButton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = textEmail.getText().toString();

                if (email.isEmpty()){
                    Toast.makeText(AdminSDCompany.this, "Please enter the email!", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        Cursor cursor = db.searchCompany(email);
                        if (cursor.moveToFirst()){
                            textUsername.setText(cursor.getString(0));
                            textPassword.setText(cursor.getString(2));
                            textPhone.setText(cursor.getString(3));
                            textAddress.setText(cursor.getString(4));
                        }
                        else{
                            Toast.makeText(AdminSDCompany.this, "Email not found!", Toast.LENGTH_SHORT).show();
                            textUsername.setText("Email not found!");
                            textPassword.setText("Email not found!");
                            textPhone.setText("Email not found!");
                            textAddress.setText("Email not found!");
                        }
                        cursor.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = textEmail.getText().toString();

                if (email.isEmpty()){
                    Toast.makeText(AdminSDCompany.this, "Please enter the email!", Toast.LENGTH_SHORT).show();
                }
                else{
                    try{
                        db.deleteDataCompany(email);
                        textUsername.getText().clear();
                        textPassword.getText().clear();
                        textPhone.getText().clear();
                        textAddress.getText().clear();
                        Toast.makeText(context, "Delete Successful!", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}
