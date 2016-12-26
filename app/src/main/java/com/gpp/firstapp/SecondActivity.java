package com.gpp.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/21.
 */

public class SecondActivity extends Activity {

    private TextView textView;
    private Button btn_search;
    private EditText et_search;
    private Handler handler;
    private Button btn_submit;
    private TextView tvThread;
    private Button btn_set;
    private Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        handler =new FirstHandler();//创建Handler对象
        ButtonListener1 btnListener = new ButtonListener1();  //创建Button监听器对象

        btn_search = (Button) findViewById(R.id.btn_search);//搜索按钮
        btn_set =(Button)findViewById(R.id.btn_set);//设置按钮
        et_search = (EditText) findViewById(R.id.et_search);//搜索栏
        btn_close =(Button)findViewById(R.id.btn_close);//搜索栏关闭按钮
        btn_submit=(Button)findViewById(R.id.btn_submit);//提交按钮
        tvThread=(TextView)findViewById(R.id.tvThread);//显示线程传入数据的TextView
        tvThread.setHint("正在连接服务器...");//设置TextView默认显示提示

        btn_search.setOnClickListener(btnListener);//绑定监听器
        btn_set.setOnClickListener(btnListener);
        btn_close.setOnClickListener(btnListener);
        btn_submit.setOnClickListener(btnListener);//绑定监听器

        Intent intent = getIntent();//拿到intent对象
        String s = intent.getStringExtra("com.example.administrator.myapplication.MainActivity.String");//得到传入的数据
        textView = (TextView) findViewById(R.id.secondTextView);//显示数据框
        textView.setText(s);//把数据设置到TexView

    }

    class ButtonListener1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId()==btn_submit.getId()) {
                Thread t1 = new handlerThread();
                t1.start();
            }else if (view.getId()==btn_search.getId()){
                btn_set.setVisibility(View.INVISIBLE);
                btn_search.setVisibility(View.INVISIBLE);
                et_search.setVisibility(View.VISIBLE);//当点击搜索按钮时，EdiTView可见
                btn_close.setVisibility(View.VISIBLE);
            }else if (view.getId()==btn_close.getId()){
                et_search.setVisibility(View.INVISIBLE);
                btn_close.setVisibility(View.INVISIBLE);
                btn_set.setVisibility(View.VISIBLE);
                btn_search.setVisibility(View.VISIBLE);
            }
        }
    }
    class FirstHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String s = (String)msg.obj;//从msg中解析数据
            tvThread.setText(s);//设置到TextView显示
        }
    }

    class handlerThread extends Thread {
        @Override
        public void run() {
            String s = "已连接";
            Message msg = handler.obtainMessage();//从Handler获得Message对象
            msg.obj=s;//把数据赋值给msg
            handler.sendMessage(msg);//发送数据
        }
    }

    class NetThread extends Thread{
        @Override
        public void run(){

        }
    }
}

