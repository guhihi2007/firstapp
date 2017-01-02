package com.gpp.firstapp.ProgressBar_Test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2017/1/1.
 */

public class ProgressDialog_test extends Activity implements Initialization, View.OnClickListener {

    private Button PB_Dialog_bt1;
    private Button PB_Dialog_bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressdialog_test);
        initView();
        initListener();
    }


    @Override
    public void initView() {
        PB_Dialog_bt1 = (Button) findViewById(R.id.PB_Dialog_bt1);
        PB_Dialog_bt2 = (Button) findViewById(R.id.PB_Dialog_bt2);
    }

    @Override
    public void initListener() {
        PB_Dialog_bt1.setOnClickListener(this);
        PB_Dialog_bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.PB_Dialog_bt1:
                getInstance3(this);
                break;
            case R.id.PB_Dialog_bt2:
                getInstance2(this);
                break;
        }
    }

    public static ProgressDialog getInstance1(Context context) {
        android.app.ProgressDialog dialog1 = new android.app.ProgressDialog(context);
        dialog1.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER);
        dialog1.setTitle("登录中");
        dialog1.setMessage("正在检测用户名、密码...");
        dialog1.setCancelable(true);
        dialog1.setIndeterminate(false);
        dialog1.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog1.show();
        return dialog1;
    }

    public static ProgressDialog getInstance2(Context context) {

        final android.app.ProgressDialog dialog2 = new android.app.ProgressDialog(context);
        dialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog2.setTitle("登录中");
        dialog2.setMessage("正在检测用户名、密码...");
        dialog2.setCancelable(true);
        dialog2.setIndeterminate(false);
        dialog2.setMax(100);
        dialog2.setProgress(0);
        dialog2.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog2.show();
        new Thread() {
            int temp = 0;

            @Override
            public void run() {
                while (temp <= 100) {
                    dialog2.setProgress(temp++);
                    try {
                        Thread.sleep(100);
                        if (temp == 100) {
                            dialog2.cancel();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return dialog2;
    }

    public static ProgressDialog getInstance3(Context context) {
        ProgressDialog dialog3 = new ProgressDialog(context).show(context, "提示", "正在登录中....", false, true);
        return dialog3;
    }
}
