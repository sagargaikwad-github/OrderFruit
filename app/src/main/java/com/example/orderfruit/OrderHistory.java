package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.orderfruit.model.SQLiteData;

public class OrderHistory extends AppCompatActivity {
    RecyclerView orderhistory_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order History");

        orderhistory_rv=findViewById(R.id.orderhistory_rv);

        SQLiteData sqLiteData=new SQLiteData(this);



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        orderHistoryAdapter orderHistoryAdapter=new orderHistoryAdapter(sqLiteData.getHistory(),this);
        orderhistory_rv.setLayoutManager(linearLayoutManager);
        orderhistory_rv.setAdapter(orderHistoryAdapter);





    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this,Dashboard_Activity.class);
        startActivity(intent);

    }
}