package com.example.restaurant.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restaurant.MainActivity2;
import com.example.restaurant.R;

import java.util.List;

import com.example.restaurant.Model.ListItem;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {

    private Context context;//context howa lmo7tawa name description age
    private List<ListItem> listitems;

    public MyAdaptor (Context context, List listitems){
        this.context = context;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public MyAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdaptor.ViewHolder holder, int position) {
        ListItem item = listitems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.age.setText(item.getAge());
        holder.image.setImageResource(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView description;
        private TextView age;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);//pour la fonction onClick
            name = itemView.findViewById(R.id.textView1);
            description = itemView.findViewById(R.id.textView2);
            age = itemView.findViewById(R.id.textView3);
            image = itemView.findViewById(R.id.imageView1);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ListItem item = listitems.get(position);

            Intent intent = new Intent(context, MainActivity2.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("age", item.getAge());
            intent.putExtra("image", item.getImage());
            context.startActivity(intent);
            //Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
