package com.example.projectapp;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ApplicantMailbox extends AppCompatActivity{
    private DatabaseJava db;
    MyAdapter8 adapter;
    RecyclerView recyclerView;
    ArrayList<String> name, emailapl, category, comname, status;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminuserlist);
        db = new DatabaseJava(this);
        name = new ArrayList<>();
        emailapl = new ArrayList<>();
        category = new ArrayList<>();
        comname = new ArrayList<>();
        status = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter8(this, name, emailapl, category, comname, status);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata(){
        Bundle loginn = this.getIntent().getExtras();
        String emaill = (String) loginn.get("email");

        Cursor cursor = db.searchStatus(emaill);
        if (cursor.getCount()==0){
            Toast.makeText(ApplicantMailbox.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(2));
                emailapl.add(cursor.getString(0));
                category.add(cursor.getString(1));
                comname.add(cursor.getString(3));
                status.add(cursor.getString(4));
            }
        }
    }

}
