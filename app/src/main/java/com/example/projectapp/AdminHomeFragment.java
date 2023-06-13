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

public class AdminHomeFragment extends Fragment {
    public DatabaseJava db;
    private ImageButton ApplicantInfo;
    private ImageButton CompanyInfo;
    private ImageButton deleteAllApplicant;
    private ImageButton deleteAllCompany;
    private ImageButton logout;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_admin_home, container, false);

        db = new DatabaseJava(getActivity());
        ApplicantInfo = view.findViewById(R.id.ApplicantButton);
        CompanyInfo = view.findViewById(R.id.CompanyButton);
        deleteAllApplicant = view.findViewById(R.id.deleteallapplicantButton);
        deleteAllCompany = view.findViewById(R.id.deleteallcompanyButton);
        logout = view.findViewById(R.id.buttonLogout);

        ApplicantInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminApplicantList.class));
            }
        });

        CompanyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdminCompanyList.class));
            }
        });

        deleteAllApplicant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Delete All Applicant Data");
                builder.setMessage("Do you really want to delete all data?");
                builder.setCancelable(true);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteAllApplicant();
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

        deleteAllCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Delete All Company Data");
                builder.setCancelable(false);
                builder.setMessage("Do you really want to delete all data?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.deleteAllCompany();
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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        return view;
    }
}
