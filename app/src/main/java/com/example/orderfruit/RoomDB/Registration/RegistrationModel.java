package com.example.orderfruit.RoomDB.Registration;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "registration_table")
public class RegistrationModel {
    private String name;

    @PrimaryKey()
    @NonNull
    private String phone;

    private String password;
    private int isLogin;
    private String Address1;
    private String Address2;
    private String ZipCode;
    private String mail;
    private byte[] Image;


    public RegistrationModel() {
    }

    public RegistrationModel(String name, @NonNull String phone, String password, int isLogin, String address1, String address2, String zipCode, String mail, byte[] image) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.isLogin = isLogin;
        this.Address1 = address1;
        this.Address2 = address2;
        this.ZipCode = zipCode;
        this.mail = mail;
        this.Image = image;
    }


    @Ignore
    public RegistrationModel(String name, String password, int isLogin, String address1, String address2, String zipCode, String mail, byte[] image) {
        this.name = name;
        this.password = password;
        this.isLogin = isLogin;
        this.Address1 = address1;
        this.Address2 = address2;
        this.ZipCode = zipCode;
        this.mail = mail;
        this.Image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
