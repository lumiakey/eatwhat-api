package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.OrderDescMapper;
import com.what2e.eatwhat.entity.OrderDesc;
import com.what2e.eatwhat.service.OrderDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.Filter;

import java.util.ArrayList;

/**
 * @author lumike
 * @version v1.0
 * @title OrderDescServiceImpl
 * @date 19-5-12 上午5:02
 * @Description 订单详情服务类
 **/

@Service
public class OrderDescServiceImpl implements OrderDescService {

    @Autowired
    OrderDescMapper orderDescMapper;

    @Override
    public Integer submitOrderDesc(OrderDesc orderDesc) {
        if (orderDesc != null) {
            return orderDescMapper.insert(orderDesc);
        }
        return null;
    }

    @Override
    public ArrayList<OrderDesc> getOrderDescByOrderId(Integer orderId) {
        return orderDescMapper.selectByOrderId(orderId);
    }
}
