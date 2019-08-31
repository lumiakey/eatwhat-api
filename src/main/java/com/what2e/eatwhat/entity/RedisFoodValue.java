package com.what2e.eatwhat.entity;

import java.io.Serializable;

/**
 * @author lumike
 * @version v1.0
 * @title RedisOrderKey
 * @date 19-5-11 下午3:06
 * @Description redis抢购 库存 可抢购数量
 * redis中key为商品id时的value
 **/


public class RedisFoodValue implements Serializable {
    private int inventory;  //总的库存
    private int remainder; //余量
    private int buyCount;  //购买次数

    public RedisFoodValue(int inventory) {
        this.inventory = inventory;
        this.remainder = inventory;
        this.buyCount = 0;
    }


    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getRemainder() {
        return remainder;
    }

    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

}
