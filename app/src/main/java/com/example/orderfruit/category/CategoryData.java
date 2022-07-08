package com.example.orderfruit.category;

public class CategoryData {
    int Category_image;
    String Category_name;

    public CategoryData(int category_image, String category_name) {
        Category_image = category_image;
        Category_name = category_name;
    }

    public int getCategory_image() {
        return Category_image;
    }

    public void setCategory_image(int category_image) {
        Category_image = category_image;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }
}
