package com.example.orderfruit.Categories.allcatagories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.orderfruit.R;

public class AllCatagoriesMain extends AppCompatActivity {
    RecyclerView allCatagoriesRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_catagories_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Category");

        String AllCatagories[]={"Apple","Mango","Berry","Nuts","Banana","Seedless"};
        allCatagoriesRecyclerview=findViewById(R.id.all_catagories_recyclerview);

        allCatagoriesRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        AllCatagoriesAdapter allCatagoriesAdapter=new AllCatagoriesAdapter(AllCatagories, this);
        allCatagoriesRecyclerview.setAdapter(allCatagoriesAdapter);

    }
}