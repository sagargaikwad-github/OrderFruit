package com.example.orderfruit.RoomDB.FavouriteFruits;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavouriteDAO {
    @Query("Select FruitId from favourite_table where FruitId=:fruit_id and UserId=:phone")
    boolean checkInFavourite(String phone, int fruit_id);


    @Insert
    void insertInFavourite(FavouriteModel favouriteModel);

    @Delete
    void removeInFavourite(FavouriteModel favouriteModel);
}
