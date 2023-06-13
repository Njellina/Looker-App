package com.example.projectapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CompanyViewClosedJob extends AppCompatActivity {
    private DatabaseJava db;
    MyAdapter6 adapter;
    RecyclerView recyclerView;
    ArrayList<String> id, category, city, description, salary;
    private ImageButton delete;
    private EditText textID;
    private String ID;
    private String email, nama, kategori, kota, desc, gaji;
    private int sal;

    @SuppressLint({"RestrictedApi", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyclosedjobrecycle);
        db = new DatabaseJava(this);
        id = new ArrayList<>();
        category = new ArrayList<>();
        city = new ArrayList<>();
        description = new ArrayList<>();
        salary = new ArrayList<>();

        textID = findViewById(R.id.textID);
        delete = (ImageButton) findViewById(R.id.buttonDelete);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter6(this, id, category, city, description, salary);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        Bundle loginn = this.getIntent().getExtras();
        if(loginn != null){
            String name = (String) loginn.get("name");
//            Intent View = new Intent(this, CompanyViewJob.class);
//            View.putExtra("name", name);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ID = textID.getText().toString();

                    if (ID.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean checkuserpass = db.checkClosedJobID(ID, name);
                        if (checkuserpass == true){
                            Cursor cursor = db.searchClosedJobtoJob(ID);
                            if (cursor.moveToFirst()){
                                email = (cursor.getString(0));
                                nama = (cursor.getString(1));
                                kategori = (cursor.getString(2));
                                kota = (cursor.getString(3));
                                desc = (cursor.getString(4));
                                gaji = (cursor.getString(5));
                            }
                            sal = Integer.parseInt(gaji);
                            db.insertDataJobs(email, nama, kategori, kota, desc, sal);
                            db.deleteDataClosedJobs(ID);
                            Toast.makeText(getApplicationContext(), "Data Moved Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), CompanyMain.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }

    private void displaydata(){
        Bundle loginn = this.getIntent().getExtras();
        String name = (String) loginn.get("name");
        Cursor cursor = db.searchClosedJobList(name);
        if (cursor.getCount()==0){
            Toast.makeText(CompanyViewClosedJob.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                category.add(cursor.getString(1));
                city.add(cursor.getString(2));
                description.add(cursor.getString(3));
                salary.add(cursor.getString(4));
            }
        }
    }
}
