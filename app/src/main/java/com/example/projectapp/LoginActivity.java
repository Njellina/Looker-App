package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {
    private ImageButton applicant;
    private ImageButton company;
    private ImageButton admin;
    private ImageButton costumer;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        costumer = (ImageButton) findViewById(R.id.costumer);
        applicant = (ImageButton) findViewById(R.id.applicant);
        company = (ImageButton) findViewById(R.id.company);
        admin = (ImageButton) findViewById(R.id.admin);

        applicant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, LoginApplicant.class));
            }
        });

        company.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, LoginCompany.class));
            }
        });

        admin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, LoginAdmin.class));
            }
        });

        costumer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Costumer Support Email");
                builder.setMessage("angelina.quincy@binus.ac.id fakhira.maheswari@binus.ac.id");

                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}