package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.FoodMapper;
import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.service.FoodListService;
import com.what2e.eatwhat.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lumike
 * @version v1.0
 * @title FoodListServiceImpl
 * @date 19-5-5 下午11:42
 * @Description 菜单service
 **/
@Service
public class FoodListServiceImpl implements FoodListService {

    @Autowired
    FoodMapper foodMapper;

    /**
     * 获取某时间处于上架状态的菜单
     * @param putTime  yyyy-MM-dd HH:mm:ss
     */

    @Override
    public List<Food> getFoodListFromPut(String putTime) {
        List<Food> foodList = foodMapper.selectByPutTime(putTime);
        return foodList;
    }
}
