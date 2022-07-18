package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.model.orderHistoryData;

import java.util.ArrayList;
import java.util.List;

public class Orderview extends AppCompatActivity {
    TextView orderview_name,orderview_address,orderview_phone,orderview_totalgross,orderview_totalprice,orderview_status;
    RecyclerView orderview_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        orderview_name=findViewById(R.id.orderview_name);
        orderview_address=findViewById(R.id.orderview_address);
        orderview_phone=findViewById(R.id.orderview_phone);
        orderview_rv=findViewById(R.id.orderview_rv);
        orderview_totalgross=findViewById(R.id.totalgross_tv);
        orderview_totalprice=findViewById(R.id.totalprice_tv);
        orderview_status=findViewById(R.id.orderstatus_tv);

        Bundle b=getIntent().getExtras();
        int getPosition= (int) b.get("orderid");
        String getQuantityy=  b.getString("getquantity");
        String getTotalPrice= b.getString("gettotalprice");

        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
        ArrayList<orderHistoryData>arrayList=sqLiteData.getOrder(getPosition);

        orderview_name.setText(arrayList.get(0).getOrdername());
        orderview_address.setText(arrayList.get(0).getOrderaddress());
        orderview_phone.setText(arrayList.get(0).getOrderphone()+"/"+arrayList.get(0).getOrderphone2());
        orderview_status.setText("Order Status : "+arrayList.get(0).getOrderstats());


        orderview_totalgross.setText(getQuantityy+" Kg");

        if(Integer.parseInt(getTotalPrice)<500)
        {
            orderview_totalprice.setText("₹"+getTotalPrice+"/-\n(Including ₹50 DeliveryCharge)");
        }
     else
        {
            orderview_totalprice.setText("₹"+getTotalPrice+"/-");
        }



        List<FruitData> newdata=new ArrayList<>();
        String[] id=arrayList.get(0).getOrderfruitID().split(",");
        newdata=(sqLiteData.getOrderData(id));


        ArrayList<orderHistoryData> getQuantity=null;
        String[] quantity=arrayList.get(0).getOrderWeight().split(",");


        orderview_rv.setLayoutManager(new LinearLayoutManager(this));
        OrderViewAdapter orderViewAdapter=new OrderViewAdapter(newdata,this,quantity);
        orderview_rv.setAdapter(orderViewAdapter);


//
//        orderview_rv.setLayoutManager(new LinearLayoutManager(this));
//        OrderViewAdapter orderViewAdapter=new OrderViewAdapter(newdata,this,quantity[newdata.size()]);
//        orderview_rv.setAdapter(orderViewAdapter);




    }
}