package com.example.projectapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private Context context;
    private ArrayList email, category, city, description, salary;

    public MyAdapter2(Context context, ArrayList email, ArrayList category,  ArrayList city, ArrayList description, ArrayList salary) {
        this.context = context;
        this.email = email;
        this.category = category;
        this.city = city;
        this.description = description;
        this.salary = salary;
    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adminjoblist, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {
        holder.email.setText(String.valueOf((email.get(position))));
        holder.category.setText(String.valueOf((category.get(position))));
        holder.city.setText(String.valueOf((city.get(position))));
        holder.description.setText(String.valueOf((description.get(position))));
        holder.salary.setText(String.valueOf((salary.get(position))));
    }

    @Override
    public int getItemCount() {
        return email.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email, category, city, description, salary;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.textEmail);
            category = itemView.findViewById(R.id.textCategory);
            city = itemView.findViewById(R.id.textCity);
            description = itemView.findViewById(R.id.textDescription);
            salary = itemView.findViewById(R.id.textSalary);
        }
    }

}
