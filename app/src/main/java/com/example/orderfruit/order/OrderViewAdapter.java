package com.example.orderfruit.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.R;
import com.example.orderfruit.model.FruitData;

import java.util.List;

public class OrderViewAdapter extends RecyclerView.Adapter<OrderViewAdapter.holder> {
    List<FruitData> fruitData;
    Context context;
   String[] OrderData;

    public OrderViewAdapter(List<FruitData> fruitData, Context context, String[] orderData) {
        this.fruitData = fruitData;
        this.context = context;
        OrderData = orderData;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.orderview_row,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

           holder.fruit_name.setText(fruitData.get(position).getFruit_name());
           holder.fruit_price.setText(String.valueOf("₹"+fruitData.get(position).getFruit_price())+"/-");

           if(fruitData.get(position).getFruit_name().contains("Coconuts"))
           {
               holder.fruit_quantity.setText(OrderData[position]+" Piece");
           }
           else
           {
               holder.fruit_quantity.setText(OrderData[position]+" Kg");
           }
           int TotalPrice=Integer.parseInt(OrderData[position].trim());
           holder.fruit_final_price.setText("₹"+String.valueOf(TotalPrice*fruitData.get(position).getFruit_price())+"/-");











    }

    @Override
    public int getItemCount() {
        return fruitData.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView fruit_name,fruit_price,fruit_quantity,fruit_final_price;
        public holder(@NonNull View itemView) {
            super(itemView);
            fruit_name=itemView.findViewById(R.id.orderview_rv_fname);
            fruit_price=itemView.findViewById(R.id.orderview_rv_fprice);
            fruit_quantity=itemView.findViewById(R.id.orderview_rv_fquantity);
            fruit_final_price=itemView.findViewById(R.id.orderview_rv_finalprice);
        }
    }
}
