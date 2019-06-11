package saulmm.coordinatorexamples.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/11 2:34 PM
 * @desc :
 */
public class MyProvider extends ContentProvider{


    private Context mContext;
    private DBHelper mDBHelper;
    private SQLiteDatabase mSQLiteDatabase;

    public static final String AUTOHORITY = "saulmm.coordinatorexamples.db.myprovider";

    public static final int USER_CODE = 1;
    public static final int JOB_CODE = 2;

    private static UriMatcher  mMatcher = null;

    static {
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        mMatcher.addURI(AUTOHORITY,"user",USER_CODE);
        mMatcher.addURI(AUTOHORITY,"job",JOB_CODE);


    }


    @Override
    public boolean onCreate() {
        mContext = getContext();

        mDBHelper = new DBHelper(getContext());
        mSQLiteDatabase = mDBHelper.getWritableDatabase();

        // 初始化两个表的数据(先清空两个表,再各加入一个记录)
        mSQLiteDatabase.execSQL("delete from user");
        mSQLiteDatabase.execSQL("insert into user values(1,'Carson');");
        mSQLiteDatabase.execSQL("insert into user values(2,'Kobe');");

        mSQLiteDatabase.execSQL("delete from job");
        mSQLiteDatabase.execSQL("insert into job values(1,'Android');");
        mSQLiteDatabase.execSQL("insert into job values(2,'iOS');");

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        String tableName = getTableName(uri);
        return mSQLiteDatabase.query(tableName,strings,s,strings1,null,null,s1,null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
       String tableName = getTableName(uri);
       mSQLiteDatabase.insert(tableName,null,contentValues);
       mContext.getContentResolver().notifyChange(uri,null);
       return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    private String getTableName(Uri uri) {
        String tableName = null;

        switch (mMatcher.match(uri)) {
            case USER_CODE:
                tableName = DBHelper.USER_TABLE_NAME;
                break;
            case JOB_CODE:
                tableName = DBHelper.JOB_TABLE_NAME;
                break;
        }

        return tableName;
    }


}
