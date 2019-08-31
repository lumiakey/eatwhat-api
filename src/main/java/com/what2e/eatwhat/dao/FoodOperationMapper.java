package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.FoodOperation;
import com.what2e.eatwhat.entity.FoodOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
public interface FoodOperationMapper {
    int countByExample(FoodOperationExample example);

    int deleteByExample(FoodOperationExample example);

    int deleteByPrimaryKey(Integer foodOperationId);

    int insert(FoodOperation record);

    int insertSelective(FoodOperation record);

    List<FoodOperation> selectByExample(FoodOperationExample example);

    FoodOperation selectByPrimaryKey(Integer foodOperationId);

    int updateByExampleSelective(@Param("record") FoodOperation record, @Param("example") FoodOperationExample example);

    int updateByExample(@Param("record") FoodOperation record, @Param("example") FoodOperationExample example);

    int updateByPrimaryKeySelective(FoodOperation record);

    int updateByPrimaryKey(FoodOperation record);
}