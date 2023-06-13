package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private ImageButton regis;
    private ImageButton login;
    private ImageButton admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//        ImageButton regis = findViewById(R.id.regis);
        login = (ImageButton) findViewById(R.id.login);
        regis = (ImageButton) findViewById(R.id.regis);
        admin = (ImageButton) findViewById(R.id.admin);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        regis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        admin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoginAdmin.class));
            }
        });
    }
}