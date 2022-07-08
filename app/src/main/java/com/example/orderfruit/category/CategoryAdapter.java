package com.example.orderfruit.category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.Categories.mostlyviewed.MostlyViewd;
import com.example.orderfruit.Categories.popular.PopularFruits;
import com.example.orderfruit.Categories.seasonal.SeasonalFruits;
import com.example.orderfruit.Categories.todaysDeal.TodaysDeal;
import com.example.orderfruit.R;
import com.example.orderfruit.Categories.allcatagories.AllCatagoriesMain;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.holder> {

ArrayList<CategoryData>category;
    Context context;

    public CategoryAdapter(ArrayList<CategoryData> category, Context context) {
        this.category = category;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.category_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        holder.Category_image.setImageResource(category.get(position).getCategory_image());
        holder.Category_name.setText(category.get(position).getCategory_name());

        holder.Category_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(position==0)
                {
                    Intent intent=new Intent(context, AllCatagoriesMain.class);
                    context.startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(context, TodaysDeal.class);
                    context.startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent=new Intent(context, SeasonalFruits.class);
                    context.startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent=new Intent(context, PopularFruits.class);
                    context.startActivity(intent);
                }
                else
                {
                    Intent intent=new Intent(context, MostlyViewd.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return category.size();
    }


    class holder extends RecyclerView.ViewHolder {
        TextView Category_name;
        ImageView Category_image;

        public holder(@NonNull View itemView) {
            super(itemView);
            Category_name = itemView.findViewById(R.id.category_name);
            Category_image = itemView.findViewById(R.id.category_image);
        }

    }
}