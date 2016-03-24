package com.vincentliong.model;


/**
 * Created by RongMa on 16/3/24.
 */
public class Message
{
    private String fromId; //谁发的
    private String toId;  //发给谁
    private String contentType; //内容类型 (0 时间文本  1 文本内容  2 图片内容  3 声音内容)
    private String textContent; //文本内容
    private String imageContentPath; //图片内容
    private String timeContent; //时间文本
    private String soundContentPath; //声音内容
    private String createdTime; //信息创建时间

    public Message(String fromId, String toId, String contentType, String textContent,
                   String imageContentPath, String timeContent, String soundContentPath, String createdTime) {
        this.fromId = fromId;
        this.toId = toId;
        this.contentType = contentType;
        this.textContent = textContent;
        this.imageContentPath = imageContentPath;
        this.timeContent = timeContent;
        this.soundContentPath = soundContentPath;
        this.createdTime = createdTime;
    }

    public Message(){}

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
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

    public String getImageContentPath() {
        return imageContentPath;
    }

    public void setImageContentPath(String imageContentPath) {
        this.imageContentPath = imageContentPath;
    }

    public String getSoundContentPath() {
        return soundContentPath;
    }

    public void setSoundContentPath(String soundContentPath) {
        this.soundContentPath = soundContentPath;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getTimeContent() {
        return timeContent;
    }

    public void setTimeContent(String timeContent) {
        this.timeContent = timeContent;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }
}
