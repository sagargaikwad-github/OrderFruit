package com.example.orderfruit.Categories.todaysDeal;

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
import android.widget.Toast;

import com.example.orderfruit.Interface.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.example.orderfruit.viewmorefruits.ViewMoreFruits;
import com.facebook.shimmer.ShimmerFrameLayout;

public class TodaysDeal extends AppCompatActivity implements InterfaceData {
    RecyclerView Todays_deal_rv;
    ShimmerFrameLayout shimmerFrameLayout;
    ViewFruitAdapter viewFruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays_deal);


        Todays_deal_rv=findViewById(R.id.todaysdeal_viewfruit_recyclerview);
        shimmerFrameLayout=findViewById(R.id.shimmerframelayout_topdeals);
        shimmerFrameLayout.startShimmer();

//        SQLiteData sqLiteData=new SQLiteData(this);
//        Todays_deal_rv.setLayoutManager(new LinearLayoutManager(this));
//        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
//        Todays_deal_rv.setAdapter(viewFruitAdapter);


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
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
        sqLiteData.favoutite_update(id, val);

        Parcelable state=Todays_deal_rv.getLayoutManager().onSaveInstanceState();
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
        Todays_deal_rv.setAdapter(viewFruitAdapter);
        Todays_deal_rv.getLayoutManager().onRestoreInstanceState(state);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if(shimmerFrameLayout.isShimmerStarted())
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    Todays_deal_rv.setVisibility(View.VISIBLE);
                    shimmerFrameLayout.setVisibility(View.GONE);

                    setdata();
                }
            },2000);
        }
        else
        {
            setdata();
        }


    }

    private void setdata() {
        Parcelable state=null;
        SQLiteData sqLiteData=new SQLiteData(TodaysDeal.this);
        try{
            state=Todays_deal_rv.getLayoutManager().onSaveInstanceState();
        }
        catch (Exception e)
        {

        }

        if(state==null)
        {
            Todays_deal_rv.setLayoutManager(new LinearLayoutManager(TodaysDeal.this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
            Todays_deal_rv.setAdapter(viewFruitAdapter);
        }
        else
        {
            Todays_deal_rv.setLayoutManager(new LinearLayoutManager(TodaysDeal.this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getTopDeals(),TodaysDeal.this,this);
            Todays_deal_rv.setAdapter(viewFruitAdapter);
            Todays_deal_rv.getLayoutManager().onRestoreInstanceState(state);
        }
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