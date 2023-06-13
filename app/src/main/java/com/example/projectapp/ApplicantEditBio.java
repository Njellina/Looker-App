package com.example.projectapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ApplicantEditBio extends AppCompatActivity {
    public DatabaseJava db;
    private ImageButton view;
    private ImageButton update;
    private EditText Bio;
    private EditText Email;
    private EditText JobExp;
    private String email;
    private String bio;
    private String jobexp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicanteditbio);

        db = new DatabaseJava(this);
        Email = findViewById(R.id.textEmail);
        Bio = findViewById(R.id.textBio);
        JobExp = findViewById(R.id.textJobExp);
        view = (ImageButton) findViewById(R.id.buttonViewBio);
        update = (ImageButton) findViewById(R.id.buttonUpdateBio);
        Bundle loginn = this.getIntent().getExtras();
        String name = (String) loginn.get("name");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Email.getText().toString();
                bio = Bio.getText().toString();
                jobexp = JobExp.getText().toString();

                if (email.isEmpty()) {
                    Email.setError("Email is required!");
                    Email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("Please provide valid email!");
                    Email.requestFocus();
                    return;
                }
                else{
                    try{
                        Cursor cursor = db.searchBio(email);
                        if (cursor.moveToFirst()){
                            Bio.setText(cursor.getString(0));
                            JobExp.setText(cursor.getString(1));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email not found!", Toast.LENGTH_SHORT).show();
                            Email.setText("Email not found!");
                        }
                        cursor.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = Email.getText().toString();
                bio = Bio.getText().toString();
                jobexp = JobExp.getText().toString();

                if (email.isEmpty()) {
                    Email.setError("Email is required!");
                    Email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Email.setError("Please provide valid email!");
                    Email.requestFocus();
                    return;
                }
                else{
                    Boolean biouser = db.checkBioData(email);
                    if (biouser == true){
                        Boolean checkuser = db.checkEmailApplicant(email);
                        if (checkuser == false){
                            Toast.makeText(getApplicationContext(), "Wrong Email!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            try{
                                db.updateDataBio(email, bio, jobexp);
                                Toast.makeText(getApplicationContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                            Intent done = new Intent(getApplicationContext(), ApplicantProfile.class);
                            done.putExtra("name", name);
                            startActivity(done);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Bio doesn't exists!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
