package com.example.orderfruit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.orderfruit.category.CategoryAdapter;
import com.example.orderfruit.category.CategoryData;
import com.example.orderfruit.fresshfruit.FreshFruitAdapter;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.summer.SummerImageData;
import com.example.orderfruit.summer.SummerViewFruit;
import com.example.orderfruit.summer.summerRecyclerAdapter;
import com.example.orderfruit.user.UserProfile;
import com.example.orderfruit.user.User_Login_Activity;
import com.example.orderfruit.viewfruit.ViewFruitAdapter;
import com.example.orderfruit.viewmorefruits.ViewMoreFruits;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Dashboard_Activity extends AppCompatActivity implements InterfaceData, NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView nav_view;
    FloatingActionButton fab;
    TextView logout,Dashboard_Viewall_TV;
    ImageView Dashboard_Viewall_IV;
    ListView listView;
    ArrayList<CategoryData>category=new ArrayList<>();
    RecyclerView dashboard_recyclerview,you_may_like_recyclerview,fresh_fruit;
    CategoryAdapter categoryAdapter;
    ImageSlider imageSlider;
    ArrayList<SummerImageData>Summer_Image_list;
    summerRecyclerAdapter summerRecyclerAdapter;
    FreshFruitAdapter freshFruitAdapter;
    TextView ViewMore;
    String Phone;
    TextView Nav_name,Nav_phone;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ViewMore=findViewById(R.id.view_more);
        Dashboard_Viewall_TV=findViewById(R.id.dashboard_viewall_TV);
        Dashboard_Viewall_IV=findViewById(R.id.dashboard_viewall_IV);

        setNavigationViewListener();

        imageSlider=findViewById(R.id.image_slider);
        ArrayList<SlideModel>slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/71/1c/45/711c451bd36e29a7b440ddb3125e03f3.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSR6KmspSy7yDl6Wl7895mvE4vR9tBFxIsPGg&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu_zAomeE5h3ftWvdzNwQAOrxaFqH6g2rEfA&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXmgXbqGInKIpIbNEfYUIlba6Z_yRtbN_amQ&usqp=CAU", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);


        category.add(new CategoryData(R.drawable.all_catagory,"All Categories"));
        category.add(new CategoryData(R.drawable.deal,"Todays Deal"));
        category.add(new CategoryData(R.drawable.seasonal,"Seasonal"));
        category.add(new CategoryData(R.drawable.popular,"Popular"));
        category.add(new CategoryData(R.drawable.mostly_viewed,"Mostly Viewed"));


        Summer_Image_list =new ArrayList<>();
        Summer_Image_list.add(new SummerImageData(0,R.drawable.summer_mango));
//        Summer_Image_list.add(new SummerImageData(1,R.drawable.summer_mango));
        Summer_Image_list.add(new SummerImageData(1,R.drawable.summer_watermelon));
        Summer_Image_list.add(new SummerImageData(2,R.drawable.summer_waxjambu));
        Summer_Image_list.add(new SummerImageData(3,R.drawable.summer_karunda));
        Summer_Image_list.add(new SummerImageData(4,R.drawable.summer_jackfruit));
        Summer_Image_list.add(new SummerImageData(5,R.drawable.summer_papaya));
        Summer_Image_list.add(new SummerImageData(6,R.drawable.summer_pineapple));



//To add a Photo in summer table
       if(Summer_Image_list!=null)
        {
            for(int i=0;i<Summer_Image_list.size();i++)
            {
                SQLiteData sqLiteData=new SQLiteData(Dashboard_Activity.this);
                Bitmap bitmap=BitmapFactory.decodeResource(Dashboard_Activity.this.getResources(),Summer_Image_list.get(i).getImage());
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
                byte[] img=byteArrayOutputStream.toByteArray();
                sqLiteData.addSummerImage(i,img);
            }
        }



