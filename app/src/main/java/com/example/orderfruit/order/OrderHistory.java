package com.example.orderfruit.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orderfruit.Dashboard_Activity;
import com.example.orderfruit.R;
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.OrderHistory.OrderHistoryModel;


import java.util.ArrayList;

public class OrderHistory extends AppCompatActivity {
    RecyclerView orderhistory_rv;
    LinearLayout orderhistory_noOrderLL;
    CommonDB commonDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Order History");
        actionBar.setDisplayHomeAsUpEnabled(true);

        orderhistory_rv = findViewById(R.id.orderhistory_rv);
        orderhistory_noOrderLL = findViewById(R.id.orderhistory_noOrderLL);

        commonDB = CommonDB.getDB(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);


        String getPhone = commonDB.registrationDAO().getPhone();


        ArrayList<OrderHistoryModel> arrayList = (ArrayList<OrderHistoryModel>) commonDB.orderHistoryDAO().getHistory(getPhone);

        orderHistoryAdapter orderHistoryAdapter = new orderHistoryAdapter(arrayList, this);
        if (arrayList.isEmpty()) {
            orderhistory_rv.setVisibility(View.GONE);
            orderhistory_noOrderLL.setVisibility(View.VISIBLE);
        } else {
            orderhistory_rv.setLayoutManager(linearLayoutManager);
            orderhistory_rv.setAdapter(orderHistoryAdapter);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Dashboard_Activity.class);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return true;
    }
}