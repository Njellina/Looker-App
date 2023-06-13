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

public class CompanyViewApplicators extends AppCompatActivity implements CompanyViewApplicatorInterface{
    public DatabaseJava db;
    RecyclerView recyclerView;
    ArrayList<String> emailapl, name, category;
    MyAdapter7 adapter;
    private ImageButton accept, decline, cv;
    private EditText textEmail;
    private String Email, nama, aplmail, kategori;
    int position;

    @SuppressLint("RestrictedApi")
    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.companyapplicatorrecycle);
//        Bundle loginn = this.getIntent().getExtras();
//        String emailcom = (String) loginn.get("email");
//
//        textEmail = findViewById(R.id.textEmail);
//        accept = (ImageButton) findViewById(R.id.buttonAccept);
//        decline = (ImageButton) findViewById(R.id.buttonDecline);
//        cv = (ImageButton) findViewById(R.id.buttonCV);
//
//        db = new DatabaseJava(this);
//        emailapl = new ArrayList<>();
//        category = new ArrayList<>();
//        name = new ArrayList<>();
//        recyclerView = findViewById(R.id.recyclerview);
//        adapter = new MyAdapter7(this, name, emailapl, category);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        displaydata();
//
//        if(loginn != null){
//            accept.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Email = textEmail.getText().toString();
//
//                    if (Email.isEmpty()){
//                        Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Boolean check = db.checkApplicator(emailcom, Email);
//                        if (check == true){
//                            Cursor cursor = db.searchApplicatorsCom(emailcom, Email);
//                            if (cursor.moveToFirst()){
//                                aplmail = (cursor.getString(0));
//                                nama = (cursor.getString(1));
//                                kategori = (cursor.getString(2));
//                            }
//                            System.out.println(aplmail);
//                            Cursor cursor1 = db.CompanyUsername(emailcom);
//                            db.insertDataStatus(nama, aplmail, kategori, emailcom, "Accepted");
//                            db.deleteDataApplicator(emailcom, aplmail);
//                            Toast.makeText(getApplicationContext(), "Applicator Accepted!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), CompanyMain.class));
//                        }
//                        else{
//                            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//            });
//
//            decline.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Email = textEmail.getText().toString();
//
//                    if (Email.isEmpty()){
//                        Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Boolean check = db.checkApplicator(emailcom, Email);
//                        if (check == true){
//                            Cursor cursor = db.searchApplicatorsCom(emailcom, Email);
//                            if (cursor.moveToFirst()){
//                                aplmail = (cursor.getString(0));
//                                nama = (cursor.getString(1));
//                                kategori = (cursor.getString(2));
//                            }
//                            db.insertDataStatus(nama, aplmail, kategori, emailcom, "Declined");
//                            db.deleteDataApplicator(emailcom, aplmail);
//                            Toast.makeText(getApplicationContext(), "Applicator Declined!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), CompanyMain.class));
//                        }
//                        else{
//                            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//            });
//
//            cv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Email = textEmail.getText().toString();
//                    startActivity(new Intent(getApplicationContext(), CompanyEditJob.class));
//                }
//            });
//
//        }
//    }
//
//    private void displaydata(){
//        Bundle loginn = this.getIntent().getExtras();
//        String email = (String) loginn.get("email");
//        Cursor cursor = db.searchApplicators(email);
//        if (cursor.getCount()==0){
//            Toast.makeText(CompanyViewApplicators.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            while(cursor.moveToNext()){
//                name.add(cursor.getString(0));
//                emailapl.add(cursor.getString(1));
//                category.add(cursor.getString(2));
//            }
//        }
//    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyapplicatorrecycle);
        Bundle loginn = this.getIntent().getExtras();
        String emailcom = (String) loginn.get("email");

        textEmail = findViewById(R.id.textEmail);
        accept = (ImageButton) findViewById(R.id.buttonAccept);
        decline = (ImageButton) findViewById(R.id.buttonDecline);
        cv = (ImageButton) findViewById(R.id.buttonCV);

        db = new DatabaseJava(this);
        emailapl = new ArrayList<>(position);
        category = new ArrayList<>(position);
        name = new ArrayList<>(position);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter7(this, name, emailapl, category, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        if(loginn != null){
            accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Email = textEmail.getText().toString();

                    if (Email.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean check = db.checkApplicator(emailcom, Email);
                        if (check == true){
                            Cursor cursor = db.searchApplicatorsCom(emailcom, Email);
                            if (cursor.moveToFirst()){
                                aplmail = (cursor.getString(0));
                                nama = (cursor.getString(1));
                                kategori = (cursor.getString(2));
                            }
                            System.out.println(aplmail);
                            Cursor cursor1 = db.CompanyUsername(emailcom);
                            db.insertDataStatus(nama, aplmail, kategori, emailcom, "Accepted");
                            db.deleteDataApplicator(emailcom, aplmail);
                            Toast.makeText(getApplicationContext(), "Applicator Accepted!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), CompanyMain.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Email = textEmail.getText().toString();

                    if (Email.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean check = db.checkApplicator(emailcom, Email);
                        if (check == true){
                            Cursor cursor = db.searchApplicatorsCom(emailcom, Email);
                            if (cursor.moveToFirst()){
                                aplmail = (cursor.getString(0));
                                nama = (cursor.getString(1));
                                kategori = (cursor.getString(2));
                            }
                            db.insertDataStatus(nama, aplmail, kategori, emailcom, "Declined");
                            db.deleteDataApplicator(emailcom, aplmail);
                            Toast.makeText(getApplicationContext(), "Applicator Declined!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), CompanyMain.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Email = textEmail.getText().toString();
                    startActivity(new Intent(getApplicationContext(), CompanyEditJob.class));
                }
            });

        }
    }

    private void displaydata(){
        Bundle loginn = this.getIntent().getExtras();
        String email = (String) loginn.get("email");
        Cursor cursor = db.searchApplicators(email);
        if (cursor.getCount()==0){
            Toast.makeText(CompanyViewApplicators.this, "No Information can be shown!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                emailapl.add(cursor.getString(1));
                category.add(cursor.getString(2));
            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Bundle loginn = this.getIntent().getExtras();
        String email = (String) loginn.get("email");

        Intent intent = new Intent(getApplicationContext(), CompanyApplicatorDesc.class);
        intent.putExtra("category", String.valueOf((category.get(position))));
        intent.putExtra("name", String.valueOf((name.get(position))));
        intent.putExtra("emailapl", String.valueOf((emailapl.get(position))));

        startActivity(intent);
    }

}
