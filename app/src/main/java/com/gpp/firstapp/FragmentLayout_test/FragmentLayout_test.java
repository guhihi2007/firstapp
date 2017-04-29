package com.gpp.firstapp.FragmentLayout_test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2017/1/1.
 */

public class FragmentLayout_test extends Activity implements Initialization, View.OnClickListener {


    //精选、排行、分类、管理栏按钮
    private LinearLayout FB_bt1;
    private LinearLayout FB_bt2;
    private LinearLayout FB_bt3;
    private LinearLayout FB_bt4;
    //精选、排行、分类、管理栏按钮图片
    private ImageView jingxuan_IV;
    private ImageView paihang_IV;
    private ImageView fenlei_IV;
    private ImageView guanli_IV;

    private FragmentManager fm;
    private FragmentTransaction ft;

    //FragmentLayout_test.activity内的LinearLayout_content
    //用于放Fragment
    private LinearLayout LinearLayout_content;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        initView();
        initListener();
        initFragment();

    }

    public void initFragment() {
        //初始化FragmentManager
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        //设置默认Fragment
        ft.replace(R.id.LinearLayout_content, new JX());
        jingxuan_IV.setImageResource(R.mipmap.credit_level_filling);
        resetBackground(1);
        ft.commit();

    }

    @Override
    public void initView() {
        //初始化按钮
        FB_bt1 = (LinearLayout) findViewById(R.id.id_jx_bt);
        FB_bt2 = (LinearLayout) findViewById(R.id.id_ph_bt);
        FB_bt3 = (LinearLayout) findViewById(R.id.id_fl_bt);
        FB_bt4 = (LinearLayout) findViewById(R.id.id_gl_bt);
        //初始化按钮图片
        jingxuan_IV = (ImageView) findViewById(R.id.jingxuan_bt);
        paihang_IV = (ImageView) findViewById(R.id.panghang_bt);
        fenlei_IV = (ImageView) findViewById(R.id.fenlei_bt);
        guanli_IV = (ImageView) findViewById(R.id.guanli_bt);

        LinearLayout_content = (LinearLayout) findViewById(R.id.LinearLayout_content);

    }

    @Override
    public void initListener() {
        //设置按钮监听
        FB_bt1.setOnClickListener(this);
        FB_bt2.setOnClickListener(this);
        FB_bt3.setOnClickListener(this);
        FB_bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {//点击处理
        ft = fm.beginTransaction();
        int id = v.getId();
        switch (id) {
            case R.id.id_jx_bt:
                ft.replace(R.id.LinearLayout_content, new JX());
                resetBackground(1);
                break;
            case R.id.id_ph_bt:
                ft.replace(R.id.LinearLayout_content, new PH());
                resetBackground(2);
                break;
            case R.id.id_fl_bt:
                ft.replace(R.id.LinearLayout_content, new FL());
                resetBackground(3);
                break;
            case R.id.id_gl_bt:
                ft.replace(R.id.LinearLayout_content, new GL());
                resetBackground(4);
                break;
        }
        ft.addToBackStack("BACK");
        ft.commit();

    }

    public void resetBackground(int bt_id) {//重置按钮图片
        switch (bt_id) {
            case 1:
                jingxuan_IV.setImageResource(R.mipmap.credit_level_filling);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 2:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level_filling);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 3:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level_filling);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 4:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level_filling);
                break;
        }
    }


}
