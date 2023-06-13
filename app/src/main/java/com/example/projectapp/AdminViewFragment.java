package com.example.projectapp;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class AdminViewFragment extends Fragment {
    public DatabaseJava db;
    private ImageButton Job;
    private ImageButton Resume;
    private ImageButton deleteAllJob;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_admin_view, container, false);

        Job = view.findViewById(R.id.buttonJobs);
        Resume = view.findViewById(R.id.buttonResume);
        deleteAllJob = view.findViewById(R.id.deletealljobButton);

        Job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminJobList.class));
            }
        });

        Resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getContext(), AdminSDCompany.class));
            }
        });

        deleteAllJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Delete All Job Data");
                builder.setMessage("Do you really want to delete all data?");
                builder.setCancelable(true);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteAllJobs();
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

        return view;
    }

}