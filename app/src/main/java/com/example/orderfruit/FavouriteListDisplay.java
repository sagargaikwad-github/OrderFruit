package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;

import java.util.ArrayList;

public class FavouriteListDisplay extends AppCompatActivity implements InterfaceData {
    RecyclerView favourite_list_display_rv;
    LinearLayout favourite_list_display_LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list_display);
        getSupportActionBar().setTitle("Favourite Fruits");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        favourite_list_display_rv=findViewById(R.id.favourite_list_display_rv);
        favourite_list_display_LL=findViewById(R.id.favourite_list_display_linearlayout);

        SQLiteData sqLiteData=new SQLiteData(this);
        ArrayList<FruitData> check=sqLiteData.favourite_list();

       if(check.isEmpty() || sqLiteData.favourite_list()==null)
       {
           favourite_list_display_LL.setVisibility(View.VISIBLE);
           favourite_list_display_rv.setVisibility(View.GONE);
       }
       else
       {
           favourite_list_display_rv.setVisibility(View.VISIBLE);
           favourite_list_display_rv.setLayoutManager(new LinearLayoutManager(this));
           ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.favourite_list(),FavouriteListDisplay.this,this);
           favourite_list_display_rv.setAdapter(viewFruitAdapter);
       }

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
        ViewFruitAdapter viewFruitAdapter;

        ArrayList<FruitData> check=sqLiteData.favourite_list();
        if(check.isEmpty() || sqLiteData.favourite_list()==null)
        {
            favourite_list_display_LL.setVisibility(View.VISIBLE);
            favourite_list_display_rv.setVisibility(View.GONE);
        }
        else
        {

            favourite_list_display_rv.setVisibility(View.VISIBLE);

            Parcelable state=favourite_list_display_rv.getLayoutManager().onSaveInstanceState();
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.favourite_list(),FavouriteListDisplay.this,this);
            favourite_list_display_rv.setAdapter(viewFruitAdapter);
            favourite_list_display_rv.getLayoutManager().onRestoreInstanceState(state);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteData sqLiteData=new SQLiteData(this);

        ArrayList<FruitData> check=sqLiteData.favourite_list();
        if(check.isEmpty() || sqLiteData.favourite_list()==null)
        {
            favourite_list_display_LL.setVisibility(View.VISIBLE);
            favourite_list_display_rv.setVisibility(View.GONE);
        }
        else
        {
            favourite_list_display_rv.setVisibility(View.VISIBLE);

            Parcelable state=favourite_list_display_rv.getLayoutManager().onSaveInstanceState();
            ViewFruitAdapter viewFruitAdapter=new ViewFruitAdapter(sqLiteData.favourite_list(),FavouriteListDisplay.this,this);
            favourite_list_display_rv.setAdapter(viewFruitAdapter);
            favourite_list_display_rv.getLayoutManager().onRestoreInstanceState(state);
        }


    }


}