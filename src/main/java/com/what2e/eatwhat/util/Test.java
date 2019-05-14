package com.what2e.eatwhat.util;

import com.what2e.eatwhat.dao.OrderMapper;
import com.what2e.eatwhat.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Date;

/**
 * @author lumike
 * @version v1.0
 * @title Test
 * @date 19-5-5 下午11:27
 * @Description 测试 时间类
 **/
public class Test {
    @Autowired
    static OrderMapper orderMapper;

    public static void main(String[] args) {
        Order order = new Order();
        order.setuId(1);
        order.setAddressId(1);
        try {
            order.setCreateTime(DateUtils.dateParse("2019-05-10 09:00:01", DateUtils.HOUR_PATTERN));
        } catch (ParseException e) {
        }
        order.setOrderPrice("11");
        order.setOrderRemarks("");
        System.out.println("插入之前"+order.getOrderId());

        orderMapper.insert(order);

        System.out.println("插入之后"+order.getOrderId());
    }
}
