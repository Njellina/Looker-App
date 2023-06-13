package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ApplicantSearchFragment extends Fragment {
    private ImageButton SearchJobs;
    private ImageButton History;
    private ImageButton Mailbox;

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_applicant_search, container, false);

        SearchJobs = view.findViewById(R.id.ClickHere1);
        History = view.findViewById(R.id.ClickHere3);
        Mailbox = view.findViewById(R.id.ClickHere2);

        Bundle loginn = getActivity().getIntent().getExtras();
        String email = (String) loginn.get("name");

        Intent search = new Intent(getContext(), ApplicantJobSearch.class);
        search.putExtra("email", email);
        Intent history = new Intent(getContext(), ApplicantHistory.class);
        history.putExtra("email", email);
        Intent mailbox = new Intent(getContext(), ApplicantMailbox.class);
        mailbox.putExtra("email", email);

        SearchJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(search);
            }
        });

        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(history);
            }
        });

        Mailbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mailbox);
            }
        });

        return view;
    }


}