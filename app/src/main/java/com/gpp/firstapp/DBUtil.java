package com.gpp.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/28.
 */

public class DBUtil {

    public static final String DB_NAME = "my_data.db";
    public static final String TABLE_NAME = "userinfo";
    public static final String TABLE_KEY = "name";
    public static final String TABLE_VALUES = "password";
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    private void initialDB(Context context) {
        databaseHelper = new DatabaseHelper(context, DB_NAME);
        db = databaseHelper.getReadableDatabase();
    }

    //  注册用户：用户名，密码写入数据库
    public void insertDB(Context context, String name, String password) {
        initialDB(context);
        if (CheckUtil.CheckUserInfo(name, password)) {
            Toast.makeText(context, " 用户名密码不能为空", Toast.LENGTH_SHORT).show();
        } else if (isRegister(db, name)) {//判断是否已经注册
            Toast.makeText(context, "用户名已注册", Toast.LENGTH_SHORT).show();
            return;
        } else {
            ContentValues cv = new ContentValues();
            cv.put(TABLE_KEY, name);
            cv.put(TABLE_VALUES, password);
            db.insert(TABLE_NAME, null, cv);
            db.close();
            Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }


    //验证用户名密码
    public boolean selectDB(Context context, String name, String password) {

        initialDB(context);
        if (CheckUtil.CheckUserInfo(name, password)) {
            Toast.makeText(context, " 用户名密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (isRegister(db, name)) {
            if (isPassword(db, name, password)) {
                return true;
            } else {
                Toast.makeText(context, "密码错误", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "用户名未注册", Toast.LENGTH_SHORT).show();
        }
        db.close();
        return false;
    }

    //验证用户名
    private boolean isRegister(SQLiteDatabase db, String name) {
        String sql_name = "SELECT  " + TABLE_KEY + "  FROM " + TABLE_NAME + "";

        Cursor cursor = db.rawQuery(sql_name, null);
       int a= cursor.getColumnIndex(TABLE_KEY);
        while (cursor.moveToNext()) {
            String dbName = cursor.getString(0);
            if (name.equals(dbName)) {
                return true;
            }
        }
        return false;//未注册
    }

    //验证密码
    private boolean isPassword(SQLiteDatabase db, String name, String password) {
        String sql_psw = "SELECT  *  FROM " + TABLE_NAME + " WHERE " + TABLE_KEY + " = ?";
        Cursor cursor = db.rawQuery(sql_psw, new String[]{name});
        while (cursor.moveToNext()) {
            String dbPassword = cursor.getString(cursor.getColumnIndex(TABLE_VALUES));
            if (password.equals(dbPassword)) {
                return true;
            }
        }
        return false;//密码错误
    }
}
