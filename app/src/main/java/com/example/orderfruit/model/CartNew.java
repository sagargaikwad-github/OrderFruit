package com.example.orderfruit.model;

public class CartNew {
    String phoneid,fruit_name;
    int fruitid,fruit_quantity,fruit_price;

    public CartNew() {
    }

    public CartNew(String phoneid, String fruit_name, int fruitid, int fruit_quantity, int fruit_price) {
        this.phoneid = phoneid;
        this.fruit_name = fruit_name;
        this.fruitid = fruitid;
        this.fruit_quantity = fruit_quantity;
        this.fruit_price = fruit_price;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid;
    }

    public String getFruit_name() {
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    public int getFruitid() {
        return fruitid;
    }

    public void setFruitid(int fruitid) {
        this.fruitid = fruitid;
    }

    public int getFruit_quantity() {
        return fruit_quantity;
    }

    public void setFruit_quantity(int fruit_quantity) {
        this.fruit_quantity = fruit_quantity;
    }

    public int getFruit_price() {
        return fruit_price;
    }

    public void setFruit_price(int fruit_price) {
        this.fruit_price = fruit_price;
    }
}
