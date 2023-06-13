package com.example.projectapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyApplicatorDesc extends AppCompatActivity {
    public DatabaseJava db;
    TextView textCategory;
    TextView textEmail;
    TextView textName;
    TextView textBio;
    TextView textJobExp;
    String bio, jobexp;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyapplicatordesc);

        db = new DatabaseJava(this);
        String name = getIntent().getStringExtra("name");
        String category = getIntent().getStringExtra("category");
        String emailapl = getIntent().getStringExtra("emailapl");

        textCategory = findViewById(R.id.textCategory);
        textEmail = findViewById(R.id.textEmail);
        textName = findViewById(R.id.textName);
        textBio = findViewById(R.id.textBio);
        textJobExp = findViewById(R.id.textJobExp);

        Cursor cursor = db.searchBio(emailapl);
        if (cursor.moveToFirst()){
            textCategory.setText(category);
            textName.setText(name);
            textEmail.setText(emailapl);
            textBio.setText(cursor.getString(0));
            textJobExp.setText(cursor.getString(1));
        }
    }
}
