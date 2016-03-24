package com.vincentliong.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RongMa on 16/3/24.
 */
public class WeChatDatabaseHelper extends SQLiteOpenHelper
{
    public static final String USER_TB_NAME = "user";
    public static final String MESSAGE_TB_NAME = "message";
    public static final String LATEST_TB_NAME = "latest";

    private final String CREATE_USER_TABLE=
            "create table user(id varchar(255)," +
                    "username varchar(255)," +
                    "displayPath varchar(255),";
    private final String CREATE_MESSAGE_TABLE=
            "create table message(fromID varchar(255)," +
                    "toID varchar(255)," +
                    "contentType varchar(255)," +
                    "textContent varchar(255)," +
                    "imageContentPath varchar(255)," +
                    "timeContent varchar(255)," +
                    "soundContentPath varchar(255)," +
                    "createTime varchar(255)";
    private final String CREATE_LATEST_TABLE=
            "create table latest(userID varchar(255)," +
                    "fromID varchar(255)," +
                    "textContent varchar(255)," +
                    "contentType varchar(255)," +
                    "updateTime varchar(255)";

    public WeChatDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_MESSAGE_TABLE);
        db.execSQL(CREATE_LATEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
