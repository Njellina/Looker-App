package com.example.projectapp;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdminJobList extends AppCompatActivity {
    public DatabaseJava db;
    RecyclerView recyclerView;
    ArrayList<String> email, category, city, description, salary;
    MyAdapter2 adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminuserlist);
        db = new DatabaseJava(this);
        email = new ArrayList<>();
        category = new ArrayList<>();
        city = new ArrayList<>();
        description = new ArrayList<>();
        salary = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter2(this, email, category, city, description, salary);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata(){
        Cursor cursor = db.DataJobs();
        if (cursor.getCount()==0){
            Toast.makeText(AdminJobList.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                email.add(cursor.getString(1));
                category.add(cursor.getString(3));
                city.add(cursor.getString(4));
                description.add(cursor.getString(5));
                salary.add(cursor.getString(6));

            }
        }
    }

}
