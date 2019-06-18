package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Food;

public interface FoodService {
    Integer add(Food food);

    void romove(Integer foodId);

    boolean putaway(Integer foodId);

    boolean soldOut(Integer foodId);
}
