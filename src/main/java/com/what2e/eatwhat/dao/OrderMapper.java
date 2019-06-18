package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.Order;
import com.what2e.eatwhat.entity.OrderExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int insert(Order record);

    int deleteByPrimaryKey(Integer orderId);

    int insertSelective(Order record);

    ArrayList<Order> selectByUserId(Integer userId);

    Order selectByPhonenumber(String phonenumber);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectByExample(OrderExample example);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}