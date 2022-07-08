package com.example.orderfruit.Categories.mostlyviewed;

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

public class MostlyViewd extends AppCompatActivity implements InterfaceData {
    RecyclerView mostlyviewedfruits_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostly_viewd);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mostly Viewed");


        SQLiteData sqLiteData=new SQLiteData(this);
        mostlyviewedfruits_rv=findViewById(R.id.mostlyviwedfruits_rv);

        mostlyviewedfruits_rv.setLayoutManager(new LinearLayoutManager(this));
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), this,this);
        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
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

        Parcelable state=mostlyviewedfruits_rv.getLayoutManager().onSaveInstanceState();
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), MostlyViewd.this,this);
        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
        mostlyviewedfruits_rv.getLayoutManager().onRestoreInstanceState(state);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);
        Parcelable state=mostlyviewedfruits_rv.getLayoutManager().onSaveInstanceState();
        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getSeasonWinter(), MostlyViewd.this,this);
        mostlyviewedfruits_rv.setAdapter(viewFruitAdapter);
        mostlyviewedfruits_rv.getLayoutManager().onRestoreInstanceState(state);
    }
}