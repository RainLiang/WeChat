package com.vincentliong.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vincentliong.model.LatestMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RongMa on 16/3/24.
 */
public class LatestMessageHelper
{
    private static String DB_NAME="latest.db";
    private static int DB_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;
    private WeChatDatabaseHelper dbHelper;

    public LatestMessageHelper(Context context)
    {
        dbHelper = new WeChatDatabaseHelper(context,DB_NAME,null,DB_VERSION);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    /**
     * 获取全部的最新消息
     * @return
     */
    public List<LatestMessage> queryAllLatestMessage()
    {
        List<LatestMessage> messages = new ArrayList<LatestMessage>();
        Cursor cursor = sqLiteDatabase.query(WeChatDatabaseHelper.LATEST_TB_NAME,
                null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast() && (cursor.getString(1) != null))
        {
            LatestMessage message = new LatestMessage(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
            messages.add(message);
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return messages;
    }

    /**
     * 添加数据
     * @param message
     */
    public void insertLatestMessage(LatestMessage message)
    {
        ContentValues values = new ContentValues();
        values.put("userID",message.getUserId());
        values.put("fromID",message.getFromId());
        values.put("textContent",message.getTextContent());
        values.put("contentType",message.getContentType());
        values.put("updateTime",message.getUpdateTime());
        sqLiteDatabase.insert(WeChatDatabaseHelper.LATEST_TB_NAME,null,values);
        sqLiteDatabase.close();
    }

    /**
     * 删除数据
     * @param fromId
     */
    public void deleteMessage(String fromId)
    {
        sqLiteDatabase.delete(WeChatDatabaseHelper.LATEST_TB_NAME,"fromID=?",new String[]{fromId});
        sqLiteDatabase.close();
    }






}
