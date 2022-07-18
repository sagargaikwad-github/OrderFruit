package com.example.orderfruit.summer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orderfruit.Dashboard_Activity;
import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;

import java.util.Calendar;

public class SummerViewFruit extends AppCompatActivity implements InterfaceData {
    RecyclerView summer_vieww_fruit_rv;
    SummerViewFruitAdapter summerViewFruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_view_fruit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        summer_vieww_fruit_rv=findViewById(R.id.todaysdeal_viewfruit_recyclerview);
        SQLiteData sqLiteData=new SQLiteData(SummerViewFruit.this);
        summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
        summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);

        Calendar mCalendar = Calendar.getInstance();
        int monthNumber = mCalendar.get(Calendar.MONTH);
        if(monthNumber==1 || monthNumber==2 || monthNumber ==11 || monthNumber==12 )
        {

            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                getSupportActionBar().setTitle("Summer Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
             summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        }
        else if(monthNumber==3 || monthNumber==4 || monthNumber==5|| monthNumber==6 )
        {
            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Monsoon Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        }else
        {
            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Winter Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);
        Calendar mCalendar = Calendar.getInstance();
        int monthNumber = mCalendar.get(Calendar.MONTH);
        if(monthNumber==1 || monthNumber==2 || monthNumber ==11 || monthNumber==12 )
        {

            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Summer Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        }
        else if(monthNumber==3 || monthNumber==4 || monthNumber==5|| monthNumber==6 )
        {
            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Monsoon Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        }else
        {
            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Winter Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this,this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);

        }
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
        Parcelable state=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
        summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
        summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }
}