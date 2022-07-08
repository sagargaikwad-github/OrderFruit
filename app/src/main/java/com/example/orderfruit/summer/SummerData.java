package com.example.orderfruit.summer;

public class SummerData {
    int id,price,quantity;
    byte[] image;
    String name,description;

    public SummerData(int summer_id, String summer_fruit_name, int summer_fruit_price, String summer_fruit_description, String summer_fruit_quantity, byte[] summer_fruit_image) {
    }

    public SummerData(int id, String name, int price, String description, int quantity, byte[] image) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
