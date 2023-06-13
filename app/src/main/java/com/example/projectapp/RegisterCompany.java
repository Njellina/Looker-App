package com.example.projectapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;
import android.util.Patterns;

public class RegisterCompany extends AppCompatActivity {

    private DatabaseJava db;
    private EditText CompanyName;
    private EditText CompanyEmail;
    private EditText CompanyPassword;
    private EditText CompanyPhone;
    private EditText CompanyAddress;

    private String name;
    private String email;
    private String password;
    private String phone1;
    private String address;

    private ImageButton login1;
    private ImageButton regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registercompany);

        db = new DatabaseJava(this);
        login1 = (ImageButton) findViewById(R.id.login1);
        regis = (ImageButton) findViewById(R.id.regis);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterCompany.this, LoginActivity.class));
            }
        });

        CompanyName = findViewById(R.id.textName);
        CompanyEmail = findViewById(R.id.textEmail);
        CompanyPassword = findViewById(R.id.textPassword);
        CompanyPhone = findViewById(R.id.textPhone);
        CompanyAddress = findViewById(R.id.textAddress);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = CompanyName.getText().toString();
                email = CompanyEmail.getText().toString();
                password = CompanyPassword.getText().toString();
                phone1 = CompanyPhone.getText().toString();
                address = CompanyAddress.getText().toString();

                if (name.isEmpty()) {
                    CompanyName.setError("Company name is required!");
                    CompanyName.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    CompanyEmail.setError("Company email is required!");
                    CompanyEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    CompanyEmail.setError("Please provide valid email!");
                    CompanyEmail.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    CompanyPassword.setError("Password is required!");
                    CompanyPassword.requestFocus();
                    return;
                }
                if (phone1.isEmpty()) {
                    CompanyPhone.setError("Company phone number is required!");
                    CompanyPhone.requestFocus();
                    return;
                }
                if (address.isEmpty()) {
                    CompanyAddress.setError("Company address is required!");
                    CompanyAddress.requestFocus();
                    return;
                }
                else {
                    Boolean checkuser = db.checkEmailCompany(email);
                    if (checkuser == false){
                        Boolean insert = db.insertDataCompany(name, email, password, phone1, address);
                        if (insert == true){
                            Toast.makeText(RegisterCompany.this, "Register Company Successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterCompany.this, MainActivity.class)); //blom bikin homeny
                        }
                        else{
                            Toast.makeText(RegisterCompany.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterCompany.this, "Email already exists! Please Log in!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}


