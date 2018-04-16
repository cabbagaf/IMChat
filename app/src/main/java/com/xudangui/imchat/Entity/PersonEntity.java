package com.xudangui.imchat.Entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by xudangui on 2018/4/14.
 */

public class PersonEntity extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}