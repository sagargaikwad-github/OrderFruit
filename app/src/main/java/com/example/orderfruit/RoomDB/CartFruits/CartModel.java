package com.example.orderfruit.RoomDB.CartFruits;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "cart_table")
public class CartModel {
    String userID;

    @PrimaryKey
    @NonNull
    int fruitID;
    int quantity;
    int price;
    String fruitName;

    public CartModel(String userID, int fruitID, int quantity, int price, String fruitName) {
        this.userID = userID;
        this.fruitID = fruitID;
        this.quantity = quantity;
        this.price = price;
        this.fruitName = fruitName;
    }

    @Ignore
    public CartModel(int fruitID, int quantity, int price, String fruitName) {
        this.fruitID = fruitID;
        this.quantity = quantity;
        this.price = price;
        this.fruitName = fruitName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getFruitID() {
        return fruitID;
    }

    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
