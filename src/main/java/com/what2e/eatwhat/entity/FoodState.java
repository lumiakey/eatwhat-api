package com.what2e.eatwhat.entity;

public class FoodState {
    private Integer foodStateId;

    private Integer foodStateFlag;

    private String foodStateName;

    public Integer getFoodStateId() {
        return foodStateId;
    }

    public void setFoodStateId(Integer foodStateId) {
        this.foodStateId = foodStateId;
    }

    public Integer getFoodStateFlag() {
        return foodStateFlag;
    }

    public void setFoodStateFlag(Integer foodStateFlag) {
        this.foodStateFlag = foodStateFlag;
    }

    public String getFoodStateName() {
        return foodStateName;
    }

    public void setFoodStateName(String foodStateName) {
        this.foodStateName = foodStateName == null ? null : foodStateName.trim();
    }
}