package com.gpp.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gpp.firstapp.FragmentLayout_test.FragmentLayout_test;
import com.gpp.firstapp.ListView_Test.ArrayAdapter_ListView_test;
import com.gpp.firstapp.ListView_Test.BaseAdapter_ListView_test;
import com.gpp.firstapp.ListView_Test.SimpleAdapter_ListView_test;
import com.gpp.firstapp.Login_Test.MainActivity;
import com.gpp.firstapp.ProgressBar_Test.ProgressBar_test;
import com.gpp.firstapp.ProgressBar_Test.ProgressDialog_test;
import com.gpp.firstapp.ViewPager_test.ViewPager_test;

/**
 * Created by Administrator on 2017/4/29.
 */

public class TestActivtiy extends Activity implements View.OnClickListener {
    private Button b1, b2, b3, b4, b5, b6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        b1 = (Button) findViewById(R.id.btn_1);
        b2 = (Button) findViewById(R.id.btn_2);
        b3 = (Button) findViewById(R.id.btn_3);
        b4 = (Button) findViewById(R.id.btn_4);
        b5 = (Button) findViewById(R.id.btn_5);
        b6 = (Button) findViewById(R.id.btn_6);
//        b7 = (Button) findViewById(R.id.btn_7);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
//        b7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent().setClass(this,ProgressDialog_test.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent().setClass(this,ProgressBar_test.class));

                break;
            case R.id.btn_3:
                startActivity(new Intent().setClass(this,MainActivity.class));

                break;
            case R.id.btn_4:
                startActivity(new Intent().setClass(this,SimpleAdapter_ListView_test.class));

                break;
            case R.id.btn_5:
                startActivity(new Intent().setClass(this,BaseAdapter_ListView_test.class));

                break;
            case R.id.btn_6:
                startActivity(new Intent().setClass(this,ArrayAdapter_ListView_test.class));

                break;
//            case R.id.btn_7:
//                startActivity(new Intent().setClass(this,ViewPager_test.class));
//                break;
        }
    }
}
