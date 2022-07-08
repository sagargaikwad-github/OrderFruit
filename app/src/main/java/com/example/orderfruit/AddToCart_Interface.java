package com.example.orderfruit;

import com.example.orderfruit.model.SQLiteData;

public interface AddToCart_Interface {
    void add_to_cart(int id,int num);
    void paymentDetails(int total,int deliverycharge,int topay);
}
