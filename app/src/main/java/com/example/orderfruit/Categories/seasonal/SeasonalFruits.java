package com.example.orderfruit.Categories.seasonal;

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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.orderfruit.Interface.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

public class SeasonalFruits extends AppCompatActivity implements InterfaceData, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] country = {"Summer", "Monsoon", "Winter"};
    RecyclerView Seasonal_rv;
    public String Season;
    LinearLayout linearLayout;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal_fruits);

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setDisplayHomeAsUpEnabled(true);

        spinner=findViewById(R.id.spinner);
        Seasonal_rv=findViewById(R.id.seasonal_recyclerview);

        linearLayout=findViewById(R.id.linearlayoutmain);
        shimmerFrameLayout=findViewById(R.id.shimmer_seasonal_fruits);
        //shimmerFrameLayout.startShimmer();

        spinner.setOnItemSelectedListener(SeasonalFruits.this);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                shimmerFrameLayout.stopShimmer();
//                linearLayout.setVisibility(View.VISIBLE);
//                shimmerFrameLayout.setVisibility(View.GONE);
//
//            }
//        },2000);

        shimmerFrameLayout.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
        ArrayAdapter aa = new ArrayAdapter(SeasonalFruits.this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        Seasonal_rv.setLayoutManager(new LinearLayoutManager(SeasonalFruits.this));
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,SeasonalFruits.this);
        Seasonal_rv.setAdapter(viewFruitAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Season= String.valueOf(country[i]);
        getSupportActionBar().setTitle(Season);
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());

                if(i==0)
                {
                    shimmerFrameLayout.startShimmer();
                    linearLayout.setVisibility(View.GONE);
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            shimmerFrameLayout.stopShimmer();
                            linearLayout.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.setVisibility(View.GONE);
                            Seasonal_rv.setLayoutManager(new LinearLayoutManager(SeasonalFruits.this));
                            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,SeasonalFruits.this);
                            Seasonal_rv.setAdapter(viewFruitAdapter);
                        }
                    },2000);

//                    Seasonal_rv.setLayoutManager(new LinearLayoutManager(SeasonalFruits.this));
//                    ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,SeasonalFruits.this);
//                    Seasonal_rv.setAdapter(viewFruitAdapter);

                }
                else if(i==1)
                {
                    shimmerFrameLayout.startShimmer();
                    linearLayout.setVisibility(View.GONE);
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            shimmerFrameLayout.stopShimmer();
                            linearLayout.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.setVisibility(View.GONE);
                            Seasonal_rv.setLayoutManager(new LinearLayoutManager(SeasonalFruits.this));
                            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SeasonalFruits.this,SeasonalFruits.this);
                            Seasonal_rv.setAdapter(viewFruitAdapter);
                        }
                    },2000);
                }
                else
                {
                    shimmerFrameLayout.startShimmer();
                    linearLayout.setVisibility(View.GONE);
                    shimmerFrameLayout.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            shimmerFrameLayout.stopShimmer();
                            linearLayout.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.setVisibility(View.GONE);

                            Seasonal_rv.setLayoutManager(new LinearLayoutManager(SeasonalFruits.this));
                            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), SeasonalFruits.this,SeasonalFruits.this);
                            Seasonal_rv.setAdapter(viewFruitAdapter);
                        }
                    },2000);


                }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void Favourite_fruite(int id, int val) {
        SQLiteData sqLiteData=new SQLiteData(this);
        sqLiteData.favoutite_update(id,val);

        String getSeason=Season;
        if(getSeason=="Summer")
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            sqLiteData.favoutite_update(id,val);
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);

        }
        else if(getSeason=="Monsoon")
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            sqLiteData.favoutite_update(id,val);
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);
        }
        else
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            sqLiteData.favoutite_update(id,val);
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());


        if(Season=="Summer")
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);


        }
        else if(Season=="Monsoon")
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);


        }
        else
        {
            Parcelable state=Seasonal_rv.getLayoutManager().onSaveInstanceState();
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
            Seasonal_rv.getLayoutManager().onRestoreInstanceState(state);


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