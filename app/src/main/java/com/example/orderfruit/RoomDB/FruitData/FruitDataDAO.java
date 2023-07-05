package com.example.orderfruit.RoomDB.FruitData;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FruitDataDAO {
    @Insert
    void insertFruit(FruitDataModel fruitDataModel);

    @Query("Select * from fruits_table")
    List<FruitDataModel> getAllFruits();

    @Query("Select * from fruits_table where fruit_name=:getdata")
    List<FruitDataModel> getFromSearch(String getdata);


    @Query("Select * from fruits_table where fruit_season='summer'")
    List<FruitDataModel> getSeasonSummer();

    @Query("Select * from fruits_table where fruit_season='monsoon'")
    List<FruitDataModel> getSeasonMonsoon();

    @Query("Select * from fruits_table where fruit_season='winter'")
    List<FruitDataModel> getSeasonWinter();


    @Query("select * from fruits_table where fruit_category=:fruitname")
    List<FruitDataModel> getCategory(String fruitname);

    @Query("select * from fruits_table where fruit_price<=60")
    List<FruitDataModel> getTopDeals();


    @Query("select * from fruits_table LEFT JOIN favourite_table on fruits_table.fruit_id==favourite_table.FruitId where UserId=:id")
    List<FruitDataModel>getInMainFruitList(long id);


    @Query("update fruits_table set fruit_addtocart=0")
    void updateInFruitTable();


    @Query("select * from fruits_table where fruit_id=:id")
    List<FruitDataModel> getOrderData(String id);
}
