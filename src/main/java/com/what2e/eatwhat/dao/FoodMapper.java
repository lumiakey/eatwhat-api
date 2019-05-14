package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.entity.FoodExample;
import java.util.List;

import com.what2e.eatwhat.entity.FoodOperation;
import org.apache.ibatis.annotations.Param;

public interface FoodMapper {
    int countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByPutTime(String putTime);

    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Integer foodId);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}