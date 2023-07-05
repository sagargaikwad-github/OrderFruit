package com.example.orderfruit.Categories.mostlyviewed;

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
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class MostlyViewd extends AppCompatActivity implements InterfaceData {
    RecyclerView mostlyviewedfruits_rv;
    ShimmerFrameLayout shimmerFrameLayout;
    SQLiteData sqLiteData;
    Parcelable state;
    String getPhone;
    CommonDB commonDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostly_viewd);

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Mostly Viewed");
        actionBar.setDisplayHomeAsUpEnabled(true);


        sqLiteData = new SQLiteData(this);
        mostlyviewedfruits_rv = findViewById(R.id.mostlyviwedfruits_rv);
        shimmerFrameLayout = findViewById(R.id.shimmer_mostlyviewd);

        shimmerFrameLayout.startShimmer();

        commonDB = CommonDB.getDB(this);
        getPhone = commonDB.registrationDAO().getPhone();

        // getPhone=sqLiteData.getPhone();

//        mostlyviewedfruits_rv.setLayoutManager(new LinearLayoutManager(this));
//        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), this,this);
//        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
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
//        SQLiteData sqLiteData=new SQLiteData(this);
//        sqLiteData.favoutite_update(id,val);
//
//        Parcelable state=mostlyviewedfruits_rv.getLayoutManager().onSaveInstanceState();
//        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), MostlyViewd.this,this, getPhone[0]);
//        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
//        mostlyviewedfruits_rv.getLayoutManager().onRestoreInstanceState(state);
//
//    }

    @Override
    protected void onResume() {
        super.onResume();

        if (shimmerFrameLayout.isShimmerStarted()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    mostlyviewedfruits_rv.setVisibility(View.VISIBLE);
                    try {
                        state = mostlyviewedfruits_rv.getLayoutManager().onSaveInstanceState();
                    } catch (Exception e) {

                    }

                    if (state == null) {
                        ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getSeasonWinter();
                        mostlyviewedfruits_rv.setLayoutManager(new LinearLayoutManager(MostlyViewd.this));
                        ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(arrayList, MostlyViewd.this, MostlyViewd.this, getPhone);
                        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
                    } else {
                        ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getSeasonWinter();
                        mostlyviewedfruits_rv.setLayoutManager(new LinearLayoutManager(MostlyViewd.this));
                        ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(arrayList, MostlyViewd.this, MostlyViewd.this, getPhone);
                        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
                        mostlyviewedfruits_rv.getLayoutManager().onRestoreInstanceState(state);
                    }
                }
            }, 2000);
        } else {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            mostlyviewedfruits_rv.setVisibility(View.VISIBLE);
            state = mostlyviewedfruits_rv.getLayoutManager().onSaveInstanceState();
            ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getSeasonWinter();
            ViewFruitAdapter viewFruitAdapter = new ViewFruitAdapter(arrayList, MostlyViewd.this, this, getPhone);
            mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
            mostlyviewedfruits_rv.getLayoutManager().onRestoreInstanceState(state);

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