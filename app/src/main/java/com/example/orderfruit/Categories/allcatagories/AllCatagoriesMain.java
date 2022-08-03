package com.example.orderfruit.Categories.allcatagories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.orderfruit.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class AllCatagoriesMain extends AppCompatActivity  {
    RecyclerView allCatagoriesRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_catagories_main);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Select Category");

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        String AllCatagories[] = {"Apple", "Mango", "Berry", "Nuts", "Banana", "Seedless"};
        allCatagoriesRecyclerview = findViewById(R.id.all_catagories_recyclerview);


        allCatagoriesRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        AllCatagoriesAdapter allCatagoriesAdapter = new AllCatagoriesAdapter(AllCatagories, this);
        allCatagoriesRecyclerview.setAdapter(allCatagoriesAdapter);

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