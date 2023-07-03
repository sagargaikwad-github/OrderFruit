package com.example.orderfruit.RoomDB.FruitData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.orderfruit.model.FruitData;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FruitDataDAO {
    @Insert
    void insertFruit(FruitDataModel fruitDataModel);

    @Query("Select * from fruits_table")
    List<FruitDataModel> getAllFruits();

    @Query("Select * from fruits_table where fruit_name=:getdata")
    List<FruitDataModel> getFromSearch(String getdata);


    @Query("Select * from fruits_table where fruit_season==summer")
    List<FruitDataModel> getSeasonSummer();

    @Query("Select * from fruits_table where fruit_season==monsoon")
    ArrayList<FruitDataModel> getSeasonMonsoon();

    @Query("Select * from fruits_table where fruit_season==winter")
    ArrayList<FruitDataModel> getSeasonWinter();


}
