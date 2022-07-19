package com.example.orderfruit.viewmorefruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderfruit.Dashboard_Activity;
import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.fresshfruit.FreshFruitAdapter;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;

public class ViewMoreFruits extends AppCompatActivity implements InterfaceData {
    RecyclerView viewmorefruits_rv;
    ViewFruitAdapter viewFruitAdapter;

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


        viewmorefruits_rv=findViewById(R.id.todaysdeal_viewfruit_recyclerview);
         SQLiteData sqLiteData=new SQLiteData(ViewMoreFruits.this);
        viewmorefruits_rv.setLayoutManager(new LinearLayoutManager(this));
         viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), ViewMoreFruits.this,this);
        viewmorefruits_rv.setAdapter(viewFruitAdapter);

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

        Parcelable state=viewmorefruits_rv.getLayoutManager().onSaveInstanceState();
        viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), ViewMoreFruits.this,this);
        viewmorefruits_rv.setAdapter(viewFruitAdapter);
        viewmorefruits_rv.getLayoutManager().onRestoreInstanceState(state);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);
        Parcelable state=viewmorefruits_rv.getLayoutManager().onSaveInstanceState();
        viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), ViewMoreFruits.this,this);
        viewmorefruits_rv.setAdapter(viewFruitAdapter);
        viewmorefruits_rv.getLayoutManager().onRestoreInstanceState(state);

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