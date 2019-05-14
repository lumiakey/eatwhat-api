package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.OrderMapper;
import com.what2e.eatwhat.entity.*;
import com.what2e.eatwhat.service.OrderDescService;
import com.what2e.eatwhat.service.OrderService;
import com.what2e.eatwhat.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author lumike
 * @version v1.0
 * @title OrderServiceImpl
 * @date 19-5-5 上午2:47
 * @Description 订单相关Service实现
 **/
@Service
public class OrderServiceImpl implements OrderService {

    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderDescService orderDescService;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order getOrderByPhonenumber(String phonenumber) {
        Order order = new Order();
        if (phonenumber != null && phonenumber != "") {
            order = orderMapper.selectByPhonenumber(phonenumber);
        }
        return order;
    }

    @Override
    public Integer submitOrders(Order order) {
        if (order != null) {
            orderMapper.insert(order);
            return order.getOrderId();
        }
        return null;
    }

    /**
     * 存在一些问题就是 订单是直接通过前端穿过来的金额数据入库 提交订单 这样伪装的请求也会通过
     * 哪怕是虚假金额也会提交成功 后期要考虑优化
     * @param requestOrder
     * @return
     */
    @Override
    public boolean submitOrder(RequestOrder requestOrder) {
        boolean flag = true;
        Order order = new Order();
        order.setuId(requestOrder.getUserId());
        order.setAddressId(requestOrder.getAddressId());
        try {
            order.setCreateTime(DateUtils.dateParse(requestOrder.getCreateTime(), DateUtils.HOUR_PATTERN));
        } catch (ParseException e) {
            logger.info("入库获取订单日期失败");
        }
        order.setOrderPrice(requestOrder.getOrderPrice());
        order.setOrderRemarks(requestOrder.getOrderRemarks());
        Integer orderId = submitOrders(order);
        if (orderId != null) {
            ArrayList<RequestOrderDesc> descArrayList = requestOrder.getOrderDescs();
            for (RequestOrderDesc requestOrderDesc : descArrayList) {
                OrderDesc orderDesc = new OrderDesc();
                orderDesc.setOrderId(orderId);
                orderDesc.setFoodId(requestOrderDesc.getFoodId());
                orderDesc.setFoodName(requestOrderDesc.getFoodName());
                orderDesc.setOrderAmount(requestOrderDesc.getOrderAmount());
                orderDesc.setFoodPrice(requestOrderDesc.getFoodPrice());
                Integer orderDescId = orderDescService.submitOrderDesc(orderDesc);
                if (orderDescId == null) {
                    flag = false;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    @Override
    public void paymentOrder(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void cancelOrder(int orderId) {
        orderMapper.deleteByPrimaryKey(orderId);
    }


}
