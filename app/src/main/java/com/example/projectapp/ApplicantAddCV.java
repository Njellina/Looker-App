package com.example.projectapp;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ApplicantAddCV extends AppCompatActivity {
    EditText email;
    Button Upload;
    Button Choose;
    ImageView viewTV;
    int requestcode = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicantaddcv);

        email = (EditText) findViewById(R.id.textEmail);
        Upload = (Button) findViewById(R.id.buttonUpload);
        Choose = (Button) findViewById(R.id.buttonChoose);
        viewTV = (ImageView) findViewById(R.id.viewTV);

        Choose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openfilechooser(v);
            }
        });

        Upload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onActivityResult(int requestcode, int resulcode, Intent data){
        Context context = getApplicationContext();
        super.onActivityResult(requestcode, resulcode, data);
        if(requestcode == requestcode && resulcode == Activity.RESULT_OK){
            if(data == null){
                return;
            }
            Uri uri = data.getData();
            Toast.makeText(context, uri.getPath(), Toast.LENGTH_SHORT).show();
        }
    }

    public void openfilechooser(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, requestcode);
    }

    protected void onResume() {
        super.onResume();
        if(!Utils.isPermissionGranted(this)){
            new AlertDialog.Builder(this).setTitle("All files permission")
                    .setMessage("Requires files permission")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            takePermission();
                        }
                    })
                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
        }
        else{
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }

    }

    private void takePermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            try{
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivityForResult(intent, 101);
            }
            catch (Exception e){
                e.printStackTrace();
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 101);
            }
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                    , 101);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0){
            if(requestCode==101){
                boolean readExt = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(!readExt){
                    takePermission();
                }
            }
        }
    }
}

