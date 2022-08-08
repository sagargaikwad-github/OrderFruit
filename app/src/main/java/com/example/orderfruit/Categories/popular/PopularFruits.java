package com.example.orderfruit.Categories.popular;

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
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

public class PopularFruits extends AppCompatActivity implements InterfaceData {
    RecyclerView popularfruits_rv;
    ShimmerFrameLayout shimmerFrameLayout;
    SQLiteData sqLiteData;
    Parcelable state = null;
    String [] getPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_fruits);

        popularfruits_rv = findViewById(R.id.popularfruits_rv);
        shimmerFrameLayout = findViewById(R.id.shimmer_popular);

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Popular Fruits");
        actionBar.setDisplayHomeAsUpEnabled(true);

        sqLiteData = new SQLiteData(this);
        shimmerFrameLayout.startShimmer();
        getPhone=sqLiteData.getPhone();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void Favourite_fruite(long id, int val) {

    }

//    @Override
//    public void Favourite_fruite(int id, int val) {
//        SQLiteData sqLiteData = new SQLiteData(this);
//        sqLiteData.favoutite_update(id, val);
//
//
//        Parcelable state = popularfruits_rv.getLayoutManager().onSaveInstanceState();
//        ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this, this, getPhone[0]);
//        popularfruits_rv.setAdapter(viewFruitAdapter);
//        popularfruits_rv.getLayoutManager().onRestoreInstanceState(state);

    //}

    @Override
    protected void onResume() {
        super.onResume();

        if (shimmerFrameLayout.isShimmerStarted()) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    popularfruits_rv.setVisibility(View.VISIBLE);
                    shimmerFrameLayout.setVisibility(View.GONE);


                    try {
                        state = popularfruits_rv.getLayoutManager().onSaveInstanceState();
                    } catch (Exception e) {

                    }

                    if (state == null) {
                        popularfruits_rv.setLayoutManager(new LinearLayoutManager(PopularFruits.this));
                        ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this, PopularFruits.this, getPhone[0]);
                        popularfruits_rv.setAdapter(viewFruitAdapter);
                    } else {
                        popularfruits_rv.setLayoutManager(new LinearLayoutManager(PopularFruits.this));
                        ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this, PopularFruits.this, getPhone[0]);
                        popularfruits_rv.setAdapter(viewFruitAdapter);
                        popularfruits_rv.getLayoutManager().onRestoreInstanceState(state);
                    }

                }
            }, 2000);
        }
        else
        {
            try {
                state = popularfruits_rv.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }
            popularfruits_rv.setLayoutManager(new LinearLayoutManager(PopularFruits.this));
            ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this, PopularFruits.this, getPhone[0]);
            popularfruits_rv.setAdapter(viewFruitAdapter);
            popularfruits_rv.getLayoutManager().onRestoreInstanceState(state);
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