package com.what2e.eatwhat.entity;


/**
 * @author lumike
 * @version v1.0
 * @title LoginSatatus
 * @date 19-5-4 下午5:17
 * @Description 登录验证结果返回类
 **/

public class Result {
    private int statusCode;
    private String statusDescription;

    public Result(int statusCode,String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
