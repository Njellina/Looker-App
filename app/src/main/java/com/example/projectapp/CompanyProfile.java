package com.example.projectapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyProfile extends AppCompatActivity {
    public DatabaseJava db;
    private TextView Name;
    private TextView Email;
    private TextView Phone;
    private TextView Address;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyprofile);

        db = new DatabaseJava(this);
        Name = findViewById(R.id.textName);
        Email = findViewById(R.id.textEmail);
        Phone = findViewById(R.id.textPhone);
        Address = findViewById(R.id.textAddress);

        Bundle loginn = this.getIntent().getExtras();
        if(loginn != null){
            String name = (String) loginn.get("name");
            Cursor cursor = db.CompanyProfile(name);
            if (cursor.moveToFirst()){
                Name.setText(cursor.getString(0));
                Email.setText(cursor.getString(1));
                Phone.setText(cursor.getString(2));
                Address.setText(cursor.getString(3));
            }
        }

    }
}
