package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;

public class RegisterApplicant extends AppCompatActivity{

    private DatabaseJava db;
    private EditText ApplicantName;
    private EditText ApplicantEmail;
    private EditText ApplicantPassword;
    private EditText ApplicantPhone;
    private EditText ApplicantAddress;

    private String name;
    private String email;
    private String password;
    private String phone1;
    private String address;

    private ImageButton login1;
    private ImageButton regis;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerapplicant);

        db = new DatabaseJava(this);
        login1 = (ImageButton) findViewById(R.id.login1);
        regis = (ImageButton) findViewById(R.id.regis);

        login1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RegisterApplicant.this, LoginActivity.class));
            }
        });

        ApplicantName = findViewById(R.id.textName);
        ApplicantEmail = findViewById(R.id.textEmail);
        ApplicantPassword = findViewById(R.id.textPassword);
        ApplicantPhone = findViewById(R.id.textPhone);
        ApplicantAddress = findViewById(R.id.textAddress);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ApplicantName.getText().toString();
                email = ApplicantEmail.getText().toString();
                password = ApplicantPassword.getText().toString();
                phone1 = ApplicantPhone.getText().toString();
                address = ApplicantAddress.getText().toString();

                if (name.isEmpty()) {
                    ApplicantName.setError("Name is required!");
                    ApplicantName.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    ApplicantEmail.setError("Email is required!");
                    ApplicantEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    ApplicantEmail.setError("Please provide valid email!");
                    ApplicantEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    ApplicantPassword.setError("Password is required!");
                    ApplicantPassword.requestFocus();
                    return;
                }
                if (phone1.isEmpty()) {
                    ApplicantPhone.setError("Phone number is required!");
                    ApplicantPhone.requestFocus();
                    return;
                }
                if (address.isEmpty()) {
                    ApplicantAddress.setError("Address is required!");
                    ApplicantAddress.requestFocus();
                    return;
                }
                else {
                    Boolean checkuser = db.checkEmailApplicant(email);
                    if (checkuser == false){
                        Boolean insert = db.insertDataApplicant(name, email, password, phone1, address);
                        if (insert == true){
                            Toast.makeText(RegisterApplicant.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterApplicant.this, MainActivity.class));
                        }
                        else{
                            Toast.makeText(RegisterApplicant.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterApplicant.this, "Email already exists! Please Log in!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}



