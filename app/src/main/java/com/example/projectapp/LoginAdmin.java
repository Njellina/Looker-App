package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity{

    private DatabaseJava db;
    private EditText textID;
    private EditText textCode;
    private String AdminID;
    private String AdminCode;
    private ImageButton login;
    private ImageButton login1;
    private ImageButton register1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginadmin);

        login = (ImageButton) findViewById(R.id.login);
        login1 = (ImageButton) findViewById(R.id.login1);
        register1 = (ImageButton) findViewById(R.id.register1);
        textID = findViewById(R.id.textID);
        textCode = findViewById(R.id.textCode);
        db = new DatabaseJava(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                AdminID = textID.getText().toString();
                AdminCode = textCode.getText().toString();

                if (AdminID.isEmpty() || AdminCode.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = db.checkAdmin(AdminID, AdminCode);
                    if (checkuserpass == true){
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginAdmin.this, AdminMain.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginAdmin.this, LoginActivity.class));
            }
        });

        register1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginAdmin.this, RegisterActivity.class));
            }
        });

    }
}



