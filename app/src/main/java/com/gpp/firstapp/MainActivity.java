package com.gpp.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView textView1;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button logButton;
    private TextView registerTV;
    private TextView forgetText;

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
                Intent intent = new Intent();//创建intent对象
                intent.setClass(MainActivity.this, SecondActivity.class);//设置intent传入的activity类
                startActivity(intent);//启动intent
                break;
        }
    }



  /*  已优化为上面代码
  class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();//创建intent对象
            intent.setClass(MainActivity.this, SecondActivity.class);//设置intent传入的activity类
//            intent.putExtra("com.example.administrator.myapplication.MainActivity.String",usernameEditText.getText().toString());//放入数据
            startActivity(intent);//启动intent

        }
    }*/

}
