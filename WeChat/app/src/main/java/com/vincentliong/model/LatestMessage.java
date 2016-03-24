package com.vincentliong.model;


/**
 * Created by RongMa on 16/3/24.
 */
public class LatestMessage
{
    private String userId;
    private String fromId;
    private String textContent;
    private String contentType; //内容样式
    private String updateTime;

    public LatestMessage() {
    }

    public LatestMessage(String userId,String fromId, String textContent,String contentType, String updateTime) {
        this.contentType = contentType;
        this.fromId = fromId;
        this.textContent = textContent;
        this.updateTime = updateTime;
        this.userId = userId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
