package com.what2e.eatwhat.entity;

import java.io.Serializable;
import java.util.Date;

public class Information implements Serializable {
    private Integer infoId;

    private String infoPicture;

    private String infoUrl;

    private Date creatTime;

    private Date issueTime;

    private Date downTime;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getInfoPicture() {
        return infoPicture;
    }

    public void setInfoPicture(String infoPicture) {
        this.infoPicture = infoPicture == null ? null : infoPicture.trim();
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl == null ? null : infoUrl.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }
}