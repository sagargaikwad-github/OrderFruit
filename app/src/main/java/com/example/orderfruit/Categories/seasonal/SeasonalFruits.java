package com.example.orderfruit.Categories.seasonal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;

import java.util.ArrayList;

public class SeasonalFruits extends AppCompatActivity implements InterfaceData, AdapterView.OnItemSelectedListener {
    Spinner sp;
    String[] country = {"Summer", "Monsoon", "Winter"};
    RecyclerView Seasonal_rv;
    public String Season;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal_fruits);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sp=findViewById(R.id.spinner);
        Seasonal_rv=findViewById(R.id.seasonal_recyclerview);
        SQLiteData sqLiteData=new SQLiteData(this);

        sp.setOnItemSelectedListener(SeasonalFruits.this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Season= String.valueOf(country[i]);
        getSupportActionBar().setTitle(Season);
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());

        if(i==0)
        {
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);

        }
        else if(i==1)
        {
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
        }
        else
        {
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);
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

        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();

        if(Season=="Summer")
        {
            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonSummer(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);


        }
        else if(Season=="Monsoon")
        {

            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonMonsoon(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);


        }
        else
        {

            Seasonal_rv.setLayoutManager(new LinearLayoutManager(this));
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), SeasonalFruits.this,this);
            Seasonal_rv.setAdapter(viewFruitAdapter);


        }


    }
}