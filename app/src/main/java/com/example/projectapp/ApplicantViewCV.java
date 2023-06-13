package com.example.projectapp;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class ApplicantViewCV extends AppCompatActivity {
    DatabaseJava db;
    ImageView photoCV;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantviewcv);

        db = new DatabaseJava(this);
        photoCV = (ImageView) findViewById(R.id.imageView);
        back = (Button) findViewById(R.id.buttonBack);
        Bundle view = this.getIntent().getExtras();
        String email = (String) view.get("email");
        Cursor cursor = db.searchCV(email);

        if (cursor.moveToFirst()){
            byte[] image = cursor.getBlob(0);
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0 , image.length);
            photoCV.setImageBitmap(bmp);
        }
    }
}
