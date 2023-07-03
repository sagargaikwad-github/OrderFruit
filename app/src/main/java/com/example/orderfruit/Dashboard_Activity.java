package com.example.orderfruit;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.orderfruit.Categories.todaysDeal.TodaysDeal;
import com.example.orderfruit.Interface.InterfaceData;
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;
import com.example.orderfruit.cart.ViewCart;
import com.example.orderfruit.category.CategoryAdapter;
import com.example.orderfruit.category.CategoryData;
import com.example.orderfruit.favourites.FavouriteListDisplay;
import com.example.orderfruit.fresshfruit.FreshFruitAdapter;
import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.order.OrderHistory;
import com.example.orderfruit.summer.SummerImageData;
import com.example.orderfruit.summer.SummerViewFruit;
import com.example.orderfruit.summer.summerRecyclerAdapter;
import com.example.orderfruit.user.UserProfile;
import com.example.orderfruit.user.User_Login_Activity;
import com.example.orderfruit.viewfruit.FruitViewActivity;
import com.example.orderfruit.Categories.allcatagories.View_All_Category;
import com.example.orderfruit.viewmorefruits.ViewMoreFruits;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dashboard_Activity extends AppCompatActivity implements InterfaceData, NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView nav_view;
    FloatingActionButton fab;
    TextView logout, Dashboard_Viewall_TV;
    ImageView Dashboard_Viewall_IV;
    ListView listView;
    ArrayList<CategoryData> category = new ArrayList<>();
    RecyclerView dashboard_recyclerview, you_may_like_recyclerview, fresh_fruit_recyclerview;
    CategoryAdapter categoryAdapter;
    ImageSlider imageSlider;
    ArrayList<SummerImageData> Summer_Image_list;
    summerRecyclerAdapter summerRecyclerAdapter;
    FreshFruitAdapter freshFruitAdapter;
    TextView ViewMore;
    String Phone;
    TextView Nav_name, Nav_phone, you_may_also_like_tv;
    ImageView Nav_profile;
    FloatingActionButton Nav_camera;
    AutoCompleteTextView autoCompleteTextView;
    ArrayList<FruitData> fruitData;
    ArrayAdapter<String> arrayAdapter;
    ShimmerFrameLayout shimmerFrameLayout;
    DrawerLayout drawerLayout1;
    ConstraintLayout constraintLayout;
    Parcelable state = null;
    Parcelable state1 = null;
    NestedScrollView nestedScrollView;
    CommonDB commonDB;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ViewMore = findViewById(R.id.view_more);
        Dashboard_Viewall_TV = findViewById(R.id.dashboard_viewall_TV);
        Dashboard_Viewall_IV = findViewById(R.id.dashboard_viewall_IV);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        you_may_also_like_tv = findViewById(R.id.you_may_also_like);

        fresh_fruit_recyclerview = findViewById(R.id.allFruits_rv);
        you_may_like_recyclerview = findViewById(R.id.you_may_like_recyclerview);

        drawerLayout = findViewById(R.id.dashboard_drawer_layout);
        constraintLayout = findViewById(R.id.dashboard_constraint_main);

        //drawerLayout1 = findViewById(R.id.mainDashboard);
        nestedScrollView = findViewById(R.id.nestedscrollview);
        shimmerFrameLayout = findViewById(R.id.shimmer_dashboard);

        commonDB = CommonDB.getDB(this);

        if (isOnline(getApplicationContext())) {
            shimmerFrameLayout.startShimmer();
        } else {
            drawerLayout.setVisibility(View.GONE);
            shimmerFrameLayout.setVisibility(View.VISIBLE);
            shimmerFrameLayout.startShimmer();
            getConn();
        }


        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.imageslider2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imageslider3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.imageslider5, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        for (int z = 0; z < slideModels.size(); z++) {
            imageSlider.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemSelected(int i) {
                    String mango = "Mango";
                    String berry = "Berry";
                    switch (i) {
                        case 0:
                            Intent intent = new Intent(Dashboard_Activity.this, TodaysDeal.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(Dashboard_Activity.this, View_All_Category.class);
                            intent1.putExtra("Mango", mango);
                            startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(Dashboard_Activity.this, View_All_Category.class);
                            intent2.putExtra("Berry", berry);
                            startActivity(intent2);
                            break;
                    }
                }
            });
        }


        category.add(new CategoryData(R.drawable.all_catagory, "All Categories"));
        category.add(new CategoryData(R.drawable.deal, "Todays Deal"));
        category.add(new CategoryData(R.drawable.seasonal, "Seasonal"));
        category.add(new CategoryData(R.drawable.popular, "Popular"));
        category.add(new CategoryData(R.drawable.mostly_viewed, "Mostly Viewed"));


        Summer_Image_list = new ArrayList<>();
        Summer_Image_list.add(new SummerImageData(0, R.drawable.summer_mango));
