package com.example.projectapp;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class ApplicantHomeFragment extends Fragment {
    public DatabaseJava db;
    private TextView Name;
    private ImageButton Profile;
    private ImageButton logout;

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  LayoutInflater.from(getContext()).inflate(R.layout.fragment_applicant_home, container, false);

        db = new DatabaseJava(getActivity());
        Name = view.findViewById(R.id.textName);
        Profile = view.findViewById(R.id.profileButton);
        logout = view.findViewById(R.id.buttonLogout);

        Bundle loginn = getActivity().getIntent().getExtras();
        if(loginn != null){
            String name = (String) loginn.get("name");
            Cursor cursor = db.ApplicantUsername(name);
            if (cursor.moveToFirst()){
                Name.setText(cursor.getString(0));
            }
            Intent login = new Intent(getContext(), ApplicantProfile.class);
            login.putExtra("name", name);

            Profile.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivity(login);
                }
            });
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        return view;
    }

}