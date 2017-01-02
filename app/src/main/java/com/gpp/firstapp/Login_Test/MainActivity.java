package com.gpp.firstapp.Login_Test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gpp.firstapp.DataBase_Test.DBUtil;
import com.gpp.firstapp.ProgressBar_Test.ProgressDialog_test;
import com.gpp.firstapp.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button logButton;
    private TextView registerTV;
    private TextView forgetText;
    DBUtil dbUtil = new DBUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    public void initView() {
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        registerTV = (TextView) findViewById(R.id.registerTV);
        forgetText = (TextView) findViewById(R.id.forgetText);
        logButton = (Button) findViewById(R.id.logButton);
    }

    public void initListener() {
        registerTV.setOnClickListener(this);
        logButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.registerTV:
                Intent Register_intent = new Intent();
                Register_intent.setClass(MainActivity.this, RegisterActivity.class);
                startActivity(Register_intent);
                break;
            case R.id.logButton:
                String name = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                ProgressDialog_test.getInstance2(this);
                if (dbUtil.selectDB(MainActivity.this, name, password)) {
                    Intent intent = new Intent();//创建intent对象
                    intent.setClass(MainActivity.this, SecondActivity.class);//设置intent传入的activity类
                    intent.putExtra("user_name", name);
                    startActivity(intent);//启动intent
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }


}