//        Summer_Image_list.add(new SummerImageData(1,R.drawable.summer_mango));
        Summer_Image_list.add(new SummerImageData(1, R.drawable.summer_watermelon));
        Summer_Image_list.add(new SummerImageData(2, R.drawable.summer_waxjambu));
        Summer_Image_list.add(new SummerImageData(3, R.drawable.summer_karunda));
        Summer_Image_list.add(new SummerImageData(4, R.drawable.summer_jackfruit));
        Summer_Image_list.add(new SummerImageData(5, R.drawable.summer_papaya));
        Summer_Image_list.add(new SummerImageData(6, R.drawable.summer_pineapple));


//To add a Photo in summer table
        if (Summer_Image_list != null) {
            for (int i = 0; i < Summer_Image_list.size(); i++) {
                SQLiteData sqLiteData = new SQLiteData(Dashboard_Activity.this);
                Bitmap bitmap = BitmapFactory.decodeResource(Dashboard_Activity.this.getResources(), Summer_Image_list.get(i).getImage());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                byte[] img = byteArrayOutputStream.toByteArray();
                sqLiteData.addSummerImage(i, img);
            }
        }

        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);


        drawerLayout = findViewById(R.id.dashboard_drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.dashboard_navigation_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);


        dashboard_recyclerview = findViewById(R.id.dashboard_recyclerview);
        dashboard_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryAdapter = new CategoryAdapter(category, Dashboard_Activity.this);
        dashboard_recyclerview.setAdapter(categoryAdapter);

        SQLiteData sqLiteData = new SQLiteData(Dashboard_Activity.this);


        ViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Dashboard_Activity.this, ViewMoreFruits.class);
                startActivity(intent1);
            }
        });


        Dashboard_Viewall_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_Activity.this, SummerViewFruit.class);
                startActivity(intent);
            }
        });


        //Data Set to Navigation Header:
