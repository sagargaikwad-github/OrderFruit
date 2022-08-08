package com.example.orderfruit.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.orderfruit.R;
import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.model.orderHistoryData;

import java.util.ArrayList;
import java.util.List;

public class Orderview extends AppCompatActivity {
    TextView orderview_name,orderview_address,orderview_phone,orderview_totalgross,orderview_totalprice,orderview_status;
    RecyclerView orderview_rv;
    TextView total,subtotal,deliverycharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);


        orderview_name=findViewById(R.id.orderview_name);
        orderview_address=findViewById(R.id.orderview_address);
        orderview_phone=findViewById(R.id.orderview_phone);
        orderview_rv=findViewById(R.id.orderview_rv);
//        orderview_totalgross=findViewById(R.id.totalgross_tv);
//        orderview_totalprice=findViewById(R.id.totalprice_tv);
        orderview_status=findViewById(R.id.orderstatus_tv);
        total=findViewById(R.id.total);
        subtotal=findViewById(R.id.subtotal);
        deliverycharge=findViewById(R.id.deliverycharge);

        Bundle b=getIntent().getExtras();
        int getPosition= (int) b.get("orderid");
        String getQuantityy=  b.getString("getquantity");
        String getTotalPrice= b.getString("gettotalprice");

        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
        ArrayList<orderHistoryData>arrayList=sqLiteData.getOrder(getPosition);

        orderview_name.setText(arrayList.get(0).getOrdername());
        orderview_address.setText(arrayList.get(0).getOrderaddress());
        if(arrayList.get(0).getOrderphone2().isEmpty())
        {
            orderview_phone.setText("Phone : "+arrayList.get(0).getOrderphone());
        }
        else
        {
            orderview_phone.setText("Phone : "+arrayList.get(0).getOrderphone()+"/"+arrayList.get(0).getOrderphone2());
        }

        String Payment_Status=arrayList.get(0).getOrderstats();
        if(Payment_Status.contains("Payment Successful"))
            orderview_status.setText("Payment Status : Successful");
        else
            orderview_status.setText("Payment Status : Failed");


       // orderview_totalgross.setText(getQuantityy+" Kg");
        int getTotal=Integer.parseInt(arrayList.get(0).getOrderprice());


        if(getTotal<500)
        {
            subtotal.setText("₹"+String.valueOf(getTotal));
            deliverycharge.setText("₹50");
            total.setText("₹"+String.valueOf(getTotal+50));
        }
        else
        {
            subtotal.setText("₹"+String.valueOf(getTotal));
            deliverycharge.setText("₹0");
            total.setText("₹"+String.valueOf(getTotal));
        }



//        if(getTotal<500)
//        {
//            //orderview_totalprice.setText("₹"+getTotalPrice+"/-\n(Including ₹50 DeliveryCharge)");
//            delivec=50;
//            deliverycharge.setText("₹"+50);
//            total.setText("₹"+String.valueOf(getTotal+50));
//        }
//       else
//        {
//           // orderview_totalprice.setText("₹"+getTotalPrice+"/-");
//            deliverycharge.setText("₹"+String.valueOf(delivec));
//            total.setText("₹"+String.valueOf(getTotal));
//        }




        List<FruitData> newdata=new ArrayList<>();
        String[] id=arrayList.get(0).getOrderfruitID().split(",");
        newdata=(sqLiteData.getOrderData(id));


        ArrayList<orderHistoryData> getQuantity=null;
        String[] quantity=arrayList.get(0).getOrderWeight().split(",");


        orderview_rv.setLayoutManager(new LinearLayoutManager(this));
        OrderViewAdapter orderViewAdapter=new OrderViewAdapter(newdata,this,quantity);
        orderview_rv.setAdapter(orderViewAdapter);


//
//        orderview_rv.setLayoutManager(new LinearLayoutManager(this));
//        OrderViewAdapter orderViewAdapter=new OrderViewAdapter(newdata,this,quantity[newdata.size()]);
//        orderview_rv.setAdapter(orderViewAdapter);


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Your Order");
        actionBar.setDisplayHomeAsUpEnabled(true);

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