package com.example.orderfruit.viewfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.orderfruit.InterfaceData;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;

public class View_All_Category extends AppCompatActivity implements InterfaceData {
    RecyclerView view_fruit_actvity_recyclerview;
    ViewFruitAdapter viewFruitAdapter;
    String apple;
    String mango;
    String berry;
    String DryFruit;
    String banana;
    String seedless;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_category);


        Bundle bundle=getIntent().getExtras();

//        String apple=bundle.getString("Apple");
//        String mango=bundle.getString("Mango");
//        String berry=bundle.getString("Berry");
//        String DryFruit=bundle.getString("DryFruit");
//        String banana=bundle.getString("Banana");
//        String seedless=bundle.getString("Seedless");

         apple=bundle.getString("Apple");
         mango=bundle.getString("Mango");
         berry=bundle.getString("Berry");
         DryFruit=bundle.getString("DryFruit");
         banana=bundle.getString("Banana");
         seedless=bundle.getString("Seedless");



        SQLiteData sqLiteData=new SQLiteData(View_All_Category.this);

        view_fruit_actvity_recyclerview=findViewById(R.id.view_fruit_actvity_recyclerview);

        if(apple!=null)
        {
            getSupportActionBar().setTitle("Apple");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(apple),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        }
        if(mango!=null)
        {
            getSupportActionBar().setTitle("Mango");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(mango),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        }
        if(berry!=null)
        {

            getSupportActionBar().setTitle("Berries");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
             viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(berry),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        }
        if(DryFruit!=null)
        {

               getSupportActionBar().setTitle("DryFruit");
                view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
                 viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(DryFruit),View_All_Category.this,this);
                view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        }
        if(banana!=null)
        {

            getSupportActionBar().setTitle("Banana");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
             viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(banana),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        }
        if(seedless!=null)
        {
            getSupportActionBar().setTitle("Seedless Fruits");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(seedless),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

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
        sqLiteData.favoutite_update(id, val);

//        Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//        viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), View_All_Category.this,this);
//        view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//        viewFruitAdapter.notifyDataSetChanged();
//        view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        if(apple!=null)
        {
            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Apple");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(apple),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
        if(mango!=null)
        {
            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Mango");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(mango),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
        if(berry!=null)
        {

            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Berries");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(berry),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
        if(DryFruit!=null)
        {
            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("DryFruit");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(DryFruit),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
        if(banana!=null)
        {
            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Banana");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(banana),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
        if(seedless!=null)
        {
            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            getSupportActionBar().setTitle("Seedless Fruits");
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(seedless),View_All_Category.this,this);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();

    }


}