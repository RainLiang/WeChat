package com.vincentliong.manager;

/**
 * Created by RongMa on 16/3/24.
 */
public class MessageManager
{
    private static final MessageManager msg = new MessageManager();
    private MessageManager(){}

    public static MessageManager getInstance()
    {
        return msg;
    }


}
