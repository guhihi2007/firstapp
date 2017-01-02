package com.gpp.firstapp.ProgressBar_Test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

import java.util.Random;

/**
 * Created by Administrator on 2017/1/1.
 */

public class ProgressBar_test extends Activity implements Initialization, View.OnClickListener {

    private  ProgressBar progressBar;
    private  ProgressBar progressBar1;
    private TextView PB_tvProgress;
    private Button button;
    private int temp ;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_test);
        initView();
        initListener();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x11) {
                    progressBar.setProgress(temp);
                    PB_tvProgress.setText(temp+"%");
                }
            }
        };
    }


    @Override
    public void initView() {
        progressBar = (ProgressBar) findViewById(R.id.Progressbar_horizontal);
        button = (Button) findViewById(R.id.PB_btn);
        PB_tvProgress=(TextView)findViewById(R.id.PB_tvProgress);
        progressBar1=(ProgressBar)findViewById(R.id.Progressbar_circle);
    }

    @Override
    public void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.PB_btn:
                Thread thread =new Thread(){
                    @Override
                    public void run() {
                        while(temp<100){
                            temp+=1;
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Message msg = new Message();
                            msg.what = 0x11;
                            handler.sendMessage(msg);
                         }
                    }
                };
                thread.start();
        }
    }

}
