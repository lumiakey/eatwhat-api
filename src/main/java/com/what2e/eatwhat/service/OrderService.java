package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Order;
import com.what2e.eatwhat.entity.RequestOrder;

import java.util.ArrayList;

public interface OrderService {
    ArrayList<Order> getOrderByUserId(Integer userId);

    Order getOrderByPhonenumber(String phonenumber);

    Order getOrderByOrderId(Integer orderId);

    Integer submitOrders(Order order);

    Integer submitOrder(RequestOrder requestOrder);

    void paymentOrder(Order order);

    void cancelOrder(int orderId);

}
