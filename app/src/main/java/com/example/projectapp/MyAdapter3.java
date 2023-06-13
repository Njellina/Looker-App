package com.example.projectapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    private Context context;
    private ArrayList id, category, city, description, salary;

    public MyAdapter3(Context context, ArrayList id, ArrayList category, ArrayList city, ArrayList description, ArrayList salary) {
        this.context = context;
        this.id = id;
        this.category = category;
        this.city = city;
        this.description = description;
        this.salary = salary;
    }

    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.companyviewjob, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter3.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.id.setText(String.valueOf((id.get(position))));
        holder.category.setText(String.valueOf((category.get(position))));
        holder.city.setText(String.valueOf((city.get(position))));
        holder.description.setText(String.valueOf((description.get(position))));
        holder.salary.setText(String.valueOf((salary.get(position))));
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, category, city, description, salary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textID);
            category = itemView.findViewById(R.id.textCategory);
            city = itemView.findViewById(R.id.textCity);
            description = itemView.findViewById(R.id.textDescription);
            salary = itemView.findViewById(R.id.textSalary);
        }
    }
}



