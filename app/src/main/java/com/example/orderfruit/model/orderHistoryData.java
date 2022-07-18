package com.example.orderfruit.model;

public class orderHistoryData {
    int orderid;
    String ordername;
    String orderaddress;
    String orderprice;
    String orderphone;
    String orderphone2;
    String orderstats;
    String orderdate;
    String orderquanity;
    String orderfruitID;
    String orderWeight;

    
    public String getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(String orderWeight) {
        this.orderWeight = orderWeight;
    }

    public orderHistoryData(int orderid, String ordername, String orderaddress, String orderprice, String orderphone, String orderphone2, String orderstats, String orderdate, String orderquanity, String orderfruitID,String orderWeight) {
        this.orderid = orderid;
        this.ordername = ordername;
        this.orderaddress = orderaddress;
        this.orderprice = orderprice;
        this.orderphone = orderphone;
        this.orderphone2 = orderphone2;
        this.orderstats = orderstats;
        this.orderdate = orderdate;
        this.orderquanity = orderquanity;
        this.orderfruitID = orderfruitID;
        this.orderWeight = orderWeight;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getOrderphone() {
        return orderphone;
    }

    public void setOrderphone(String orderphone) {
        this.orderphone = orderphone;
    }

    public String getOrderphone2() {
        return orderphone2;
    }

    public void setOrderphone2(String orderphone2) {
        this.orderphone2 = orderphone2;
    }

    public String getOrderstats() {
        return orderstats;
    }

    public void setOrderstats(String orderstats) {
        this.orderstats = orderstats;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrderquanity() {
        return orderquanity;
    }

    public void setOrderquanity(String orderquanity) {
        this.orderquanity = orderquanity;
    }

    public String getOrderfruitID() {
        return orderfruitID;
    }

    public void setOrderfruitID(String orderfruitID) {
        this.orderfruitID = orderfruitID;
    }
}
