package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.OrderDesc;

import java.util.ArrayList;

public interface OrderDescService {
    Integer submitOrderDesc(OrderDesc orderDesc);

    ArrayList<OrderDesc> getOrderDescByOrderId(Integer orderId);
}
