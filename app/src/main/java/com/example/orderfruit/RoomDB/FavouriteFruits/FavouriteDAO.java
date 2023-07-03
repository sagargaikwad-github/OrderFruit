package com.example.orderfruit.RoomDB.FavouriteFruits;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavouriteDAO {
    @Query("Select FruitId from favourite_table where FruitId=:fruit_id and UserId=:phone")
    boolean checkInFavourite(String phone, int fruit_id);

    @Delete
    void removeinFavourite(String phone, int fruit_id);

    @Insert
    void insertinFavourite(String phone, int fruit_id);


}
