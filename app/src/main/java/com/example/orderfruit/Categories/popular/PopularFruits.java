package com.example.orderfruit.Categories.popular;

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

public class PopularFruits extends AppCompatActivity implements InterfaceData {
    RecyclerView popularfruits_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_fruits);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Popular Fruits");



        SQLiteData sqLiteData=new SQLiteData(this);
        popularfruits_rv=findViewById(R.id.popularfruits_rv);
        popularfruits_rv.setLayoutManager(new LinearLayoutManager(this));
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), this,this);
        popularfruits_rv.setAdapter(viewFruitAdapter);
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


        Parcelable state=popularfruits_rv.getLayoutManager().onSaveInstanceState();
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this,this);
        popularfruits_rv.setAdapter(viewFruitAdapter);
        popularfruits_rv.getLayoutManager().onRestoreInstanceState(state);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);
        Parcelable state=popularfruits_rv.getLayoutManager().onSaveInstanceState();
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), PopularFruits.this,this);
        popularfruits_rv.setAdapter(viewFruitAdapter);
        popularfruits_rv.getLayoutManager().onRestoreInstanceState(state);
    }
}