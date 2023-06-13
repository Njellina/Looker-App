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

public class AdminSearchFragment extends Fragment {
    public DatabaseJava db;
    private ImageButton ApplicantSD;
    private ImageButton CompanySD;
    private ImageButton deleteAllHistory;
    private ImageButton deleteAllApplicators;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_admin_search, container, false);

        ApplicantSD = view.findViewById(R.id.ApplicantSDButton);
        CompanySD = view.findViewById(R.id.CompanySDButton);
        deleteAllHistory = view.findViewById(R.id.deleteallhistoryButton);
        deleteAllApplicators = view.findViewById(R.id.deleteallapplicatorsButton);

        ApplicantSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminSDApplicant.class));
            }
        });

        CompanySD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminSDCompany.class));
            }
        });

        deleteAllHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Delete All History Data");
                builder.setMessage("Do you really want to delete all data?");
                builder.setCancelable(true);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteAllHistory();
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

        deleteAllApplicators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Delete All Applicators Data");
                builder.setCancelable(false);
                builder.setMessage("Do you really want to delete all data?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteAllApplicators();
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