package com.vincentliong.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vincentliong.model.User;

/**
 * Created by RongMa on 16/3/24.
 */
public class UserHelper
{
    private static String DB_NAME = "user.db";
    private static int DB_VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;
    private WeChatDatabaseHelper dbHelper;

    public UserHelper(Context context)
    {
        dbHelper = new WeChatDatabaseHelper(context,DB_NAME,null,DB_VERSION);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void insertUser(User user)
    {
        ContentValues values = new ContentValues();
        values.put("id",user.getUserId());
        values.put("username",user.getUserName());
        values.put("displayPath",user.getDisplayPath());
        sqLiteDatabase.insert(WeChatDatabaseHelper.USER_TB_NAME,null,values);
    }
}
