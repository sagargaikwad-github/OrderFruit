package com.example.orderfruit.model;

public class FruitData {
    int fruit_id;
    String fruit_name;
    int fruit_price;
    int fruit_quantity;
    String fruit_description1;
    String fruit_description2;
    String fruit_description3;
    String fruit_description4;
    byte[] fruit_image;
    int fruit_addtocart;
    int fruit_favourite;
    String fruit_category;
    String fruit_season;


    public FruitData(int fruit_id, String fruit_name, int fruit_price, int fruit_quantity, String fruit_description1, String fruit_description2, String fruit_description3, String fruit_description4, byte[] fruit_image, int fruit_addtocart, int fruit_favourite, String fruit_category, String fruit_season) {
        this.fruit_id = fruit_id;
        this.fruit_name = fruit_name;
        this.fruit_price = fruit_price;
        this.fruit_description1 = fruit_description1;
        this.fruit_description2 = fruit_description2;
        this.fruit_description3 = fruit_description3;
        this.fruit_description4 = fruit_description4;
        this.fruit_image = fruit_image;
        this.fruit_addtocart = fruit_addtocart;
        this.fruit_favourite = fruit_favourite;
        this.fruit_category = fruit_category;
        this.fruit_season = fruit_season;
    }

    public int getFruit_id() {
        return fruit_id;
    }

    public void setFruit_id(int fruit_id) {
        this.fruit_id = fruit_id;
    }

    public String getFruit_name() {
        return fruit_name;
    }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    public int getFruit_price() {
        return fruit_price;
    }

    public void setFruit_price(int fruit_price) {
        this.fruit_price = fruit_price;
    }

    public String getFruit_description1() {
        return fruit_description1;
    }

    public void setFruit_description1(String fruit_description1) {
        this.fruit_description1 = fruit_description1;
    }

    public String getFruit_description2() {
        return fruit_description2;
    }

    public void setFruit_description2(String fruit_description2) {
        this.fruit_description2 = fruit_description2;
    }

    public String getFruit_description3() {
        return fruit_description3;
    }

    public void setFruit_description3(String fruit_description3) {
        this.fruit_description3 = fruit_description3;
    }

    public String getFruit_description4() {
        return fruit_description4;
    }

    public void setFruit_description4(String fruit_description4) {
        this.fruit_description4 = fruit_description4;
    }

    public byte[] getFruit_image() {
        return fruit_image;
    }

    public void setFruit_image(byte[] fruit_image) {
        this.fruit_image = fruit_image;
    }

    public int getFruit_addtocart() {
        return fruit_addtocart;
    }

    public void setFruit_addtocart(int fruit_addtocart) {
        this.fruit_addtocart = fruit_addtocart;
    }

    public int getFruit_favourite() {
        return fruit_favourite;
    }

    public void setFruit_favourite(int fruit_favourite) {
        this.fruit_favourite = fruit_favourite;
    }

    public String getFruit_category() {
        return fruit_category;
    }

    public void setFruit_category(String fruit_category) {
        this.fruit_category = fruit_category;
    }

    public String getFruit_season() {
        return fruit_season;
    }

    public void setFruit_season(String fruit_season) {
        this.fruit_season = fruit_season;
    }
}
