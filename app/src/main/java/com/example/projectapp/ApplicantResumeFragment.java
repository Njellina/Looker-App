package com.example.projectapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class ApplicantResumeFragment extends Fragment {
    DatabaseJava db;
    private ImageButton ViewCV;
    private ImageButton UploadCV;
    private ImageButton DeleteCV;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_applicant_resume, container, false);

        db = new DatabaseJava(getContext());
        ViewCV = view.findViewById(R.id.buttonViewCV);
        UploadCV = view.findViewById(R.id.buttonUploadCV);
        DeleteCV = view.findViewById(R.id.buttonDeleteCV);
        Bundle loginn = getActivity().getIntent().getExtras();
        String email = (String) loginn.get("name");

        ViewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(getContext(), ApplicantViewCV.class);
                view.putExtra("email", email);
                startActivity(view);
            }
        });

        UploadCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ApplicantAddCV.class));
            }
        });

        DeleteCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkCV = db.checkCV(email);
                if (checkCV == true){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Delete CV");
                    builder.setCancelable(false);
                    builder.setMessage("Do you really want to delete your CV?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            db.deleteDataCV(email);
                            Toast.makeText(getContext(), "Successfully Deleted!", Toast.LENGTH_SHORT).show();
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
                else{
                    Toast.makeText(getContext(), "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}

