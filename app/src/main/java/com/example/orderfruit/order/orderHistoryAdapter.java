package com.example.orderfruit.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.R;
import com.example.orderfruit.model.orderHistoryData;

import java.util.ArrayList;

public class orderHistoryAdapter extends RecyclerView.Adapter<orderHistoryAdapter.holder> {
    ArrayList<orderHistoryData>arrayList=new ArrayList<>();
    Context context;

    public orderHistoryAdapter(ArrayList<orderHistoryData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.order_history_row,parent,false);
        return new holder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {

        holder.orderDate.setText("Date : "+arrayList.get(position).getOrderdate());
        String name=arrayList.get(position).getOrdername();


        String status= arrayList.get(position).getOrderstats();
//        if(status.contains("Payment Successful"))
//        {
            holder.orderstatus.setText("Order Status : "+status);
            holder.orderstatus.setTextColor(Color.parseColor("#0CEA15"));

            if(status.contains("Payment Successful"))
            {

            }
            else
            {
                holder.orderstatus.setText("Order Status : Payment Failed");
                holder.orderstatus.setTextColor(Color.parseColor("#FF0000"));
            }

            holder.orderdetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Intent intent=new Intent(context, Orderview.class);
                        intent.putExtra("orderid",arrayList.get(position).getOrderid());
                        intent.putExtra("getquantity",arrayList.get(position).getOrderquanity());
                        intent.putExtra("gettotalprice",arrayList.get(position).getOrderprice());
                        context.startActivity(intent);

                }
            });
      //  }
//        else
//        {
                    //}

        holder.ordertrackno.setText("Track NO : #4444");


        int a= Integer.parseInt(arrayList.get(position).getOrderprice());
        if(a<500)
        {
          holder.orderprice.setText("Price : ₹"+String.valueOf(a+50));
        }
        else
        {
            holder.orderprice.setText("Price : ₹"+arrayList.get(position).getOrderprice());
        }


        holder.orderquantity.setText("Quantity : "+arrayList.get(position).getOrderquanity()+" KG");


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView orderDate,orderstatus,ordertrackno,orderprice,orderquantity;
        Button orderdetails;
        public holder(@NonNull View itemView) {
            super(itemView);
            orderDate=itemView.findViewById(R.id.orderhistory_date);
            orderstatus=itemView.findViewById(R.id.orderhistory_status);
            ordertrackno=itemView.findViewById(R.id.orderhistory_trackno);
            orderprice=itemView.findViewById(R.id.orderhistory_price);
            orderquantity=itemView.findViewById(R.id.orderhistory_quantity);
            orderdetails=itemView.findViewById(R.id.orderhistory_details);
        }
    }
}
