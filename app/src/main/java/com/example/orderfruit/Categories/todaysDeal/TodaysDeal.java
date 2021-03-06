package com.example.orderfruit.Categories.todaysDeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;

import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;

public class TodaysDeal extends AppCompatActivity implements InterfaceData {
    RecyclerView Todays_deal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_deal);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Today's Trending");


        Todays_deal=findViewById(R.id.todaysdeal_viewfruit_recyclerview);
        SQLiteData sqLiteData=new SQLiteData(this);
        Todays_deal.setLayoutManager(new LinearLayoutManager(this));
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
        Todays_deal.setAdapter(viewFruitAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void Favourite_fruite(int id, int val) {
        Parcelable state=Todays_deal.getLayoutManager().onSaveInstanceState();
        SQLiteData sqLiteData=new SQLiteData(this);
        sqLiteData.favoutite_update(id, val);
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
        Todays_deal.setAdapter(viewFruitAdapter);
        Todays_deal.getLayoutManager().onRestoreInstanceState(state);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Parcelable state=Todays_deal.getLayoutManager().onSaveInstanceState();
        SQLiteData sqLiteData=new SQLiteData(this);
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
        Todays_deal.setAdapter(viewFruitAdapter);
        Todays_deal.getLayoutManager().onRestoreInstanceState(state);
    }
}