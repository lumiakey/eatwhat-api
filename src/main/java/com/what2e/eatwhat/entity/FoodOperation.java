package com.what2e.eatwhat.entity;

public class FoodOperation {
    private Integer foodOperationId;

    private Integer foodStateFlag;

    private String oper;

    public Integer getFoodOperationId() {
        return foodOperationId;
    }

    public void setFoodOperationId(Integer foodOperationId) {
        this.foodOperationId = foodOperationId;
    }

    public Integer getFoodStateFlag() {
        return foodStateFlag;
    }

    public void setFoodStateFlag(Integer foodStateFlag) {
        this.foodStateFlag = foodStateFlag;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }
}