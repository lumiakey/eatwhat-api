package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Order;
import com.what2e.eatwhat.entity.RequestOrder;

public interface OrderService {
    Order getOrderByPhonenumber(String phonenumber);

    Integer submitOrders(Order order);

    boolean submitOrder(RequestOrder requestOrder);

    void paymentOrder(Order order);

    void cancelOrder(int orderId);

}
