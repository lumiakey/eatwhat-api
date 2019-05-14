package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.OrderOperation;
import com.what2e.eatwhat.entity.OrderOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface OrderOperationMapper {
    int countByExample(OrderOperationExample example);

    int deleteByExample(OrderOperationExample example);

    int deleteByPrimaryKey(Integer orderOperationId);

    int insert(OrderOperation record);

    int insertSelective(OrderOperation record);

    List<OrderOperation> selectByExample(OrderOperationExample example);

    OrderOperation selectByPrimaryKey(Integer orderOperationId);

    int updateByExampleSelective(@Param("record") OrderOperation record, @Param("example") OrderOperationExample example);

    int updateByExample(@Param("record") OrderOperation record, @Param("example") OrderOperationExample example);

    int updateByPrimaryKeySelective(OrderOperation record);

    int updateByPrimaryKey(OrderOperation record);
}