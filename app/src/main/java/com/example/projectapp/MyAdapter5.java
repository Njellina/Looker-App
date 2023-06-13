package com.example.projectapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {
    private Context context;
    private ArrayList category, name, email, city, salary;

    public MyAdapter5(Context context, ArrayList category, ArrayList name, ArrayList email, ArrayList city, ArrayList salary) {
        this.context = context;
        this.category = category;
        this.name = name;
        this.email = email;
        this.city = city;
        this.salary = salary;
    }

    @NonNull
    @Override
    public MyAdapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.applicanthistory, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter5.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.category.setText(String.valueOf((category.get(position))));
        holder.name.setText(String.valueOf((name.get(position))));
        holder.email.setText(String.valueOf((email.get(position))));
        holder.city.setText(String.valueOf((city.get(position))));
        holder.salary.setText(String.valueOf((salary.get(position))));
    }

    @Override
    public int getItemCount() {
        return email.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category, name, email, city, salary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.textCategory);
            name = itemView.findViewById(R.id.textCompany);
            email = itemView.findViewById(R.id.textEmail);
            city = itemView.findViewById(R.id.textCity);
            salary = itemView.findViewById(R.id.textSalary);
        }
    }
}



