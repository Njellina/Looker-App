package com.example.projectapp;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ApplicantHistory extends AppCompatActivity{
    private DatabaseJava db;
    MyAdapter5 adapter;
    RecyclerView recyclerView;
    ArrayList<String> category, name, email, city, salary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminuserlist);
        db = new DatabaseJava(this);
        category = new ArrayList<>();
        name = new ArrayList<>();
        email = new ArrayList<>();
        city = new ArrayList<>();
        salary = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter5(this, category, name, email, city, salary);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata(){
        Bundle loginn = this.getIntent().getExtras();
        String emaill = (String) loginn.get("email");

        Cursor cursor = db.searchHistory(emaill);
        if (cursor.getCount()==0){
            Toast.makeText(ApplicantHistory.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                category.add(cursor.getString(0));
                name.add(cursor.getString(1));
                email.add(cursor.getString(2));
                city.add(cursor.getString(3));
                salary.add(cursor.getString(4));
            }
        }
    }

}
