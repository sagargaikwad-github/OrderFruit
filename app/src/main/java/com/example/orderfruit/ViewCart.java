package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfruit.model.FruitData;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewCart extends AppCompatActivity implements AddToCart_Interface , PaymentResultListener {
    RecyclerView ViewCart_rv,viewcart_customerinfo_rv;
    TextView viewcart_ItemTotal,viewcart_DeliveryCharge,viewcart_ToPay;
    String Name;
    int Id,Price,Cart;
    int a,b,c;
    ViewCartAdapter viewCartAdapter;
    LinearLayoutCompat viewcart_LL,viewcart_empty_LL;
    ImageView empty_cart_IV;
    String DATAname,DATAphone,DATAaddress1,DATAaddress2;
    Button checkout;
    int Total;
    int sum,getFruitid;

    RadioButton address1,address2,address3;
    TextView customer_info_name_TV,customer_info_phone_TV;
    EditText customer_info_address_ET,customer_info_phone_ET;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewCart_rv=findViewById(R.id.viewcart_rv);
        viewcart_ItemTotal=findViewById(R.id.viewcart_itemtotal);
        viewcart_DeliveryCharge=findViewById(R.id.viewcart_DeliveryCharge);
        viewcart_ToPay=findViewById(R.id.viewcart_Topay);
        viewcart_LL=findViewById(R.id.viewcart_LL);
        empty_cart_IV=findViewById(R.id.empty_iv);

        customer_info_name_TV=findViewById(R.id.customer_info_name_TV);
        customer_info_phone_TV=findViewById(R.id.customer_info_phone_TV);
        customer_info_address_ET=findViewById(R.id.customer_info_address_ET);
        customer_info_phone_ET=findViewById(R.id.customer_info_phone_ET);


        address1=findViewById(R.id.address1);
        address2=findViewById(R.id.address2);
        address3=findViewById(R.id.address3);


        empty_cart_IV.setImageResource(R.drawable.empty_cart_image);



        //Method For setting data to Recyclerview and Payment Details:
        SetData();

        SQLiteData sqLiteData=new SQLiteData(this);
        Cursor data=sqLiteData.headerData();
        if(data!=null)
        {
            if(data.moveToFirst())
            {
                do{
                    DATAname=data.getString(0);
                    DATAphone=data.getString(1);
                    DATAaddress1=data.getString(4);
                    DATAaddress2=data.getString(5);
                }while (data.moveToNext());
            }
        }

        customer_info_name_TV.setText(DATAname);
        customer_info_phone_TV.setText("Phone : "+DATAphone);







   checkout=findViewById(R.id.checkout);
   checkout.setOnClickListener(new View.OnClickListener()  {
       @Override
       public void onClick(View view) {
           String bottomsheetAddress=customer_info_address_ET.getText().toString();

         if(bottomsheetAddress.isEmpty())
         {
             Toast.makeText(ViewCart.this, "Please Provide Address", Toast.LENGTH_SHORT).show();
         }
         else
         {
             BottomSheetDialog sheetDialog;
             sheetDialog=new BottomSheetDialog(ViewCart.this,R.style.BottomSheetTheme);

             LinearLayout sheetLayout=sheetDialog.findViewById(R.id.bottom_sheet_layout); //Layout id

             view= LayoutInflater.from(ViewCart.this).inflate(R.layout.bottom_sheet_dialog,
                     sheetLayout);

             sheetDialog.setContentView(view);
             sheetDialog.show();

             final TextView bottomsheet_name=view.findViewById(R.id.bottomsheet_name);
             final TextView bottomsheet_address=view.findViewById(R.id.bottomsheet_address);
             final TextView bottomsheet_phone=view.findViewById(R.id.bottomsheet_phone);

             final TextView bottomsheet_ItemTotal=view.findViewById(R.id.viewcart_itemtotal);
             final TextView bottomsheet_DeliveryCharge=view.findViewById(R.id.viewcart_DeliveryCharge);
             final TextView bottomsheet_Topay=view.findViewById(R.id.viewcart_Topay);

             bottomsheet_name.setText(DATAname);
             bottomsheet_address.setText(bottomsheetAddress);

             String bottomsheetPhone2=customer_info_phone_ET.getText().toString();
             bottomsheet_phone.setText(DATAphone+" / "+bottomsheetPhone2);


             String getItemTotal=viewcart_ItemTotal.getText().toString();
             String getDeliveryCharge=viewcart_DeliveryCharge.getText().toString();
             String getToPay=viewcart_ToPay.getText().toString();
             bottomsheet_ItemTotal.setText(getItemTotal);
             bottomsheet_DeliveryCharge.setText(getDeliveryCharge);
             bottomsheet_Topay.setText(getToPay);

             final Button bottomsheet_proceed=view.findViewById(R.id.bottomsheet_proceed);
             bottomsheet_proceed.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     String totalpay=getToPay;
                     totalpay=totalpay.replace("₹ ","");
                     int amount=Math.round(Float.parseFloat(totalpay)*100);

                     //Razorpay Api Integration:
                     Checkout checkout = new Checkout();
                     checkout.setKeyID("rzp_test_UWjXC4YfPRGTaK");

                     JSONObject jsonObject=new JSONObject();
                     try {
                         jsonObject.put("name","Order Fruit App");
                         jsonObject.put("description","Test Payment");
                         jsonObject.put("currency","INR");
                         jsonObject.put("amount",amount);
                         checkout.open(ViewCart.this, jsonObject);
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }


                 }
             });

         }


       }
   });



    }



    private void SetData() {
        SQLiteData sqLiteData=new SQLiteData(this);
        ArrayList<FruitData>getcart=sqLiteData.get_cart_list();
        if(getcart.isEmpty())
        {
            empty_cart_IV.setVisibility(View.VISIBLE);
            viewcart_LL.setVisibility(View.GONE);
            viewcart_ItemTotal.setText("₹0");
            viewcart_DeliveryCharge.setText(String.valueOf("₹0"));
            viewcart_ToPay.setText(String.valueOf("₹0"));
        }
        else
        {
            empty_cart_IV.setVisibility(View.GONE);
            viewcart_LL.setVisibility(View.VISIBLE);
            ViewCart_rv.setLayoutManager(new LinearLayoutManager(this));
            viewCartAdapter=new ViewCartAdapter(sqLiteData.get_cart_list(),this,this);
            //viewCartAdapter.notifyDataSetChanged();
            ViewCart_rv.setAdapter(viewCartAdapter);
        }

    }

    public void getdata(int sum) {
        Total=sum;
        viewcart_ItemTotal.setText("₹ "+String.valueOf(Total));

        int FreeDellivery=0;
        int delivery = 50;

        if(sum>499)
        {
            viewcart_DeliveryCharge.setText(String.valueOf("₹ "+FreeDellivery));
            viewcart_ToPay.setText(String.valueOf("₹ "+(sum+FreeDellivery)));
        }
        else
        {
            delivery=50;
            viewcart_DeliveryCharge.setText(String.valueOf("₹ "+delivery));
            viewcart_ToPay.setText(String.valueOf("₹ "+(sum+delivery)));
        }


    }

    public void onRadioButtonClick(View view)
    {


            switch (view.getId())
            {
                case R.id.address1:
                    customer_info_address_ET.setText("");
                    if(DATAaddress1.isEmpty())
                    {
                        Toast.makeText(this, "Address 1 Not found", Toast.LENGTH_SHORT).show();
                    }
                   else
                    {

                        customer_info_address_ET.setText(DATAaddress1);
                    }
                    break;
                case R.id.address2:
                    customer_info_address_ET.setText("");
                    if(DATAaddress2.isEmpty())
                    {
                        Toast.makeText(this, "Address 2 Not found", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        customer_info_address_ET.setText(DATAaddress2);
                    }
                    break;
                case R.id.address3:
                    customer_info_address_ET.setText("");
                    break;

        }
    }


    @Override
    protected void onResume() {
        super.onResume();

//;       SQLiteData sqLiteData=new SQLiteData(this);
//        ViewCart_rv.setLayoutManager(new LinearLayoutManager(this));
//        viewCartAdapter=new ViewCartAdapter(sqLiteData.get_cart_list(),this,this);
//        ViewCart_rv.setAdapter(viewCartAdapter);

        SQLiteData sqLiteData=new SQLiteData(this);
        ArrayList<FruitData>getcart=sqLiteData.get_cart_list();

        if(getcart.isEmpty())
        {
            empty_cart_IV.setVisibility(View.VISIBLE);
            viewcart_LL.setVisibility(View.GONE);
            viewcart_ItemTotal.setText("0");
            viewcart_DeliveryCharge.setText(String.valueOf("0"));
            viewcart_ToPay.setText(String.valueOf("0"));
        }
        else
        {
            empty_cart_IV.setVisibility(View.GONE);
            viewcart_LL.setVisibility(View.VISIBLE);
            ViewCart_rv.setLayoutManager(new LinearLayoutManager(this));
            viewCartAdapter=new ViewCartAdapter(sqLiteData.get_cart_list(),this,this);
            //viewCartAdapter.notifyDataSetChanged();
            ViewCart_rv.setAdapter(viewCartAdapter);
        }
    }



    @Override
    public void add_to_cart(int id, int num) {
        SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
        sqLiteData.addtocart(id,num);
    }

    @Override
    public void paymentDetails(int total, int deliverycharge, int topay) {

    }

    @Override
    public void onPaymentSuccess(String s) {
        //Toast.makeText(this, "Payment Sucessful", Toast.LENGTH_SHORT).show();
        SQLiteData sqLiteData=new SQLiteData(this);

        //Intent intent=new Intent(this,ViewCart.class);
        //intent.putExtra("list",sqLiteData.get_cart_list());

//        Toast.makeText(this, customer_info_name_TV.getText().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, customer_info_address_ET.getText().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, customer_info_phone_TV.getText().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, customer_info_phone_ET.getText().toString(), Toast.LENGTH_SHORT).show();
//
//        if(Total<499)
//        {
//            Toast.makeText(this, String.valueOf(Total+50), Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            Toast.makeText(this, String.valueOf(Total), Toast.LENGTH_SHORT).show();
//        }

        String name=customer_info_name_TV.getText().toString();
        String address=customer_info_address_ET.getText().toString();
        String phone=customer_info_phone_TV.getText().toString();
        String phone2=customer_info_phone_ET.getText().toString();
        String total;

        if(Total<499)
        {
             total= String.valueOf(Total+50);
        }
        else
        {
             total= String.valueOf(Total);
        }




       ArrayList<FruitData>GetFruits=new ArrayList<>();
       GetFruits=sqLiteData.get_cart_list();
       String orderstatus="Payment Sucessful";
        String date= "0";
        String time= "0";

       int fid=0;
       int fweight=0;
       int orderid=0;
       String getid=null;
       String getweight=null;
       int getQuantity=0;
       for(int i=0;i<GetFruits.size();i++)
       {
            fid=GetFruits.get(i).getFruit_id();
            fweight=GetFruits.get(i).getFruit_addtocart();
            getid=getid+","+fid;
            getweight=getweight+","+fweight;
            getQuantity=getQuantity+fweight;

       }

       sqLiteData.addtohistory(orderid,name,address,total,phone,phone2,orderstatus,date,String.valueOf(getQuantity),getid,getweight);



        Intent intent=new Intent(this,OrderHistory.class);
        startActivity(intent);





    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();


        String name=customer_info_name_TV.getText().toString();
        String address=customer_info_address_ET.getText().toString();
        String phone=customer_info_phone_TV.getText().toString();
        String phone2=customer_info_phone_ET.getText().toString();
        String total;

        if(Total<499)
        {
            total= String.valueOf(Total+50);
        }
        else
        {
            total= String.valueOf(Total);
        }

        SQLiteData sqLiteData=new SQLiteData(this);
        ArrayList<FruitData>GetFruits=new ArrayList<>();
        GetFruits=sqLiteData.get_cart_list();
        String orderstatus="Payment Failed";
        String date= "0";


        int fid=0;
        int fweight=0;
        int orderid=0;
        String getid=null;
        String getweight=null;
        int getQuantity=0;
        for(i=0;i<GetFruits.size();i++)
        {
            fid=GetFruits.get(i).getFruit_id();
            fweight=GetFruits.get(i).getFruit_addtocart();
            getid=getid+","+fid;
            getweight=getweight+","+fweight;
            getQuantity=getQuantity+fweight;

        }

        sqLiteData.addtohistory(orderid,name,address,total,phone,phone2,orderstatus,date,String.valueOf(getQuantity),getid,getweight);


    }
}