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

public class MyAdapter8 extends RecyclerView.Adapter<MyAdapter8.MyViewHolder> {
    private Context context;
    private ArrayList category, name, emailapl, comname, status;

    public MyAdapter8(Context context, ArrayList category, ArrayList name, ArrayList emailapl, ArrayList comname, ArrayList status) {
        this.context = context;
        this.name = name;
        this.emailapl = emailapl;
        this.category = category;
        this.comname = comname;
        this.status = status;
    }

    @NonNull
    @Override
    public MyAdapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.applicantmailbox, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter8.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name.setText(String.valueOf((name.get(position))));
        holder.emailapl.setText(String.valueOf((emailapl.get(position))));
        holder.category.setText(String.valueOf((category.get(position))));
        holder.comname.setText(String.valueOf((comname.get(position))));
        holder.status.setText(String.valueOf((status.get(position))));
    }

    @Override
    public int getItemCount() {
        return emailapl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, emailapl, category, comname, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            emailapl = itemView.findViewById(R.id.textEmail);
            name = itemView.findViewById(R.id.textName);
            category = itemView.findViewById(R.id.textCategory);
            comname = itemView.findViewById(R.id.textCompany);
            status = itemView.findViewById(R.id.textStatus);
        }
    }
}



