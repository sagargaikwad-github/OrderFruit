package com.example.orderfruit.RoomDB.Registration;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RegistrationDAO {

    @Insert
    void insert(RegistrationModel registrationModel);

    @Update
    void update(RegistrationModel registrationModel);

    @Query("Select * from registration_table")
    List<RegistrationModel> getUser();

    @Query("Select phone from registration_table where phone=:phone")
    boolean checkUser(String phone);


    @Query("Select phone from registration_table where phone=:login")
    boolean validUser(String login);

    @Query("Select phone,password from registration_table where phone=:username and password=:password")
    boolean login(String username, String password);

    @Query("update registration_table set isLogin=:i where phone=:username")
    void updateLogin(String username, int i);


    @Query("select phone from registration_table where isLogin=1")
    String getPhone();
}
