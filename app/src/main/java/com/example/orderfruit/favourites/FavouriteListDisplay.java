package com.example.orderfruit.favourites;

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
import android.widget.LinearLayout;

import com.example.orderfruit.Interface.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class FavouriteListDisplay extends AppCompatActivity implements InterfaceData {
    RecyclerView favourite_list_display_rv;
    LinearLayout favourite_list_display_LL;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list_display);
       // getSupportActionBar().setTitle("Favourite Fruits");


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Favourites");
        actionBar.setDisplayHomeAsUpEnabled(true);

        favourite_list_display_rv=findViewById(R.id.favourite_list_display_rv);
        favourite_list_display_LL=findViewById(R.id.favourite_list_display_linearlayout);
        shimmerFrameLayout=findViewById(R.id.shimmerframelayout);
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
        SQLiteData sqLiteData=new SQLiteData(this);
        sqLiteData.removeinFavourite(String.valueOf(id),val);
        ViewFruitAdapter viewFruitAdapter;

        String[] getPhone=sqLiteData.getPhone();

        sqLiteData.getInMainFruitList(String.valueOf(id));

        if(sqLiteData.getInMainFruitList(String.valueOf(id)).isEmpty())
        {
            favourite_list_display_LL.setVisibility(View.VISIBLE);
            favourite_list_display_rv.setVisibility(View.GONE);
        }
        else
        {
            favourite_list_display_rv.setVisibility(View.VISIBLE);
            Parcelable state=favourite_list_display_rv.getLayoutManager().onSaveInstanceState();
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getInMainFruitList(String.valueOf(id)),FavouriteListDisplay.this,this, getPhone[0]);
            favourite_list_display_rv.setAdapter(viewFruitAdapter);
            favourite_list_display_rv.getLayoutManager().onRestoreInstanceState(state);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        SQLiteData sqLiteData=new SQLiteData(this);
//
//        ArrayList<FruitData> check=sqLiteData.favourite_list();
//        if(check.isEmpty() || sqLiteData.favourite_list()==null)
//        {
//            favourite_list_display_LL.setVisibility(View.VISIBLE);
//            favourite_list_display_rv.setVisibility(View.GONE);
//        }
//        else
//        {
//            favourite_list_display_rv.setVisibility(View.VISIBLE);
//
//            Parcelable state=favourite_list_display_rv.getLayoutManager().onSaveInstanceState();
//            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.favourite_list(),FavouriteListDisplay.this,this);
//            favourite_list_display_rv.setAdapter(viewFruitAdapter);
//            favourite_list_display_rv.getLayoutManager().onRestoreInstanceState(state);
//        }

        SQLiteData sqLiteData=new SQLiteData(this);
        //ArrayList<FruitData> check=sqLiteData.favourite_list();
        String[] getPhone=sqLiteData.getPhone();

        if(shimmerFrameLayout.isShimmerStarted())
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    if(sqLiteData.getInMainFruitList(getPhone[0]).isEmpty())
                    {
                        favourite_list_display_LL.setVisibility(View.VISIBLE);
                        favourite_list_display_rv.setVisibility(View.GONE);
                    }
                    else
                    {
                        favourite_list_display_rv.setVisibility(View.VISIBLE);
                        favourite_list_display_rv.setLayoutManager(new LinearLayoutManager(FavouriteListDisplay.this));
                        ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getInMainFruitList(getPhone[0]),FavouriteListDisplay.this,FavouriteListDisplay.this, getPhone[0]);
                        favourite_list_display_rv.setAdapter(viewFruitAdapter);
                    }
                }
            },2000);
        }
        else
        {
            shimmerFrameLayout.setVisibility(View.GONE);
            if(sqLiteData.getInMainFruitList(getPhone[0]).isEmpty())
            {
                favourite_list_display_LL.setVisibility(View.VISIBLE);
                favourite_list_display_rv.setVisibility(View.GONE);
            }
            else
            {
                favourite_list_display_rv.setVisibility(View.VISIBLE);
                favourite_list_display_rv.setLayoutManager(new LinearLayoutManager(this));
//                FavouriteAdapter favouriteAdapter=new FavouriteAdapter(sqLiteData.getInMainFruitList(getPhone[0]),FavouriteListDisplay.this,FavouriteListDisplay.this);
//                favourite_list_display_rv.setAdapter(favouriteAdapter);
                 ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getInMainFruitList(getPhone[0]),FavouriteListDisplay.this,FavouriteListDisplay.this, getPhone[0]);
                favourite_list_display_rv.setAdapter(viewFruitAdapter);

            }
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