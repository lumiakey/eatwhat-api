package com.what2e.eatwhat.entity;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author lumike
 * @version v1.0
 * @title RedisFoodListKey
 * @date 19-5-10 上午11:10
 * @Description redis中foodList的key
 **/
public class RedisFoodListKey {
    private String BREAKFAST = "b";
    private String LUNCH = "l";
    private String DINNER = "d";
    private String foodTimeTips;
    private String foodTime;
    private String locationCode;
    public RedisFoodListKey(String foodTimeTipe,String foodTime,String locationCode) {
        this.foodTimeTips = foodTimeTipe;
        this.foodTime = foodTime;
        this.locationCode = locationCode;
    }

    public String getKey() {
        return buileFoodListKey();
    }

    public String buileFoodListKey() {
        StringBuilder redisFoodListKey = new StringBuilder();
        if (foodTimeTips.equals("早餐")) {
            redisFoodListKey.append(BREAKFAST);
        }
        if (foodTimeTips.equals("午餐")) {
            redisFoodListKey.append(LUNCH);
        }
        if (foodTimeTips.equals("晚餐")) {
            redisFoodListKey.append(DINNER);
        }
        redisFoodListKey.append("_");
        redisFoodListKey.append(foodTime);
        redisFoodListKey.append("_");
        redisFoodListKey.append(locationCode);
        return redisFoodListKey.toString();
    }
}
