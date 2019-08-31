package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.FoodState;
import com.what2e.eatwhat.entity.FoodStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface FoodStateMapper {
    int countByExample(FoodStateExample example);

    int deleteByExample(FoodStateExample example);

    int deleteByPrimaryKey(Integer foodStateId);

    int insert(FoodState record);

    int insertSelective(FoodState record);

    List<FoodState> selectByExample(FoodStateExample example);

    FoodState selectByPrimaryKey(Integer foodStateId);

    int updateByExampleSelective(@Param("record") FoodState record, @Param("example") FoodStateExample example);

    int updateByExample(@Param("record") FoodState record, @Param("example") FoodStateExample example);

    int updateByPrimaryKeySelective(FoodState record);

    int updateByPrimaryKey(FoodState record);
}