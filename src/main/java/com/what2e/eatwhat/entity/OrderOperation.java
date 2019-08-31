package com.what2e.eatwhat.entity;

public class OrderOperation {
    private Integer orderOperationId;

    private Integer orderTypeId;

    private String oper;

    public Integer getOrderOperationId() {
        return orderOperationId;
    }

    public void setOrderOperationId(Integer orderOperationId) {
        this.orderOperationId = orderOperationId;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }
}