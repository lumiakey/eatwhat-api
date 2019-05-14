package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.OrderType;
import com.what2e.eatwhat.entity.OrderTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface OrderTypeMapper {
    int countByExample(OrderTypeExample example);

    int deleteByExample(OrderTypeExample example);

    int deleteByPrimaryKey(Integer orderTypeId);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    List<OrderType> selectByExample(OrderTypeExample example);

    OrderType selectByPrimaryKey(Integer orderTypeId);

    int updateByExampleSelective(@Param("record") OrderType record, @Param("example") OrderTypeExample example);

    int updateByExample(@Param("record") OrderType record, @Param("example") OrderTypeExample example);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}