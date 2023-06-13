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

public class CompanyAddJob extends AppCompatActivity {
    private DatabaseJava db;
    private ImageButton AddJobs;

    private EditText Email;
    private EditText Category;
    private EditText City;
    private EditText Description;
    private EditText Salary;

    private String uname;
    private String email;
    private String category;
    private String city;
    private String description;
    private int salary;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyaddjob);

        db = new DatabaseJava(this);
        AddJobs = (ImageButton) findViewById(R.id.buttonAdd);

        Email = findViewById(R.id.textEmail);
        Category = findViewById(R.id.textCategory);
        City = findViewById(R.id.textCity);
        Description = findViewById(R.id.textDescription);
        Salary = findViewById(R.id.textSalary);

        Bundle loginn = this.getIntent().getExtras();
        if(loginn != null){
            String name = (String) loginn.get("name");
            Cursor cursor = db.CompanyUsername(name);

            AddJobs.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

//                    uname = (cursor.getString(0));
                    email = Email.getText().toString();
                    category = Category.getText().toString();
                    city = City.getText().toString();
                    description = Description.getText().toString();
                    String sal = Salary.getText().toString();

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
                        Boolean checkuser = db.checkEmailCompany(email);
                        if (checkuser == false){
                            Toast.makeText(CompanyAddJob.this, "Wrong Company Email!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if (cursor.moveToFirst()){
                                salary = Integer.parseInt(sal);
                                Boolean insert = db.insertDataJobs(email, (cursor.getString(0)), category, city, description, salary);
                                if (insert == true){
                                    Toast.makeText(CompanyAddJob.this, "Successfully Added!", Toast.LENGTH_SHORT).show();
                                    Intent done = new Intent(getApplicationContext(), CompanyMain.class);
                                    done.putExtra("name", name);
                                    startActivity(done);
                                }
                                else{
                                    Toast.makeText(CompanyAddJob.this, "Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
