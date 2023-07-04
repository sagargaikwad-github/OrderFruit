package com.example.orderfruit.RoomDB.CartFruits;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CartDAO {

    @Insert
    void insertInCart(CartModel cartModel);

    @Query("Select quantity from cart_table where fruitID=:id and userID=:getPhoneID")
    boolean isFruitAlreadyAdded(int id, String getPhoneID);

    @Query("Update cart_table set quantity=:product where fruitID=:id and userID=:getPhoneID")
    void updateCart(int id, int product, String getPhoneID);

    @Query("Select quantity from cart_table where fruitID=:id and userID=:getPhone")
    int getFruitCount(int id, String getPhone);

    @Query("Delete from cart_table where fruitID=:id")
    void deleteFromCart(int id);
}
