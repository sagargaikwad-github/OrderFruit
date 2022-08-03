package com.example.orderfruit.summer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.orderfruit.Interface.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.Calendar;

public class SummerViewFruit extends AppCompatActivity implements InterfaceData {
    RecyclerView summer_vieww_fruit_rv;
    SummerViewFruitAdapter summerViewFruitAdapter;
    ShimmerFrameLayout shimmerFrameLayout;
    SQLiteData sqLiteData;
    Parcelable state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_view_fruit);


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("From Seasons");
        actionBar.setDisplayHomeAsUpEnabled(true);

        summer_vieww_fruit_rv = findViewById(R.id.summer_view_rv);
        shimmerFrameLayout = findViewById(R.id.shimmer_dashboard_viewall);
        shimmerFrameLayout.startShimmer();

        sqLiteData = new SQLiteData(SummerViewFruit.this);

//        summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
//        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
//        summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);

//        Calendar mCalendar = Calendar.getInstance();
//        int monthNumber = mCalendar.get(Calendar.MONTH);
//        if(monthNumber==1 || monthNumber==2 || monthNumber ==11 || monthNumber==12 )
//        {
//
//            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Summer Fruits");
//            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
//            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this,this);
//            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
//            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
//        }
//        else if(monthNumber==3 || monthNumber==4 || monthNumber==5|| monthNumber==6 )
//        {
//            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Monsoon Fruits");
//            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
//            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this,this);
//            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
//            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
//        }else
//        {
//            Parcelable state1=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Winter Fruits");
//            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
//            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this,this);
//            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
//            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
//
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (shimmerFrameLayout.isShimmerStarted()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    summer_vieww_fruit_rv.setVisibility(View.VISIBLE);
                    try {
                        state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                    } catch (Exception e) {

                    }

                    if (state == null) {
                        Calendar mCalendar = Calendar.getInstance();
                        int monthNumber = mCalendar.get(Calendar.MONTH);
                        if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {


                            getSupportActionBar().setTitle("Summer Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);

                        } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                            getSupportActionBar().setTitle("Monsoon Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);

                        } else {
                            getSupportActionBar().setTitle("Winter Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);

                        }
                    }
                    else
                    {
                        state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();

                        Calendar mCalendar = Calendar.getInstance();
                        int monthNumber = mCalendar.get(Calendar.MONTH);
                        if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {

                            state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                            getSupportActionBar().setTitle("Summer Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);
                        } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                            state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                            getSupportActionBar().setTitle("Monsoon Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);
                        } else {
                            state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                            getSupportActionBar().setTitle("Winter Fruits");
                            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(SummerViewFruit.this));
                            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this, SummerViewFruit.this);
                            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);

                        }

                    }
                }
            }, 2000);
        } else {

            shimmerFrameLayout.setVisibility(View.GONE);
            summer_vieww_fruit_rv.setVisibility(View.VISIBLE);

            state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();

            Calendar mCalendar = Calendar.getInstance();
            int monthNumber = mCalendar.get(Calendar.MONTH);
            if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {

                state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                getSupportActionBar().setTitle("Summer Fruits");
                summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
                summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this, this);
                summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);
            } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                 state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                getSupportActionBar().setTitle("Monsoon Fruits");
                summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
                summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this, this);
                summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);
            } else {
                 state = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
                getSupportActionBar().setTitle("Winter Fruits");
                summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
                summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this, this);
                summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
                summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);

            }


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
        SQLiteData sqLiteData = new SQLiteData(this);
        sqLiteData.favoutite_update(id, val);
//        Parcelable state=summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
//        SummerViewFruitAdapter summerViewFruitAdapter=new SummerViewFruitAdapter(sqLiteData.getSummerFruits(),SummerViewFruit.this,this);
//        summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
//        summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state);

        Calendar mCalendar = Calendar.getInstance();
        int monthNumber = mCalendar.get(Calendar.MONTH);
        if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {

            Parcelable state1 = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Summer Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonSummer(), SummerViewFruit.this, this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
            Parcelable state1 = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Monsoon Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SummerViewFruit.this, this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);
        } else {
            Parcelable state1 = summer_vieww_fruit_rv.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Winter Fruits");
            summer_vieww_fruit_rv.setLayoutManager(new LinearLayoutManager(this));
            summerViewFruitAdapter = new SummerViewFruitAdapter(sqLiteData.getSeasonWinter(), SummerViewFruit.this, this);
            summer_vieww_fruit_rv.setAdapter(summerViewFruitAdapter);
            summer_vieww_fruit_rv.getLayoutManager().onRestoreInstanceState(state1);

        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();

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