package com.example.projectapp;
import static com.google.android.material.internal.ContextUtils.getActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdminCompanyList extends AppCompatActivity {
    public DatabaseJava db;
    RecyclerView recyclerView;
    ArrayList<String> name, email, password, phone, address;
    MyAdapter1 adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminuserlist);
        db = new DatabaseJava(this);
        name = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();
        phone = new ArrayList<>();
        address = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter1(this, name, email, password, phone, address);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata(){
        Cursor cursor = db.DataCompany();
        if (cursor.getCount()==0){
            Toast.makeText(AdminCompanyList.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(1));
                email.add(cursor.getString(2));
                password.add(cursor.getString(3));
                phone.add(cursor.getString(4));
                address.add(cursor.getString(5));
            }
        }
    }

}