//        nav_view = findViewById(R.id.dashboard_navigation_view);
//        View viewheader = nav_view.getHeaderView(0);
//        Nav_name = viewheader.findViewById(R.id.nav_header_name_tv);
//        Nav_phone = viewheader.findViewById(R.id.nav_header_phone_tv);
//        Nav_profile = viewheader.findViewById(R.id.nav_header_profile_iv);
//
//        Nav_camera = viewheader.findViewById(R.id.fab_btn);
//
//        Cursor headerdata = sqLiteData.headerData();
//        if (headerdata != null) {
//            if (headerdata.moveToFirst()) {
//                do {
//                    String name = headerdata.getString(0);
//                    String phone = headerdata.getString(1);
//
//                    byte[] blob = headerdata.getBlob(8);
//
//                    if (blob != null) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
//                        Nav_profile.setImageBitmap(bitmap);
//                    }
//
//
//                    Nav_name.setText(name);
//                    Nav_phone.setText(phone);
//                    Nav_camera.setOnClickListener(new View.OnClickListener() {
//                        @RequiresApi(api = Build.VERSION_CODES.M)
//                        @Override
//                        public void onClick(View view) {
//                            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//
//                                Toast toast = Toast.makeText(Dashboard_Activity.this, "bbb", Toast.LENGTH_LONG);
//                                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 90, 0);
//                                toast.show();
//
//
//                            } else {
//                                Intent gallartintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                startActivityForResult(gallartintent, 1);
//                            }
//                        }
//                    });
//                } while (headerdata.moveToNext());
//
//            }
//        } else {
//
//        }

        // ArrayList<FruitData> getFruit = sqLiteData.getFruitMain();
        List<FruitDataModel> getFruit = commonDB.fruitDataDAO().getAllFruits();

        String[] Fruits = new String[getFruit.size()];

        for (int j = 0; j < getFruit.size(); j++) {
            Fruits[j] = getFruit.get(j).getFruit_name();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Fruits);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String getdata = (String) adapterView.getItemAtPosition(i);

                SQLiteData sqLiteData1 = new SQLiteData(Dashboard_Activity.this);
                // ArrayList<FruitData> arrayList = sqLiteData1.getFromSearch(getdata);
                List<FruitDataModel> arrayList = commonDB.fruitDataDAO().getFromSearch(getdata);

                Intent intent = new Intent(Dashboard_Activity.this, FruitViewActivity.class);
                intent.putExtra("FruitID", arrayList.get(0).getFruit_id());
                intent.putExtra("FruitName", arrayList.get(0).getFruit_name());
                intent.putExtra("FruitPrice", arrayList.get(0).getFruit_price());
                intent.putExtra("FruitDesc1", arrayList.get(0).getFruit_description1());
                intent.putExtra("FruitDesc2", arrayList.get(0).getFruit_description2());
                intent.putExtra("FruitDesc3", arrayList.get(0).getFruit_description3());
                intent.putExtra("FruitDesc4", arrayList.get(0).getFruit_description4());
                intent.putExtra("FruitCart", arrayList.get(0).getFruit_addtocart());
                intent.putExtra("FruitFav", arrayList.get(0).getFruit_favourite());
                startActivity(intent);

                autoCompleteTextView.setText("");
            }
        });
    }

    private void getConn() {
        new AlertDialog.Builder(Dashboard_Activity.this)
                .setMessage("No Internet Connection !")
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (isOnline(getApplicationContext())) {
                            shimmerFrameLayout.startShimmer();
                            onResume();
                        } else {
                            drawerLayout.setVisibility(View.GONE);
                            shimmerFrameLayout.setVisibility(View.VISIBLE);
                            shimmerFrameLayout.startShimmer();
                            getConn();
                        }
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return false;
        }

        switch (item.getItemId()) {

            case R.id.actionbar_cart:
                Intent intent = new Intent(this, ViewCart.class);
                startActivity(intent);
                break;
            case R.id.actionbar_favourite:
                Intent intent1 = new Intent(this, FavouriteListDisplay.class);
                startActivity(intent1);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //If Navigation Drawer is open ...first close navigation drawer
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(Dashboard_Activity.this)
                    .setMessage("Do You Want to exit ? ")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }

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

    @Override
    protected void onResume() {
        super.onResume();

        SQLiteData sqLiteData = new SQLiteData(this);
        //String[] getPhone = sqLiteData.getPhone();
        String getPhone = commonDB.registrationDAO().getPhone();

        if (isOnline(getApplicationContext())) {
            if (shimmerFrameLayout.isShimmerStarted()) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        shimmerFrameLayout.stopShimmer();
                        drawerLayout.setVisibility(View.VISIBLE);
                        shimmerFrameLayout.setVisibility(View.GONE);
                        try {
                            state = fresh_fruit_recyclerview.getLayoutManager().onSaveInstanceState();
                        } catch (Exception e) {
                        }
                        if (state == null) {
                            dashboard_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                            categoryAdapter = new CategoryAdapter(category, Dashboard_Activity.this);
                            dashboard_recyclerview.setAdapter(categoryAdapter);

                            fresh_fruit_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this));
                            freshFruitAdapter = new FreshFruitAdapter(commonDB.fruitDataDAO().getAllFruits(), Dashboard_Activity.this, Dashboard_Activity.this, getPhone);
                            fresh_fruit_recyclerview.setAdapter(freshFruitAdapter);
                            fresh_fruit_recyclerview.getLayoutManager().onRestoreInstanceState(state);

                            Calendar mCalendar = Calendar.getInstance();
                            int monthNumber = mCalendar.get(Calendar.MONTH);
                            if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {
                                you_may_also_like_tv.setText("Fun in The Sun");
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonSummer(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);

                            } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                                you_may_also_like_tv.setText("Monsoon Check");
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonMonsoon(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);

                            } else {
                                you_may_also_like_tv.setText("Thandi Hai Boht");
                                //  Parcelable state1 = you_may_like_recyclerview.getLayoutManager().onSaveInstanceState();
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonWinter(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
                                // you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);

                            }

                        } else {
                            dashboard_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                            categoryAdapter = new CategoryAdapter(category, Dashboard_Activity.this);
                            dashboard_recyclerview.setAdapter(categoryAdapter);

                            fresh_fruit_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this));
                            freshFruitAdapter = new FreshFruitAdapter(commonDB.fruitDataDAO().getAllFruits(), Dashboard_Activity.this, Dashboard_Activity.this, getPhone);
                            fresh_fruit_recyclerview.setAdapter(freshFruitAdapter);
                            fresh_fruit_recyclerview.getLayoutManager().onRestoreInstanceState(state);

                            Calendar mCalendar = Calendar.getInstance();
                            int monthNumber = mCalendar.get(Calendar.MONTH);
                            if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {
                                you_may_also_like_tv.setText("Fun in The Sun");
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonSummer(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);

                            } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                                you_may_also_like_tv.setText("Monsoon Check");
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonMonsoon(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);

                            } else {
                                you_may_also_like_tv.setText("Thandi Hai Boht");
                                //  Parcelable state1 = you_may_like_recyclerview.getLayoutManager().onSaveInstanceState();
                                you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                                summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonWinter(), Dashboard_Activity.this);
                                you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
                                // you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);

                            }
                        }
                    }
                }, 2000);

            } else {
                shimmerFrameLayout.stopShimmer();
                drawerLayout.setVisibility(View.VISIBLE);
                shimmerFrameLayout.setVisibility(View.GONE);
                try {
                    state = fresh_fruit_recyclerview.getLayoutManager().onSaveInstanceState();
                } catch (Exception e) {
                }
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);

                dashboard_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                categoryAdapter = new CategoryAdapter(category, Dashboard_Activity.this);
                dashboard_recyclerview.setAdapter(categoryAdapter);

                fresh_fruit_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this));
                freshFruitAdapter = new FreshFruitAdapter(commonDB.fruitDataDAO().getAllFruits(), Dashboard_Activity.this, Dashboard_Activity.this, getPhone);
                fresh_fruit_recyclerview.setAdapter(freshFruitAdapter);
                try {
                    fresh_fruit_recyclerview.getLayoutManager().onRestoreInstanceState(state);
                    state1 = you_may_like_recyclerview.getLayoutManager().onSaveInstanceState();
                } catch (Exception e) {
                }

                Calendar mCalendar = Calendar.getInstance();
                int monthNumber = mCalendar.get(Calendar.MONTH);
                if (monthNumber == 1 || monthNumber == 2 || monthNumber == 11 || monthNumber == 12) {
                    you_may_also_like_tv.setText("Fun in The Sun");
                    you_may_like_recyclerview = findViewById(R.id.you_may_like_recyclerview);
                    you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                    summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonSummer(), Dashboard_Activity.this);
                    you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
                    you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);
                } else if (monthNumber == 3 || monthNumber == 4 || monthNumber == 5 || monthNumber == 6) {
                    you_may_also_like_tv.setText("Monsoon Check");
                    you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                    summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonMonsoon(), Dashboard_Activity.this);
                    you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
                    you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);
                } else {
                    you_may_also_like_tv.setText("Thandi Hai Boht");
                    you_may_like_recyclerview.setLayoutManager(new LinearLayoutManager(Dashboard_Activity.this, LinearLayoutManager.HORIZONTAL, false));
                    summerRecyclerAdapter = new summerRecyclerAdapter(commonDB.fruitDataDAO().getSeasonWinter(), Dashboard_Activity.this);
                    you_may_like_recyclerview.setAdapter(summerRecyclerAdapter);
                    you_may_like_recyclerview.getLayoutManager().onRestoreInstanceState(state1);

                }

            }

        }


