package com.xudangui.imchat.Entity;

import java.util.Date;

import cn.bmob.v3.BmobObject;

/**
 * Created by xudangui on 2018/4/12.
 */

public class MessageListEntity extends BmobObject{

    private String username;

    private String message;

    private String image;

    private String isRead;

    private String latestTime;

    private String to;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
