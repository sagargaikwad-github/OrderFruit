package com.example.orderfruit.summer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;

public class SummerViewFruit extends AppCompatActivity implements InterfaceData {
    RecyclerView summer_vieww_fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_view_fruit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Summer Fruits");

        summer_vieww_fruit=findViewById(R.id.todaysdeal_viewfruit_recyclerview);
        SQLiteData sqLiteData=new SQLiteData(SummerViewFruit.this);
        summer_vieww_fruit.setLayoutManager(new LinearLayoutManager(this));
        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
        summer_vieww_fruit.setAdapter(summerViewFruitAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);
        Parcelable state=summer_vieww_fruit.getLayoutManager().onSaveInstanceState();
        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
        summer_vieww_fruit.setAdapter(summerViewFruitAdapter);
        summer_vieww_fruit.getLayoutManager().onRestoreInstanceState(state);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void Favourite_fruite(int id, int val) {
        SQLiteData sqLiteData=new SQLiteData(this);
        sqLiteData.favoutite_update(id,val);
        Parcelable state=summer_vieww_fruit.getLayoutManager().onSaveInstanceState();
        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
        summer_vieww_fruit.setAdapter(summerViewFruitAdapter);
        summer_vieww_fruit.getLayoutManager().onRestoreInstanceState(state);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }
}