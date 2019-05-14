package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.OrderDesc;
import com.what2e.eatwhat.entity.OrderDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDescMapper {
    int countByExample(OrderDescExample example);

    int deleteByExample(OrderDescExample example);

    int deleteByPrimaryKey(Integer orderDescId);

    int insert(OrderDesc record);

    int insertSelective(OrderDesc record);

    List<OrderDesc> selectByExample(OrderDescExample example);

    OrderDesc selectByPrimaryKey(Integer orderDescId);

    int updateByExampleSelective(@Param("record") OrderDesc record, @Param("example") OrderDescExample example);

    int updateByExample(@Param("record") OrderDesc record, @Param("example") OrderDescExample example);

    int updateByPrimaryKeySelective(OrderDesc record);

    int updateByPrimaryKey(OrderDesc record);
}