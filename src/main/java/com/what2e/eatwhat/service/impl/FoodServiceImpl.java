package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.FoodMapper;
import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lumike
 * @version v1.0
 * @title
 * @date
 * @Description
 **/
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public Integer add(Food food) {
        return foodMapper.insertSelective(food);
    }

    @Override
    public void romove(Integer foodId) {
        foodMapper.deleteByPrimaryKey(foodId);
    }

    @Override
    public boolean putaway(Integer foodId) {
        return false;
    }

    @Override
    public boolean soldOut(Integer foodId) {
        return false;
    }
}
