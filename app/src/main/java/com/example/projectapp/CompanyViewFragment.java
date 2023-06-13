package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CompanyViewFragment extends Fragment {
    private ImageButton AddJob;
    private ImageButton ViewJob;
    private ImageButton ViewApplicant;
    private ImageButton ViewClosedJob;

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_company_view, container, false);

        ViewJob = view.findViewById(R.id.buttonViewJob);
        ViewApplicant = view.findViewById(R.id.buttonViewApplicant);
        ViewClosedJob = view.findViewById(R.id.buttonClosedJob);
        AddJob = view.findViewById(R.id.buttonAdd);

        Bundle loginn = getActivity().getIntent().getExtras();
        if(loginn != null){
            String name = (String) loginn.get("name");
            Intent View = new Intent(getContext(), CompanyViewJob.class);
            Intent Add = new Intent(getContext(), CompanyAddJob.class);
            Intent ClosedJob = new Intent(getContext(), CompanyViewClosedJob.class);
            Intent Applicators = new Intent(getContext(), CompanyViewApplicators.class);
            View.putExtra("name", name);
            Add.putExtra("name", name);
            ClosedJob.putExtra("name", name);
            Applicators.putExtra("email", name);

            ViewJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(View);
                }
            });

            AddJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(Add);
                }
            });

            ViewApplicant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(Applicators);
                }
            });

            ViewClosedJob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(ClosedJob);
                }
            });

        }

        return view;
    }

}