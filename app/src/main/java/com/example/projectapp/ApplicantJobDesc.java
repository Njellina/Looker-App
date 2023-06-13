package com.example.projectapp;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ApplicantJobDesc extends AppCompatActivity {
    public DatabaseJava db;
    TextView textCategory;
    TextView textEmail;
    TextView textName;
    TextView textAddress;
    TextView textSalary;
    TextView textDescription;
    ImageButton Apply;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    int sal;
    String Name, email, description;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantjobdesc);
        Bundle loginn = this.getIntent().getExtras();
        String emailapl = (String) loginn.get("emailapl");

        db = new DatabaseJava(this);
        String name = getIntent().getStringExtra("name");
        String category = getIntent().getStringExtra("category");
        String city = getIntent().getStringExtra("city");
        String salary = getIntent().getStringExtra("salary");

        textCategory = findViewById(R.id.textCategory);
        textEmail = findViewById(R.id.textEmail);
        textName = findViewById(R.id.textName);
        textAddress = findViewById(R.id.textAddress);
        textSalary = findViewById(R.id.textSalary);
        textDescription = findViewById(R.id.textDescription);
        Apply = (ImageButton) findViewById(R.id.buttonApply);

        Cursor cursor1 = db.ApplicantUsername(emailapl);
        if (cursor1.moveToFirst()){
            Name = (cursor1.getString(0));
        }


        Cursor cursor = db.searchJobInformation(name, category, salary);
        if (cursor.moveToFirst()){
            email = cursor.getString(0);
            description = cursor.getString(1);
            textCategory.setText(category);
            textEmail.setText(email);
            textName.setText(name);
            textAddress.setText(city);
            textSalary.setText(salary);
            textDescription.setText(description);
        }
        sal = Integer.parseInt(salary);

        Apply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(ApplicantJobDesc.this);
                builder.setMessage("Do you want to apply for this job?");
                builder.setCancelable(true);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.insertDataHistory(emailapl, email, name, category, city, sal);
                        db.insertDataApplicators(email, emailapl, Name, category);
                        Toast.makeText(getApplicationContext(), "Successfully Applied!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

}
