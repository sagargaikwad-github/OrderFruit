package com.example.orderfruit.Categories.allcatagories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.R;


public class AllCatagoriesAdapter extends RecyclerView.Adapter<AllCatagoriesAdapter.holder> {
    String AllCatagories[]={"Apple","Mango","Berry","Nuts","Banana","Seedless"};

    Context context;

    public AllCatagoriesAdapter(String[] allCatagories, Context context) {
        AllCatagories = allCatagories;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.all_catagories_row,parent,false);
        return new holder(view);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
          holder.all_category_tv.setText(AllCatagories[position]);

          if(position==0)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_apple);

          }
          else if(position==1)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_mango);
          }
          else if(position==2)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_berry);
          }
          else if(position==3)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_nuts);
              holder.all_category_iv.setAlpha(0.9f);
          }
          else if(position==4)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_banana);

          } else if(position==5)
          {
              holder.all_category_iv.setImageResource(R.drawable.img_seedless);

          }




        holder.all_category_iv.setOnClickListener(new View.OnClickListener() {
             String apple="Apple";
             String mango="Mango";
             String berry="Berry";
             String DryFruit="DryFruit";
             String banana="Banana";
             String seedless="Seedless";

             @Override
             public void onClick(View view) {
                 if(position==0)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("Apple",apple);
                     context.startActivity(intent);
                 }
                 else if(position==1)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("Mango",mango);
                     context.startActivity(intent);
                 }
                 else if(position==2)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("Berry",berry);
                     context.startActivity(intent);
                 }
                 else if(position==3)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("DryFruit",DryFruit);
                     context.startActivity(intent);
                 }
                 else if(position==4)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("Banana",banana);
                     context.startActivity(intent);
                 } else if(position==5)
                 {
                     Intent intent=new Intent(context, View_All_Category.class);
                     intent.putExtra("Seedless",seedless);
                     context.startActivity(intent);
                 }

             }
         });



    }



    @Override
    public int getItemCount() {
        return AllCatagories.length;
    }

    class holder extends RecyclerView.ViewHolder {
        TextView all_category_tv;
        ImageView all_category_iv;
         public holder(@NonNull View itemView) {
             super(itemView);
             all_category_tv=itemView.findViewById(R.id.all_catagories_tv);
             all_category_iv=itemView.findViewById(R.id.all_catagories_iv);
         }
     }


}
