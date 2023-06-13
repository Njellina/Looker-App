package com.example.projectapp;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ApplicantJobSearch extends AppCompatActivity implements ApplicantJobInterface{
    private DatabaseJava db;
    MyAdapter4 adapter;
    RecyclerView recyclerView;
    ArrayList<String> name, category, city, salary;
    int position;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantjobrecycle);
        db = new DatabaseJava(this);
        name = new ArrayList<>(position);
        category = new ArrayList<>(position);
        city = new ArrayList<>(position);
        salary = new ArrayList<>(position);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter4(this, name, category, city, salary, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata(){
        Cursor cursor = db.DataJobs();
        if (cursor.getCount()==0){
            Toast.makeText(ApplicantJobSearch.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(2));
                category.add(cursor.getString(3));
                city.add(cursor.getString(4));
                salary.add(cursor.getString(6));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Bundle loginn = this.getIntent().getExtras();
        String email = (String) loginn.get("email");

        Intent intent = new Intent(ApplicantJobSearch.this, ApplicantJobDesc.class);
        intent.putExtra("name", String.valueOf((name.get(position))));
        intent.putExtra("category", String.valueOf((category.get(position))));
        intent.putExtra("city", String.valueOf((city.get(position))));
        intent.putExtra("salary", String.valueOf((salary.get(position))));
        intent.putExtra("emailapl", email);

        startActivity(intent);
    }

}
