package com.what2e.eatwhat.entity;

import java.util.Date;

/**
 * @author lumike
 * @version v1.0
 * @title FoodJson
 * @date 19-5-6 下午3:19
 * @Description 用于传输到用户端的Food类
 **/
public class FoodJson {

    private Integer foodId;

    private String foodName;

    private String foodPrice;

    private String foodPicture;

    private String timeTips;

    private String foodDesc;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(String foodPicture) {
        this.foodPicture = foodPicture;
    }

    public String getTimeTips() {
        return timeTips;
    }

    public void setTimeTips(String timeTips) {
        this.timeTips = timeTips;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }
}
