package com.example.orderfruit.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfruit.Interface.AddToCart_Interface;
import com.example.orderfruit.RoomDB.CartFruits.CartModel;
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.OrderHistory.OrderHistoryModel;
import com.example.orderfruit.RoomDB.Registration.RegistrationModel;
import com.example.orderfruit.order.OrderHistory;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.example.orderfruit.viewfruit.FruitViewActivity;
import com.example.orderfruit.viewmorefruits.ViewMoreFruits;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ViewCart extends AppCompatActivity implements AddToCart_Interface, PaymentResultListener {
    RecyclerView ViewCart_rv, viewcart_customerinfo_rv;
    TextView viewcart_ItemTotal, viewcart_DeliveryCharge, viewcart_ToPay;
    ViewCartAdapter viewCartAdapter;
    LinearLayoutCompat viewcart_LL;
    LinearLayout empty_cart_IV;
    String DATAname, DATAphone, DATAaddress1 = " ", DATAaddress2 = " ";
    Button checkout_btn, startshopping_btn;
    int Total;
    BottomSheetDialog sheetDialog;
    String getphone;
    RadioButton address1_radiobtn, address2_radiobtn, address3_radiobtn;
    TextView customer_info_name_TV, customer_info_phone_TV;
    EditText customer_info_address_ET, customer_info_phone_ET;

    CommonDB commonDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);

        commonDB = CommonDB.getDB(this);

        Checkout.preload(getApplicationContext());

        ViewCart_rv = findViewById(R.id.viewcart_rv);
        viewcart_ItemTotal = findViewById(R.id.viewcart_itemtotal);
        viewcart_DeliveryCharge = findViewById(R.id.viewcart_DeliveryCharge);
        viewcart_ToPay = findViewById(R.id.viewcart_Topay);
        viewcart_LL = findViewById(R.id.viewcart_LL);
        empty_cart_IV = findViewById(R.id.empty_iv);

        customer_info_name_TV = findViewById(R.id.customer_info_name_TV);
        customer_info_phone_TV = findViewById(R.id.customer_info_phone_TV);
        customer_info_address_ET = findViewById(R.id.customer_info_address_ET);
        customer_info_phone_ET = findViewById(R.id.customer_info_phone_ET);
        startshopping_btn = findViewById(R.id.viewcart_startshopping_btn);


        //RadioButtons
        address1_radiobtn = findViewById(R.id.address1);
        address2_radiobtn = findViewById(R.id.address2);


        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setTitle("Cart");
        actionBar.setDisplayHomeAsUpEnabled(true);


        //Method For setting data to Recyclerview and Payment Details:
        SetData();


        ArrayList<RegistrationModel> arrayList = (ArrayList<RegistrationModel>) commonDB.registrationDAO().userData();

        // SQLiteData sqLiteData=new SQLiteData(this);
        //Cursor data=sqLiteData.headerData();
