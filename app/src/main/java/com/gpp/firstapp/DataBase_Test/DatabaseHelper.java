package com.gpp.firstapp.DataBase_Test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.BaseColumns._ID;

/**
 * Created by Administrator on 2016/12/26.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "userinfo";
    public static final int VERSION = 1;//固定版本号


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public DatabaseHelper(Context context, String name) {
        this(context, name, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME + " ( name PRIMARY KEY NOT NULL,password TEXT NOT NULL)";
        db.execSQL(sql);
        Log.d("gpp", "数据库创建完成");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
