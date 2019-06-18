package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.Date;

public class ResponseOrder {
    Integer oderId;
    Integer orderType;
    String orderRemarks;
    String orderPrice;
    String address;
    Date createTime;
    ArrayList<OrderDesc> orderDesc;

    public Integer getOderId() {
        return oderId;
    }

    public void setOderId(Integer oderId) {
        this.oderId = oderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ArrayList<OrderDesc> getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(ArrayList<OrderDesc> orderDesc) {
        this.orderDesc = orderDesc;
    }
}
