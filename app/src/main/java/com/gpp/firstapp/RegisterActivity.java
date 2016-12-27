package com.gpp.firstapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/26.
 */

public class RegisterActivity extends Activity implements View.OnClickListener, Initialization {

    public static final String DB_NAME = "my_data.db";
    public static final String TABLE_NAME="userinfo";
    public static final String TABLE_KEY="name";
    public static final String  TABLE_VALUES="password";

    private EditText new_username_ET;
    private EditText new_password_ET;
    private Button user_sub_btn;
    DatabaseHelper databaseHelper;
//    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();
        initListener();

        databaseHelper = new DatabaseHelper(RegisterActivity.this, DB_NAME);
//        databaseHelper.getWritableDatabase();
    }

    @Override
    public void initView() {

        new_username_ET = (EditText) findViewById(R.id.new_username_ET);
        new_password_ET = (EditText) findViewById(R.id.new_password_ET);
        user_sub_btn = (Button) findViewById(R.id.user_sub_btn);

    }

    @Override
    public void initListener() {
        user_sub_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        insertDB();
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    public void insertDB() {
        String s1 = new_username_ET.getText().toString();
        String s2 = new_password_ET.getText().toString();

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
//   方法一：
//        String sql = " INSERT INTO "+TABLE_NAME+" (NAME,PASSWORD) VALUES ( '"+s1+"', '"+s2+"')";
//        db.execSQL(sql);
//   方法二：
        String sql = " INSERT INTO "+TABLE_NAME+" (NAME,PASSWORD) VALUES (?,?)";
//        Object args [] = new Object[]{s1,s2};
//        Log.e("honaf",sql);
//        db.execSQL(sql,args);
//   方法三
        ContentValues cv =new ContentValues();
        long id =0;
        cv.put(TABLE_KEY,s1);
        cv.put(TABLE_VALUES,s2);
        id= db.insert(TABLE_NAME,null,cv);
    }
}
