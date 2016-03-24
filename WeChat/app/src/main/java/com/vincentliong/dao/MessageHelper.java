package com.vincentliong.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vincentliong.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RongMa on 16/3/24.
 */
public class MessageHelper
{
    private static String DB_NAME = "message.db";
    private static int DB_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;
    private WeChatDatabaseHelper dbHelper;

    public MessageHelper(Context context)
    {
        dbHelper = new WeChatDatabaseHelper(context,DB_NAME,null,DB_VERSION);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    /**
     * 获取所有的数据
     * @return
     */
    public List<Message> queryAllMessage()
    {
        List<Message> messages = new ArrayList<Message>();
        Cursor cursor = sqLiteDatabase.query(WeChatDatabaseHelper.MESSAGE_TB_NAME,
                null,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast() && (cursor.getString(1) != null))
        {
            Message message = new Message(cursor.getString(0),cursor.getString(1), cursor.getString(2),cursor.getString(3),
                    cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
            messages.add(message);
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return messages;
    }

    public void insertMessage(Message msg)
    {
        ContentValues values = new ContentValues();
        values.put("fromID",msg.getFromId());
        values.put("toID",msg.getToId());
        values.put("contentType",msg.getContentType());
        values.put("textContent",msg.getTextContent());
        values.put("imageContentPath",msg.getImageContentPath());
        values.put("timeContent",msg.getTimeContent());
        values.put("soundContentPath",msg.getSoundContentPath());
        values.put("createTime",msg.getCreatedTime());
        sqLiteDatabase.insert(WeChatDatabaseHelper.LATEST_TB_NAME,null,values);
        sqLiteDatabase.close();
    }



}
