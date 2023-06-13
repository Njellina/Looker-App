////package com.example.projectapp;
////
////import android.Manifest;
////import android.content.Intent;
////import android.content.pm.PackageManager;
////import android.database.Cursor;
////import android.graphics.Bitmap;
////import android.net.Uri;
////import android.os.Bundle;
////import android.provider.MediaStore;
////import android.support.annotation.NonNull;
////import android.support.v4.app.ActivityCompat;
////import android.support.v4.content.ContextCompat;
////import android.support.v7.app.AppCompatActivity;
////import android.view.View;
////import android.widget.EditText;
////import android.widget.ImageView;
////import android.widget.TextView;
////import android.widget.Toast;
////import net.gotev.uploadservice.MultipartUploadRequest;
////import net.gotev.uploadservice.UploadNotificationConfig;
////import java.util.UUID;
////
////
////public class ApplicantUploadCV extends AppCompatActivity {
////    DatabaseJava db;
////    ImageView imageView;
////    EditText editTextName, editTextEmail;
////    private static final int STORAGE_PERMISSION_CODE = 4655;
////    private int PICK_IMAGE_REQUEST = 1;
////    private Uri filepath;
////    private Bitmap bitmap;
////    TextView tv;
//////    public static final String UPLOAD_URL = "http://10.0.2.2/android_db_pool/index.php?add=333";
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.applicantuploadcv);
////
////        requestStoragePermission();
////
////        db = new DatabaseJava(this);
////        imageView = (ImageView) findViewById(R.id.imageView);
////        editTextName = (EditText) findViewById(R.id.textName);
////        editTextEmail = (EditText) findViewById(R.id.textEmail);
////        tv = (TextView)findViewById(R.id.tv4);
////    }
////
////
////    private void requestStoragePermission() {
////
////        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
////            return;
////
////        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
////
////        }
////        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
////    }
////
////    @Override
////    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
////        if (requestCode == STORAGE_PERMISSION_CODE) {
////            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
////
////            } else {
////                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
////            }
////        }
////    }
////
////    private void ShowFileChooser() {
////        Intent intent = new Intent();
////        intent.setType("image/*");
////        intent.setAction(Intent.ACTION_GET_CONTENT);
////        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
////
////    }
////
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////
////        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
////
////            filepath = data.getData();
////            try {
////
////                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
////                imageView.setImageBitmap(bitmap);
////                tv.setText(filepath.toString());
////            } catch (Exception ex) {
////
////            }
////        }
////    }
////
////    public void selectImage(View view)
////    {
////
////        ShowFileChooser();
////    }
////
////
////    private String getPath(Uri uri) {
////
////        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
////        cursor.moveToFirst();
////        String document_id = cursor.getString(0);
////        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
////        cursor = getContentResolver().query(
////                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, MediaStore.Images.Media._ID + "=?", new String[]{document_id}, null
////        );
////        cursor.moveToFirst();
////        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
////        cursor.close();
////        return path;
////    }
////
////    private void uploadImage() {
////        String name = editTextName.getText().toString().trim();
////        String email = editTextEmail.getText().toString().trim();
////        String path = getPath(filepath);
////
////        Boolean checkCV = db.checkCVApplicant(name, email);
////        if (checkCV == true){
////            try {
////                String uploadId = UUID.randomUUID().toString();
////                new MultipartUploadRequest(this, uploadId, UPLOAD_URL).addFileToUpload(path, "upload").addParameter("t1", name).addParameter("t2", email)
////                        .setNotificationConfig(new UploadNotificationConfig())
////                        .setMaxRetries(3)
////                        .startUpload();
////            }
////            catch (Exception ex) {
////            }
////            db.insertDataCV(name, email, path);
////        }
////        else{
////            Toast.makeText(getApplicationContext(), "Invalid Name or/and Email!", Toast.LENGTH_SHORT).show();
////        }
////    }
////
////    public void saveData(View view) {
////        uploadImage();
////    }
////}
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.widget.Toast;
//
//public class ApplicantUploadCV extends AppCompatActivity  {
//    private static final int PICK_DOCUMENT_REQUEST = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void selectDocument(View view) {
//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        intent.setType("*/*"); // Memilih semua jenis file
//        startActivityForResult(Intent.createChooser(intent, "Pilih Dokumen"), PICK_DOCUMENT_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_DOCUMENT_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            Uri selectedDocumentUri = data.getData();
//            // Lakukan operasi upload dengan dokumen yang telah dipilih
//            // Implementasikan logika upload dokumen ke server atau penyimpanan lainnya
//            // Misalnya, menggunakan Retrofit, Volley, atau library lainnya
//            // ...
//
//            // Tampilkan pesan berhasil upload
//            Toast.makeText(this, "Document Successfuly Uploaded", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
