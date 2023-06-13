package com.example.projectapp;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class ApplicantProfile extends AppCompatActivity {
        public DatabaseJava db;
        private ImageButton newBio;
        private ImageButton editBio;
        private Button back;
        private TextView Name;
        private TextView Email;
        private TextView Phone;
        private TextView Address;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.applicantprofile);

            db = new DatabaseJava(this);
            Name = findViewById(R.id.textName);
            Email = findViewById(R.id.textEmail);
            Phone = findViewById(R.id.textPhone);
            Address = findViewById(R.id.textAddress);
            newBio = (ImageButton) findViewById(R.id.buttonNewBio);
            editBio = (ImageButton) findViewById(R.id.buttonEditBio);
            back = (Button) findViewById(R.id.buttonBack);

            Bundle loginn = this.getIntent().getExtras();
            if(loginn != null){
                String name = (String) loginn.get("name");
                Cursor cursor = db.ApplicantProfile(name);
                if (cursor.moveToFirst()){
                    Name.setText(cursor.getString(0));
                    Email.setText(cursor.getString(1));
                    Phone.setText(cursor.getString(2));
                    Address.setText(cursor.getString(3));
                }

                newBio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent done = new Intent(getApplicationContext(), ApplicantNewBio.class);
                        done.putExtra("name", name);
                        startActivity(done);
                    }
                });

                editBio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent done = new Intent(getApplicationContext(), ApplicantEditBio.class);
                        done.putExtra("name", name);
                        startActivity(done);
                    }
                });

                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent done = new Intent(getApplicationContext(), ApplicantMain.class);
                        done.putExtra("name", name);
                        startActivity(done);
                    }
                });

            }
        }
    }
