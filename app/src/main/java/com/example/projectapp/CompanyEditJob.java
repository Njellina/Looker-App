package com.example.projectapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyEditJob extends AppCompatActivity {
    private DatabaseJava db;
    private ImageButton UpdateJobs;

    private EditText Id;
    private EditText Email;
    private EditText Category;
    private EditText City;
    private EditText Description;
    private EditText Salary;

    private String id;
    private String email;
    private String category;
    private String city;
    private String description;
    private int salary;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyeditjob);

        db = new DatabaseJava(this);
        UpdateJobs = (ImageButton) findViewById(R.id.buttonUpdate);

        Id = findViewById(R.id.textID);
        Email = findViewById(R.id.textEmail);
        Category = findViewById(R.id.textCategory);
        City = findViewById(R.id.textCity);
        Description = findViewById(R.id.textDescription);
        Salary = findViewById(R.id.textSalary);

        UpdateJobs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                id = Id.getText().toString();
                email = Email.getText().toString();
                category = Category.getText().toString();
                city = City.getText().toString();
                description = Description.getText().toString();
                String sal = Salary.getText().toString();

                if (id.isEmpty()) {
                    Id.setError("Id is required!");
                    Id.requestFocus();
                    return;
                }
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
                if (category.isEmpty()) {
                    Category.setError("Category is required!");
                    Category.requestFocus();
                    return;
                }
                if (city.isEmpty()) {
                    City.setError("City is required!");
                    City.requestFocus();
                    return;
                }
                if (description.isEmpty()) {
                    Description.setError("Description is required!");
                    Description.requestFocus();
                    return;
                }
                if (sal.isEmpty()) {
                    Salary.setError("Salary is required!");
                    Salary.requestFocus();
                    return;
                }
                else{
                    Boolean checkuser = db.checkJobID(id, email);
                    if (checkuser == false){
                        Toast.makeText(CompanyEditJob.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        salary = Integer.parseInt(sal);

                        try{
                            db.updateDataJobs(id, email, category, city, description, salary);
                            Id.getText().clear();
                            Email.getText().clear();
                            Category.getText().clear();
                            City.getText().clear();
                            Description.getText().clear();
                            Salary.getText().clear();
                            Toast.makeText(CompanyEditJob.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        startActivity(new Intent(getApplicationContext(), CompanyViewJob.class));
                    }
                }
            }
        });

    }
}
