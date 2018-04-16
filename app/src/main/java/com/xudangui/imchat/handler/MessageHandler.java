package com.xudangui.imchat.handler;

import cn.bmob.newim.event.MessageEvent;
import cn.bmob.newim.event.OfflineMessageEvent;
import cn.bmob.newim.listener.BmobIMMessageHandler;

/**
 * Created by xudangui on 2018/4/10.
 */

public class MessageHandler extends BmobIMMessageHandler {

    /**
     * 在线接收信息
     * @param messageEvent
     */
    @Override
    public void onMessageReceive(MessageEvent messageEvent) {
        super.onMessageReceive(messageEvent);
    }

    /**
     * 离线接收信息
     * @param offlineMessageEvent
     */
    @Override
    public void onOfflineReceive(OfflineMessageEvent offlineMessageEvent) {
        super.onOfflineReceive(offlineMessageEvent);
    }
}
