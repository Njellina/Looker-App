package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class RegisterActivity extends AppCompatActivity {
    private ImageButton applicant;
    private ImageButton company;
    private ImageButton costumer;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);

        applicant = (ImageButton) findViewById(R.id.applicant);
        company = (ImageButton) findViewById(R.id.company);
        costumer = (ImageButton) findViewById(R.id.costumersupport);

        applicant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegisterActivity.this, RegisterApplicant.class));
            }
        });

        company.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegisterActivity.this, RegisterCompany.class));
            }
        });

        costumer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                builder = new AlertDialog.Builder(RegisterActivity.this);
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
