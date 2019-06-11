package saulmm.coordinatorexamples.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 2:28 PM
 * @desc :
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "finch.db";
    private static final int DB_VERSION = 1;

    public static final String USER_TABLE_NAME = "user";
    public static final String JOB_TABLE_NAME = "job";

    public DBHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 创建两个表格:用户表 和职业表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + USER_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " name TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + JOB_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + " job TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
