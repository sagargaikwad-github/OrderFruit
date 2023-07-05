package com.example.orderfruit.RoomDB.OrderHistory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface OrderHistoryDAO {

    @Insert
    void insertInOrderHistory(OrderHistoryModel orderHistoryModel);

    @Query("DELETE from order_history_table where orderphone=:DATAphone")
    void deleteInOrderHistory(String DATAphone);

    @Query("select * from order_history_table where orderphone=:getPhone")
    List<OrderHistoryModel> getHistory(String getPhone);


    @Query("select * from order_history_table where orderid=:getPosition")
    List<OrderHistoryModel> getOrder(int getPosition);

}
