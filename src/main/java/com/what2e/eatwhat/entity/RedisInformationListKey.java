package com.what2e.eatwhat.entity;



import java.io.Serializable;

public class RedisInformationListKey implements Serializable {
    private String infoTime;
    private String locationCode;

    public RedisInformationListKey(String infoTime, String locationCode) {
        this.infoTime = infoTime;
        this.locationCode = locationCode;
    }

    public RedisInformationListKey(String infoTime) {
        this.infoTime = infoTime;
    }

    public String getKey() {
        StringBuilder stringBuilder = new StringBuilder();
        if (infoTime != null) {
            stringBuilder.append("info_");
            stringBuilder.append(infoTime);
        }
        return stringBuilder.toString();
    }

}
