package com.vincentliong.manager;



/**
 * 最新消息的管理类
 * Created by RongMa on 16/3/24.
 */
public class LatestMessageManager
{
    private final static LatestMessageManager manager = new LatestMessageManager();

    private LatestMessageManager(){}

    public static LatestMessageManager getInstance()
    {
        return manager;
    }

}
