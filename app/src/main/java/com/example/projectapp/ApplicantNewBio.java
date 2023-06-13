package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ApplicantNewBio extends AppCompatActivity {
    public DatabaseJava db;
    private ImageButton save;
    private EditText Bio;
    private EditText Email;
    private EditText JobExp;
    private String email;
    private String bio;
    private String jobexp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantnewbio);

        db = new DatabaseJava(this);
        Email = findViewById(R.id.textEmail);
        Bio = findViewById(R.id.textBio);
        JobExp = findViewById(R.id.textJobExp);
        save = (ImageButton) findViewById(R.id.buttonSaveBio);
        Bundle loginn = this.getIntent().getExtras();
        String name = (String) loginn.get("name");

        save.setOnClickListener(new View.OnClickListener() {
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
                        Toast.makeText(getApplicationContext(), "Bio already existed!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean checkuser = db.checkEmailApplicant(email);
                        if (checkuser == false){
                            Toast.makeText(getApplicationContext(), "Wrong Email!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Boolean insert = db.insertDataBio(email, bio, jobexp);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(), "Successfully Added!", Toast.LENGTH_SHORT).show();
                                Intent done = new Intent(getApplicationContext(), ApplicantProfile.class);
                                done.putExtra("name", name);
                                startActivity(done);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

            }
        });
    }
}
