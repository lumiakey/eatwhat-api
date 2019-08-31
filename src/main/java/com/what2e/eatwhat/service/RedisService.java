package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.entity.FoodJson;
import com.what2e.eatwhat.entity.RedisFoodListKey;

import java.util.ArrayList;

/**
 * time 上架日期 yyyy-MM-dd
 * localhostCode 销售地点 贵州贵阳
 */
public interface RedisService {
    ArrayList<FoodJson> readFoodListOfOneDay(String putTime, String locationCode);

    ArrayList<FoodJson> readFoodListOfLunchAndDinner(String putTime, String locationCode);

    ArrayList<FoodJson> readFoodDinner(String putTime, String locationCode);

    Food readFoodByRedisFoodListKey(RedisFoodListKey key);

    byte[] read(byte[] key);

    void write(byte[] key,byte[] value);

    String creatRedisFoodListKey(Food food);


}