//                Cursor headerdata = sqLiteData.headerData();
//                if (headerdata != null) {
//                    if (headerdata.moveToFirst()) {
//                        do {
//                            String name = headerdata.getString(0);
//                            String phone = headerdata.getString(1);
//
//                            byte[] blob = headerdata.getBlob(8);
//                            if (blob != null) {
//                                Bitmap bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
//                                Nav_profile.setImageBitmap(bitmap);
//                            }
//
//
//                            Nav_name.setText(name);
//                            Nav_phone.setText(phone);
//                            Nav_camera.setOnClickListener(new View.OnClickListener() {
//                                @RequiresApi(api = Build.VERSION_CODES.M)
//                                @Override
//                                public void onClick(View view) {
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                                            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
//                                        } else {
//                                            Intent gallartintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                            startActivityForResult(gallartintent, 1);
//                                        }
//                                    } else {
//                                        Intent gallartintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                        startActivityForResult(gallartintent, 1);
//                                    }
//                                }
//                            });
//                        } while (headerdata.moveToNext());
//                    }
//                } else {
//
//                }


        nav_view = findViewById(R.id.dashboard_navigation_view);
        View viewheader = nav_view.getHeaderView(0);
        Nav_name = viewheader.findViewById(R.id.nav_header_name_tv);
        Nav_phone = viewheader.findViewById(R.id.nav_header_phone_tv);
        Nav_profile = viewheader.findViewById(R.id.nav_header_profile_iv);

        Nav_camera = viewheader.findViewById(R.id.fab_btn);

        Cursor headerdata = sqLiteData.headerData();
        if (headerdata != null) {
            if (headerdata.moveToFirst()) {
                do {
                    String name = headerdata.getString(0);
                    String phone = headerdata.getString(1);

                    byte[] blob = headerdata.getBlob(8);

                    if (blob != null) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                        Nav_profile.setImageBitmap(bitmap);
                    }


                    Nav_name.setText(name);
                    Nav_phone.setText(phone);
                    Nav_camera.setOnClickListener(new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View view) {
                            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                            } else {
                                Intent gallartintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                startActivityForResult(gallartintent, 1);
                            }
                        }
                    });
                } while (headerdata.moveToNext());

            }
        } else {
            getConn();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_favourite:
                Intent intent1 = new Intent(this, FavouriteListDisplay.class);
                startActivity(intent1);
                break;
            case R.id.nav_cart:
                Intent intent2 = new Intent(this, ViewCart.class);
                startActivity(intent2);
                break;
            case R.id.nav_orders:
                Intent intent = new Intent(this, OrderHistory.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Order Fruit");
                    String shareMessage = "\nLet me recommend you this application\n\n";

                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=com.phonepe.app&hl=en";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Share Via"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.nav_profile:
                Intent intent4 = new Intent(this, UserProfile.class);
                SQLiteData sqLiteData = new SQLiteData(this);
                Cursor headerdata = sqLiteData.headerData();
                if (headerdata != null) {
                    if (headerdata.moveToFirst()) {
                        do {
                            String name = headerdata.getString(0);
                            String phone = headerdata.getString(1);
                            String address1 = headerdata.getString(4);
                            String address2 = headerdata.getString(5);
                            intent4.putExtra("User_Name", name);
                            intent4.putExtra("User_Phone", phone);
                            intent4.putExtra("User_Address", address1);
                            intent4.putExtra("User_Address2", address2);
                        } while (headerdata.moveToNext());
                    }
                } else {

                }
                startActivity(intent4);
                break;
            case R.id.nav_logout:
                SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Toast.makeText(Dashboard_Activity.this, "Logout Succesful", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(Dashboard_Activity.this, User_Login_Activity.class);
                startActivity(intent5);

                SQLiteData sqLiteData1 = new SQLiteData(Dashboard_Activity.this);
                Cursor headerdata1 = sqLiteData1.headerData();
                if (headerdata1 != null) {
                    if (headerdata1.moveToFirst()) {
                        do {
                            String phone = headerdata1.getString(1);
                            sqLiteData1.UpdateLogin(phone, 0);
                        } while (headerdata1.moveToNext());
                    }
                } else {

                }
                break;

            case R.id.nav_home1:
                onResume();
                break;
        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();

            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, 1);
                } else {
                    Toast.makeText(Dashboard_Activity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
//            Uri selectedImage = data.getData();
//            UserProfile_IV.setImageURI(selectedImage);

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage != null) {
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    Bitmap bv = (BitmapFactory.decodeFile(picturePath));
                    cursor.close();


                    //UserProfile_IV.setImageBitmap(bv);


                    //Handling Image Rotation
                    Bitmap myBitmap = BitmapFactory.decodeFile(picturePath);
                    ExifInterface exif = null;
                    try {
                        exif = new ExifInterface(picturePath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                    int rotationInDegrees = exifToDegrees(rotation);
                    int deg = rotationInDegrees;
                    Matrix matrix = new Matrix();
                    if (rotation != 0f) {
                        matrix.preRotate(rotationInDegrees);
                        myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true);

                    }

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    myBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
                    byte[] img1 = byteArrayOutputStream.toByteArray();

                    SQLiteData sqlIteData = new SQLiteData(Dashboard_Activity.this);
                    sqlIteData.addProfilePic(img1, Nav_phone.getText().toString());
                    Toast.makeText(Dashboard_Activity.this, "Profile Picture Updated", Toast.LENGTH_SHORT).show();


                    Cursor res = sqlIteData.search(Nav_phone.getText().toString());
                    if (res.moveToFirst()) {
                        do {
                            byte[] bytes = res.getBlob(8);
                            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            Nav_profile.setImageBitmap(bitmap);
                        } while (res.moveToNext());
                    } else {
                        Toast.makeText(Dashboard_Activity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }

    private static int exifToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }


}

