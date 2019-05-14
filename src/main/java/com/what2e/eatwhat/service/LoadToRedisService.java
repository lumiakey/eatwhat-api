package com.what2e.eatwhat.service;


public interface LoadToRedisService {
    void loadFoodListToRedisFromDB(String putTime);
}
