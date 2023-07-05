package com.example.orderfruit.viewmorefruits;

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

public class ViewMoreFruits extends AppCompatActivity implements InterfaceData {
    RecyclerView viewmorefruits_rv;
    ViewFruitAdapter viewFruitAdapter;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_more_fruits);

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Order Fruits");
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewmorefruits_rv = findViewById(R.id.viewmore_rv);
        shimmerFrameLayout = findViewById(R.id.shimmerframelayout);
        shimmerFrameLayout.startShimmer();


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
//      SQLiteData sqLiteData=new SQLiteData(this);
//      sqLiteData.favoutite_update(id, val);
//
//        Parcelable state=viewmorefruits_rv.getLayoutManager().onSaveInstanceState();
////        viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), ViewMoreFruits.this,this);
////        viewmorefruits_rv.setAdapter(viewFruitAdapter);
//        viewmorefruits_rv.getLayoutManager().onRestoreInstanceState(state);
//
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();


        if (shimmerFrameLayout.isShimmerStarted()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    viewmorefruits_rv.setVisibility(View.VISIBLE);
                    shimmerFrameLayout.setVisibility(View.GONE);
                    setdataResume();
                }
            }, 2000);
        } else {
            setdataResume();
        }

    }

    private void setdataResume() {
        // SQLiteData sqLiteData=new SQLiteData(this);
        CommonDB commonDB = CommonDB.getDB(this);
        Parcelable state = null;
        String getPhone = commonDB.registrationDAO().getPhone();

        try {
            state = viewmorefruits_rv.getLayoutManager().onSaveInstanceState();
        } catch (Exception e) {
            //Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        if (state == null) {
            ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getAllFruits();
            viewmorefruits_rv.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter = new ViewFruitAdapter(arrayList, ViewMoreFruits.this, this, getPhone);
            viewmorefruits_rv.setAdapter(viewFruitAdapter);
        } else {
            ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getAllFruits();
            viewmorefruits_rv.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter = new ViewFruitAdapter(arrayList, ViewMoreFruits.this, this, getPhone);
            viewmorefruits_rv.setAdapter(viewFruitAdapter);
            viewmorefruits_rv.getLayoutManager().onRestoreInstanceState(state);
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