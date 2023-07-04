package com.example.orderfruit.RoomDB.FavouriteFruits;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "favourite_table")
public class FavouriteModel {

    String UserId;

    @PrimaryKey()
    int FruitId;


    public FavouriteModel() {
    }

    @Ignore
    public FavouriteModel(String userId, int fruitId) {
        UserId = userId;
        FruitId = fruitId;
    }

    @Ignore
    public FavouriteModel(String userId) {
        UserId = userId;
    }


    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getFruitId() {
        return FruitId;
    }

    public void setFruitId(int fruitId) {
        FruitId = fruitId;
    }
}
