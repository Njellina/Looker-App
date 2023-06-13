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

public class MyAdapter7 extends RecyclerView.Adapter<MyAdapter7.MyViewHolder> {
    private final CompanyViewApplicatorInterface recyclerViewInterface;
    private Context context;
    private ArrayList name, emailapl, category;

    public <RecyclerViewInterface> MyAdapter7(Context context, ArrayList name, ArrayList emailapl, ArrayList category, CompanyViewApplicatorInterface recyclerViewInterface) {
        this.context = context;
        this.name = name;
        this.emailapl = emailapl;
        this.category = category;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyAdapter7.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.companyviewapplicators, parent, false);

        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter7.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.category.setText(String.valueOf((category.get(position))));
        holder.name.setText(String.valueOf((name.get(position))));
        holder.emailapl.setText(String.valueOf((emailapl.get(position))));
    }

    @Override
    public int getItemCount() {
        return emailapl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView category, name, emailapl;

        public MyViewHolder(@NonNull View itemView, CompanyViewApplicatorInterface recyclerViewInterface) {
            super(itemView);
            category = itemView.findViewById(R.id.textCategory);
            name = itemView.findViewById(R.id.textName);
            emailapl = itemView.findViewById(R.id.textEmail);

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



