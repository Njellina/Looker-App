package com.example.projectapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {
    private Context context;
    private ArrayList name, email, password, phone, address;

    public MyAdapter1(Context context, ArrayList name, ArrayList email, ArrayList password, ArrayList phone, ArrayList address) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @NonNull
    @Override
    public MyAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admincompanylist, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter1.MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf((name.get(position))));
        holder.email.setText(String.valueOf((email.get(position))));
        holder.password.setText(String.valueOf((password.get(position))));
        holder.phone.setText(String.valueOf((phone.get(position))));
        holder.address.setText(String.valueOf((address.get(position))));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, password, phone, address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textUsername);
            email = itemView.findViewById(R.id.textEmail);
            password = itemView.findViewById(R.id.textPassword);
            phone = itemView.findViewById(R.id.textPhone);
            address = itemView.findViewById(R.id.textAddress);
        }
    }

}
