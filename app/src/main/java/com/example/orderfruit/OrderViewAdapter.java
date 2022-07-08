package com.example.orderfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.model.orderHistoryData;

import java.util.ArrayList;

public class OrderViewAdapter extends RecyclerView.Adapter<OrderViewAdapter.holder> {
    ArrayList<orderHistoryData>arrayList=new ArrayList<>();
    Context context;
    int POSITION;

    public OrderViewAdapter(ArrayList<orderHistoryData> arrayList, Context context, int POSITION) {
        this.arrayList = arrayList;
        this.context = context;
        this.POSITION = POSITION;
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
        int num=POSITION;

        String fruitid = arrayList.get(num).getOrderfruitID();

        String[] id = fruitid.split(",", 50);
        SQLiteData sqLiteData=new SQLiteData(context);

       ArrayList<FruitData>newdata=new ArrayList<>();

       for(int i=0;i<arrayList.size();i++)
       {
          newdata=sqLiteData.getOrderID(id[i]);
       }

       for(int i=0;i<newdata.size();i++)
       {
           holder.fruit_name.setText(newdata.get(i).getFruit_name());
       }



    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class holder extends RecyclerView.ViewHolder {
        TextView fruit_name,fruit_price,fruit_quantity;
        public holder(@NonNull View itemView) {
            super(itemView);
            fruit_name=itemView.findViewById(R.id.orderview_rv_fname);
            fruit_price=itemView.findViewById(R.id.orderview_rv_fquantity);
            fruit_quantity=itemView.findViewById(R.id.orderview_rv_fprice);
        }
    }
}
