package com.what2e.eatwhat.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lumike
 * @version v1.0
 * @title RequestOrder
 * @date 19-5-12 上午2:23
 * @Description request过来的订单json
 **/
public class RequestOrder {
    Integer userId;
    String orderRemarks;
    String orderPrice;
    String address;
    String createTime;
    ArrayList<RequestOrderDesc> orderDesc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public void setAddressId(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public ArrayList<RequestOrderDesc> getOrderDescs() {
        return orderDesc;
    }

    public void setOrderDescs(ArrayList<RequestOrderDesc> requestOrderDesc) {
        this.orderDesc = requestOrderDesc;
    }
}
