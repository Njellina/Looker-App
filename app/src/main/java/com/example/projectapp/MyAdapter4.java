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

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder>{
    private final ApplicantJobInterface recyclerViewInterface;
    private Context context;
    private ArrayList name, category, city, salary;

    public <RecyclerViewInterface> MyAdapter4(Context context, ArrayList name, ArrayList category, ArrayList city, ArrayList salary, ApplicantJobInterface recyclerViewInterface) {
        this.context = context;
        this.name = name;
        this.category = category;
        this.city = city;
        this.salary = salary;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyAdapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.applicantviewjob, parent, false);

        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter4.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(String.valueOf((name.get(position))));
        holder.category.setText(String.valueOf((category.get(position))));
        holder.city.setText(String.valueOf((city.get(position))));
        holder.salary.setText(String.valueOf((salary.get(position))));

    }

    @Override

    public int getItemCount() {
        return category.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, category, city, salary;

        public MyViewHolder(@NonNull View itemView, ApplicantJobInterface recyclerViewInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.textCompany);
            category = itemView.findViewById(R.id.textCategory);
            city = itemView.findViewById(R.id.textCity);
            salary = itemView.findViewById(R.id.textSalary);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }

                }
            });
        }
    }
}



