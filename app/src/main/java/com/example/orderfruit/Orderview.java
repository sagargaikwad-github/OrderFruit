package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.model.orderHistoryData;

import java.util.ArrayList;

public class Orderview extends AppCompatActivity {
    TextView orderview_name,orderview_address,orderview_phone;
    RecyclerView orderview_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);

        orderview_name=findViewById(R.id.orderview_name);
        orderview_address=findViewById(R.id.orderview_address);
        orderview_phone=findViewById(R.id.orderview_phone);
        orderview_rv=findViewById(R.id.orderview_rv);

        Bundle b=getIntent().getExtras();
        int getPosition= (int) b.get("position");
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
        ArrayList<orderHistoryData>arrayList=sqLiteData.getHistory();

        orderview_name.setText(arrayList.get(getPosition).getOrdername());
        orderview_address.setText(arrayList.get(getPosition).getOrderaddress());
        orderview_phone.setText(arrayList.get(getPosition).getOrderphone()+"/"+arrayList.get(getPosition).getOrderphone2());


        ArrayList<orderHistoryData> arrayList1= sqLiteData.orderView(getPosition);

        orderview_rv.setLayoutManager(new LinearLayoutManager(this));
        OrderViewAdapter orderViewAdapter=new OrderViewAdapter(arrayList1,this,getPosition);
        orderview_rv.setAdapter(orderViewAdapter);




    }
}