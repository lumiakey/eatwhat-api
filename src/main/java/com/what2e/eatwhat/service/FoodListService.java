package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Food;

import java.util.List;

public interface FoodListService {
    List<Food> getFoodListFromPut(String putTime);
}
