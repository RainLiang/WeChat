package com.vincentliong.global;

import android.app.Application;

/**
 * Created by RongMa on 16/3/24.
 */
public class WeChatApplication extends Application
{
    private static WeChatApplication application = new WeChatApplication();
    private WeChatApplication(){}

    public static WeChatApplication getInstance()
    {
        return application;
    }

}