//        if(data!=null)
//        {
//            if(data.moveToFirst())
//            {
//                do{
        DATAname = arrayList.get(0).getName();
        DATAphone = arrayList.get(0).getPhone();
        DATAaddress1 = arrayList.get(0).getAddress1();
        if (DATAaddress1.isEmpty()) {
            DATAaddress1 = "";
        }
        DATAaddress2 = arrayList.get(0).getAddress2();
        ;
        if (DATAaddress2.isEmpty()) {
            DATAaddress2 = "";
        }
        //  }while (data.moveToNext());
        //}
        //  }


        customer_info_name_TV.setText(DATAname);
        customer_info_phone_TV.setText("Phone : " + DATAphone);

        checkout_btn = findViewById(R.id.checkout);
        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOnline(getApplicationContext())) {
                    String bottomsheetAddress = customer_info_address_ET.getText().toString().trim();

                    if (bottomsheetAddress.isEmpty()) {
                        Toast.makeText(ViewCart.this, "Please Provide Address", Toast.LENGTH_SHORT).show();
                    } else {

                        sheetDialog = new BottomSheetDialog(ViewCart.this, R.style.BottomSheetTheme);

                        LinearLayout sheetLayout = sheetDialog.findViewById(R.id.bottom_sheet_layout); //Layout id

                        view = LayoutInflater.from(ViewCart.this).inflate(R.layout.bottom_sheet_dialog,
                                sheetLayout);

                        sheetDialog.setContentView(view);
                        sheetDialog.show();

                        final TextView bottomsheet_name = view.findViewById(R.id.bottomsheet_name);
                        final TextView bottomsheet_address = view.findViewById(R.id.bottomsheet_address);
                        final TextView bottomsheet_phone = view.findViewById(R.id.bottomsheet_phone);

                        final TextView bottomsheet_ItemTotal = view.findViewById(R.id.viewcart_itemtotal);
                        final TextView bottomsheet_DeliveryCharge = view.findViewById(R.id.viewcart_DeliveryCharge);
                        final TextView bottomsheet_Topay = view.findViewById(R.id.viewcart_Topay);

                        bottomsheet_name.setText(DATAname);
                        bottomsheet_address.setText(bottomsheetAddress);

                        String bottomsheetPhone2 = customer_info_phone_ET.getText().toString();
                        bottomsheet_phone.setText(DATAphone + " / " + bottomsheetPhone2);


                        String getItemTotal = viewcart_ItemTotal.getText().toString();
                        String getDeliveryCharge = viewcart_DeliveryCharge.getText().toString();
                        String getToPay = viewcart_ToPay.getText().toString();
                        bottomsheet_ItemTotal.setText(getItemTotal);
                        bottomsheet_DeliveryCharge.setText(getDeliveryCharge);
                        bottomsheet_Topay.setText(getToPay);

                        final Button bottomsheet_proceed = view.findViewById(R.id.bottomsheet_proceed);
                        bottomsheet_proceed.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String totalpay = getToPay;
                                totalpay = totalpay.replace("₹ ", "");
                                int amount = Math.round(Float.parseFloat(totalpay) * 100);

                                //Razorpay Api Integration:
                                Checkout checkout = new Checkout();
                                checkout.setKeyID("rzp_test_UWjXC4YfPRGTaK");

                                JSONObject jsonObject = new JSONObject();
                                try {
                                    jsonObject.put("name", "Order Fruit App");
                                    jsonObject.put("description", "Test Payment");
                                    jsonObject.put("currency", "INR");
                                    jsonObject.put("amount", amount);
                                    jsonObject.put("prefill.contact", DATAphone);
                                    jsonObject.put("prefill.email", "email@gmail.com");
                                    checkout.open(ViewCart.this, jsonObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                    }


                } else {
                    Toast.makeText(ViewCart.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        startshopping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ViewCart.this, ViewMoreFruits.class);
                startActivity(intent1);
                ViewCart.this.finish();
            }
        });

    }


    private void SetData() {
        // SQLiteData sqLiteData=new SQLiteData(this);
        //ArrayList<FruitData>getcart=sqLiteData.get_cart_list();

        getphone = commonDB.registrationDAO().getPhone();

        ArrayList<CartModel> getCart = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);


        if (getCart.isEmpty()) {
            empty_cart_IV.setVisibility(View.VISIBLE);
            viewcart_LL.setVisibility(View.GONE);
            viewcart_ItemTotal.setText("₹0");
            viewcart_DeliveryCharge.setText(String.valueOf("₹0"));
            viewcart_ToPay.setText(String.valueOf("₹0"));
        } else {
            empty_cart_IV.setVisibility(View.GONE);
            viewcart_LL.setVisibility(View.VISIBLE);
            ViewCart_rv.setLayoutManager(new LinearLayoutManager(this));

            ArrayList<CartModel> arrayList = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);
            viewCartAdapter = new ViewCartAdapter(arrayList, this, this);
            //viewCartAdapter.notifyDataSetChanged();
            ViewCart_rv.setAdapter(viewCartAdapter);
        }

    }

    public void getdata(int sum) {
        Total = sum;
        viewcart_ItemTotal.setText("₹ " + String.valueOf(Total));

        int FreeDellivery = 0;
        int delivery_charge = 50;

        if (sum > 499) {
            viewcart_DeliveryCharge.setText(String.valueOf("₹ " + FreeDellivery));
            viewcart_ToPay.setText(String.valueOf("₹ " + (sum + FreeDellivery)));
        } else {
            delivery_charge = 50;
            viewcart_DeliveryCharge.setText(String.valueOf("₹ " + delivery_charge));
            viewcart_ToPay.setText(String.valueOf("₹ " + (sum + delivery_charge)));
        }


    }

    public void onRadioButtonClick(View view) {
        switch (view.getId()) {
            case R.id.address1:
                customer_info_address_ET.setText("");
                if (DATAaddress1.isEmpty()) {
                    Toast.makeText(this, "Address 1 Not found", Toast.LENGTH_SHORT).show();
                } else {
                    customer_info_address_ET.setText(DATAaddress1);
                }
                break;
            case R.id.address2:
                customer_info_address_ET.setText("");
                if (DATAaddress2.isEmpty()) {
                    Toast.makeText(this, "Address 2 Not found", Toast.LENGTH_SHORT).show();
                } else {
                    customer_info_address_ET.setText(DATAaddress2);
                }
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


        ArrayList<CartModel> getcart = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);


        if (getcart.isEmpty()) {
            empty_cart_IV.setVisibility(View.VISIBLE);
            viewcart_LL.setVisibility(View.GONE);
            viewcart_ItemTotal.setText("0");
            viewcart_DeliveryCharge.setText(String.valueOf("0"));
            viewcart_ToPay.setText(String.valueOf("0"));
        } else {
            empty_cart_IV.setVisibility(View.GONE);
            viewcart_LL.setVisibility(View.VISIBLE);
            ViewCart_rv.setLayoutManager(new LinearLayoutManager(this));

            ArrayList<CartModel> arrayList = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);

            viewCartAdapter = new ViewCartAdapter(arrayList, this, this);
            //viewCartAdapter.notifyDataSetChanged();
            ViewCart_rv.setAdapter(viewCartAdapter);
        }
    }


    @Override
    public void add_to_cart(int id, int num, String Phone) {
        if (num == 0) {
            commonDB.cartDAO().deleteFromCart(id, Phone);
        } else {
            commonDB.cartDAO().updateCart(id, num, Phone);
        }

    }

    @Override
    public void paymentDetails(int total, int deliverycharge, int topay) {

    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show();


        String name = customer_info_name_TV.getText().toString();
        String address = customer_info_address_ET.getText().toString();
        String phone = DATAphone;
        String phone2 = customer_info_phone_ET.getText().toString();
        String total;

        String itemtotal2 = viewcart_ItemTotal.getText().toString();
        ;
        itemtotal2 = itemtotal2.replace("₹ ", "");
        String item3 = String.valueOf(itemtotal2);


        if (Total < 499) {
            total = String.valueOf(Total + 50);
        } else {
            total = String.valueOf(Total);
        }


        ArrayList<CartModel> GetFruits = new ArrayList<>();

        ArrayList<CartModel> arrayList = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);
        GetFruits = arrayList;
        String orderstatus = "Payment Successful";


        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);

        String time = "0";

        int fid = 0;
        int fweight = 0;
        int orderid = 0;
        String getid = "";
        String getweight = "";
        int getQuantity = 0;


        for (int i = 0; i < GetFruits.size(); i++) {
            fid = GetFruits.get(i).getFruitID();
            fweight = GetFruits.get(i).getQuantity();
            getid = getid + "," + fid;
            getweight = getweight + "," + fweight;
            getQuantity = getQuantity + fweight;
        }

        String[] fruitlist1 = new String[100];

        for (int i = 0; i < GetFruits.size(); i++) {
            String fweight1 = String.valueOf(GetFruits.get(i).getQuantity());
            fruitlist1[i] = fweight1;
        }

        //Array to String Via
        String result_ScoreP1 = ("" + Arrays.asList(fruitlist1)).
                replaceAll("(^.|.$)", "  ").replace(", ", "  , ");


        SQLiteData sqLiteData = new SQLiteData(this);

        commonDB.orderHistoryDAO().insertInOrderHistory(new OrderHistoryModel(
                name, address, item3, phone, phone2, orderstatus, str, String.valueOf(getQuantity), getid, result_ScoreP1
        ));
        //  sqLiteData.addtohistory(orderid, name, address, item3, phone, phone2, orderstatus, str, String.valueOf(getQuantity), getid, result_ScoreP1);

        // sqLiteData.deleteCart(DATAphone);
        commonDB.cartDAO().deleteWholeCart(DATAphone);

        Intent intent = new Intent(this, OrderHistory.class);
        startActivity(intent);

        commonDB.fruitDataDAO().updateInFruitTable();

        // sqLiteData.removeCart(0);
        sheetDialog.dismiss();
        ViewCart.this.finish();

        FruitViewActivity fruitViewActivity = new FruitViewActivity();
        fruitViewActivity.finish();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();

        //   SQLiteData sqLiteData = new SQLiteData(this);

        String name = customer_info_name_TV.getText().toString();
        String address = customer_info_address_ET.getText().toString();
        String phone = DATAphone;
        String phone2 = customer_info_phone_ET.getText().toString();
        String total;

        if (Total < 499) {
            total = String.valueOf(Total + 50);
        } else {
            total = String.valueOf(Total);
        }


        ArrayList<CartModel> GetFruits = new ArrayList<>();

        ArrayList<CartModel> arrayList = (ArrayList<CartModel>) commonDB.cartDAO().getCart(getphone);

        GetFruits = arrayList;
        String orderstatus = "Payment Unsucessful";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String str = formatter.format(date);

        String time = "0";

        int fid = 0;
        int fweight = 0;
        int orderid = 0;
        String getid = "";
        String getweight = "";
        int getQuantity = 0;


        String itemtotal2 = viewcart_ItemTotal.getText().toString();
        ;
        itemtotal2 = itemtotal2.replace("₹ ", "");
        String item3 = String.valueOf(itemtotal2);

        for (int j = 0; j < GetFruits.size(); j++) {
            fid = GetFruits.get(j).getFruitID();
            fweight = GetFruits.get(j).getQuantity();
            getid = getid + "," + fid;
            getweight = getweight + "," + fweight;
            getQuantity = getQuantity + fweight;

        }


        String[] fruitlist1 = new String[100];

        for (int j = 0; j < GetFruits.size(); j++) {
            String fweight1 = String.valueOf(GetFruits.get(j).getQuantity());
            fruitlist1[j] = fweight1;
        }

        //Array to String Via
        String result_ScoreP1 = ("" + Arrays.asList(fruitlist1)).
                replaceAll("(^.|.$)", "  ").replace(", ", "  , ");


//        sqLiteData.addtohistory(orderid, name, address, item3, phone, phone2, orderstatus, str, String.valueOf(getQuantity), getid, result_ScoreP1);

        commonDB.orderHistoryDAO().insertInOrderHistory(new OrderHistoryModel(
                name, address, item3, phone, phone2, orderstatus, str, String.valueOf(getQuantity), getid, result_ScoreP1
        ));

        sheetDialog.dismiss();


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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return true;
    }
}
