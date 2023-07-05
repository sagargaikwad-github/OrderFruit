package com.example.orderfruit.Categories.allcatagories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
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

public class View_All_Category extends AppCompatActivity implements InterfaceData {
    RecyclerView view_fruit_actvity_recyclerview;
    ViewFruitAdapter viewFruitAdapter;
    String apple;
    String mango;
    String berry;
    String DryFruit;
    String banana;
    String seedless;
    ShimmerFrameLayout shimmerFrameLayout;
    Parcelable state;
    String getPhone;
    CommonDB commonDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_category);

        shimmerFrameLayout = findViewById(R.id.shimmerframelayout);

        Bundle bundle = getIntent().getExtras();

//        String apple=bundle.getString("Apple");
//        String mango=bundle.getString("Mango");
//        String berry=bundle.getString("Berry");
//        String DryFruit=bundle.getString("DryFruit");
//        String banana=bundle.getString("Banana");
//        String seedless=bundle.getString("Seedless");

        apple = bundle.getString("Apple");
        mango = bundle.getString("Mango");
        berry = bundle.getString("Berry");
        DryFruit = bundle.getString("DryFruit");
        banana = bundle.getString("Banana");
        seedless = bundle.getString("Seedless");

        commonDB = CommonDB.getDB(this);

        //  SQLiteData sqLiteData=new SQLiteData(View_All_Category.this);

        getPhone = commonDB.registrationDAO().getPhone();

        view_fruit_actvity_recyclerview = findViewById(R.id.view_fruit_actvity_recyclerview);


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
//        SQLiteData sqLiteData=new SQLiteData(this);
//        sqLiteData.favoutite_update(id, val);
//
////        Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
////        viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruitMain(), View_All_Category.this,this);
////        view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
////        viewFruitAdapter.notifyDataSetChanged();
////        view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//
//
//        if(apple!=null)
//        {
//
//                getSupportActionBar().setTitle("Apple");
//
//                state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//                view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//                viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getFruit(apple), View_All_Category.this, this, getPhone[0]);
//                view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//                view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//
//        }
//        if(mango!=null)
//        {
//            getSupportActionBar().setTitle("Mango");
//
//            state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter = new ViewFruitAdapter(sqLiteData.getFruit(mango), View_All_Category.this, this, getPhone[0]);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//
//
//        }
//        if(berry!=null)
//        {
//
//            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Berries");
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(berry),View_All_Category.this,this, getPhone[0]);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//        }
//        if(DryFruit!=null)
//        {
//            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("DryFruit");
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(DryFruit),View_All_Category.this,this, getPhone[0]);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//        }
//        if(banana!=null)
//        {
//            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Banana");
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(banana),View_All_Category.this,this, getPhone[0]);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//        }
//        if(seedless!=null)
//        {
//            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Seedless Fruits");
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(seedless),View_All_Category.this,this, getPhone[0]);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
//
//        }
//
//    }

    private void setdata(String fruitname) {
        SQLiteData sqLiteData = new SQLiteData(View_All_Category.this);
        if (state == null) {
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(View_All_Category.this));
            ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getCategory(fruitname);
            viewFruitAdapter = new ViewFruitAdapter(arrayList, View_All_Category.this, View_All_Category.this, getPhone);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);

        } else {
            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(View_All_Category.this));

            ArrayList<FruitDataModel> arrayList = (ArrayList<FruitDataModel>) commonDB.fruitDataDAO().getCategory(fruitname);
            viewFruitAdapter = new ViewFruitAdapter(arrayList, View_All_Category.this, View_All_Category.this, getPhone);
            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (apple != null) {
            getSupportActionBar().setTitle("Apple");

            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(apple);

                    }
                }, 2000);
            } else {
                setdata(apple);
            }

        }

        if (mango != null) {
            getSupportActionBar().setTitle("Mango");
            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(mango);

                    }
                }, 2000);
            } else {
                setdata(mango);
            }

        }
        if (berry != null) {
            getSupportActionBar().setTitle("Berries");
            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(berry);

                    }
                }, 2000);
            } else {
                setdata(berry);
            }

        }
        if (DryFruit != null) {
            getSupportActionBar().setTitle("DryFruits");
            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(DryFruit);

                    }
                }, 2000);
            } else {
                setdata(DryFruit);
            }

        }
        if (banana != null) {
            getSupportActionBar().setTitle("Bananas");
//            Parcelable state=view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
//            getSupportActionBar().setTitle("Banana");
//            view_fruit_actvity_recyclerview.setLayoutManager(new LinearLayoutManager(this));
//            viewFruitAdapter=new ViewFruitAdapter(sqLiteData.getFruit(banana),View_All_Category.this,this);
//            view_fruit_actvity_recyclerview.setAdapter(viewFruitAdapter);
//            view_fruit_actvity_recyclerview.getLayoutManager().onRestoreInstanceState(state);

            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(banana);

                    }
                }, 2000);
            } else {
                setdata(banana);
            }

        }
        if (seedless != null) {
            getSupportActionBar().setTitle("Seedless");
            try {
                state = view_fruit_actvity_recyclerview.getLayoutManager().onSaveInstanceState();
            } catch (Exception e) {

            }

            if (state == null) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.setVisibility(View.GONE);
                        view_fruit_actvity_recyclerview.setVisibility(View.VISIBLE);

                        setdata(seedless);

                    }
                }, 2000);
            } else {
                setdata(seedless);
            }
        }

    }


}