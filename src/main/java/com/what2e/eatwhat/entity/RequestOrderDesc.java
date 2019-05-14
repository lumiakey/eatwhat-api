package com.what2e.eatwhat.entity;

/**
 * @author lumike
 * @version v1.0
 * @title RequestOrderDesc
 * @date 19-5-12 下午9:14
 * @Description request过来的订单详情json
 **/
public class RequestOrderDesc {

    private Integer foodId;

    private String foodName;

    private String foodPrice;

    private Integer orderAmount;

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

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }
}

