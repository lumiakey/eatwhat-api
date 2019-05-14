package com.what2e.eatwhat.entity;

public class OrderDesc {
    private Integer orderDescId;

    private Integer orderId;

    private Integer foodId;

    private String foodName;

    private String foodPrice;

    private Integer orderAmount;

    public Integer getOrderDescId() {
        return orderDescId;
    }

    public void setOrderDescId(Integer orderDescId) {
        this.orderDescId = orderDescId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice == null ? null : foodPrice.trim();
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }
}