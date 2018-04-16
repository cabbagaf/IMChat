package com.xudangui.imchat.application;

import android.app.Application;

import com.xudangui.imchat.BuildConfig;
import com.xudangui.imchat.handler.MessageHandler;

import org.xutils.x;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import cn.bmob.newim.BmobIM;

/**
 * Created by xudangui on 2018/4/10.
 */

public class ImChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化xUtil
        x.Ext.init(this);

        if (getApplicationInfo().packageName.equals(getMyProcessName())){
            BmobIM.init(this);
            BmobIM.registerDefaultMessageHandler(new MessageHandler());
        }
    }

    /**
     * 获取当前运行的进程名
     * @return
     */
    public static String getMyProcessName() {
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
            String processName = mBufferedReader.readLine().trim();
            mBufferedReader.close();
            return processName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