//       Fresh_Fruit_list.add(new FreshFruitData(0,"Apple",120,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(1,"Watermelon",40,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(2,"Orange",80,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(3,"Pear",35,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(4,"Cherry",100,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(5,"Strawberry",120,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(6,"Nectarine",800,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(7,"Grape",50,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(8,"Mango",200,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));
//       Fresh_Fruit_list.add(new FreshFruitData(9,"Blueberry",60,1,"An apple is an edible fruit produced by an apple tree. Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today",null,0));



        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);

        logout = findViewById(R.id.logout);

        drawerLayout = findViewById(R.id.dashboard_drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        dashboard_recyclerview=findViewById(R.id.dashboard_recyclerview);
        dashboard_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        categoryAdapter= new CategoryAdapter(category, Dashboard_Activity.this);
        dashboard_recyclerview.setAdapter(categoryAdapter);

        SQLiteData sqLiteData=new SQLiteData(Dashboard_Activity.this);

     you_may_like_recyclerview=findViewById(R.id.you_may_like_recyclerview);
     you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
     summerRecyclerAdapter=new summerRecyclerAdapter(sqLiteData.getSummerFruits(),Dashboard_Activity.this);
     you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);

        fresh_fruit=findViewById(R.id.allFruits_rv);
        fresh_fruit.setLayoutManager(new LinearLayoutManager(this));
        freshFruitAdapter=new FreshFruitAdapter(sqLiteData.getFruitMain(),Dashboard_Activity.this,this);
        fresh_fruit.setAdapter(freshFruitAdapter);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Toast.makeText(Dashboard_Activity.this, "Logout Succesful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard_Activity.this, User_Login_Activity.class);
                startActivity(intent);



                Cursor headerdata=sqLiteData.headerData();
                if(headerdata!=null)
                {
                    if(headerdata.moveToFirst())
                    {
                        do{
                            String phone=headerdata.getString(1);
                            sqLiteData.UpdateLogin(phone,0);
                        }while (headerdata.moveToNext());
                    }
                }
                else
                {

                }

            }
        });

        ViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Dashboard_Activity.this, ViewMoreFruits.class);
                startActivity(intent1);

            }
        });


        Dashboard_Viewall_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard_Activity.this, SummerViewFruit.class);
                startActivity(intent);
            }
        });


        //Data Set to Navigation Header:
     nav_view=findViewById(R.id.dashboard_navigation_view);
     View viewheader=nav_view.getHeaderView(0);
      Nav_name=viewheader.findViewById(R.id.nav_header_name_tv);
      Nav_phone=viewheader.findViewById(R.id.nav_header_phone_tv);

     Cursor headerdata=sqLiteData.headerData();
     if(headerdata!=null)
     {
        if(headerdata.moveToFirst())
        {
            do{
                String name=headerdata.getString(0);
                String phone=headerdata.getString(1);
                Nav_name.setText(name);
                Nav_phone.setText(phone);
            }while (headerdata.moveToNext());
        }
     }
     else
     {

     }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.actionbar_searchview);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type Here for search");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return false;
        }

        switch (item.getItemId())
        {
            case R.id.actionbar_cart:
                Intent intent=new Intent(this,ViewCart.class);
                startActivity(intent);
                break;
            case R.id.actionbar_searchview:
                Toast.makeText(this, "dev", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_home:
                Intent intent2=new Intent(this,ViewCart.class);
                startActivity(intent2);
                break;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
     {
        //If Navigation Drawer is open ...first close navigation drawer
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finishAffinity();
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

        Parcelable state=fresh_fruit.getLayoutManager().onSaveInstanceState();
        freshFruitAdapter=new FreshFruitAdapter(sqLiteData.getFruitMain(), Dashboard_Activity.this,this);
        fresh_fruit.setAdapter(freshFruitAdapter);
        fresh_fruit.getLayoutManager().onRestoreInstanceState(state);

        Parcelable state1=you_may_like_recyclerview.getLayoutManager().onSaveInstanceState();
        summerRecyclerAdapter summerRecyclerAdapter=new summerRecyclerAdapter(sqLiteData.getSummerFruits(), Dashboard_Activity.this);
        you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
        you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);
    }



    @Override
    protected void onResume() {
        super.onResume();

        SQLiteData sqLiteData=new SQLiteData(this);

        Parcelable state=fresh_fruit.getLayoutManager().onSaveInstanceState();
        freshFruitAdapter=new FreshFruitAdapter(sqLiteData.getFruitMain(), Dashboard_Activity.this,this);
        fresh_fruit.setAdapter(freshFruitAdapter);
        fresh_fruit.getLayoutManager().onRestoreInstanceState(state);


        Parcelable state1=you_may_like_recyclerview.getLayoutManager().onSaveInstanceState();
        summerRecyclerAdapter summerRecyclerAdapter=new summerRecyclerAdapter(sqLiteData.getSummerFruits(), Dashboard_Activity.this);
        you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
        you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);


        Cursor headerdata=sqLiteData.headerData();
        if(headerdata!=null)
        {
            if(headerdata.moveToFirst())
            {
                do{
                    String name=headerdata.getString(0);
                    String phone=headerdata.getString(1);
                    Nav_name.setText(name);
                    Nav_phone.setText(phone);
                }while (headerdata.moveToNext());
            }
        }
        else
        {

        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.nav_favourite:
               Intent intent1=new Intent(this,FavouriteListDisplay.class);
               startActivity(intent1);
               break;
           case R.id.nav_cart:
               Intent intent2=new Intent(this,ViewCart.class);
               startActivity(intent2);
               break;
           case R.id.nav_orders:
               Intent intent=new Intent(this,OrderHistory.class);
               startActivity(intent);
               break;
           case R.id.nav_profile:
               Intent intent4=new Intent(this, UserProfile.class);
               SQLiteData sqLiteData=new SQLiteData(this);
               Cursor headerdata=sqLiteData.headerData();
               if(headerdata!=null)
               {
                   if(headerdata.moveToFirst())
                   {
                       do{
                           String name=headerdata.getString(0);
                           String phone=headerdata.getString(1);
                           String address1=headerdata.getString(4);
                           String address2=headerdata.getString(5);
                           intent4.putExtra("User_Name",name);
                           intent4.putExtra("User_Phone",phone);
                           intent4.putExtra("User_Address",address1);
                           intent4.putExtra("User_Address2",address2);
                       }while (headerdata.moveToNext());
                   }
               }
               else
               {

               }
               startActivity(intent4);
               break;
       }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.dashboard_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}

