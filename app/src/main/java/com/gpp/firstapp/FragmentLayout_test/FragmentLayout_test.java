package com.gpp.firstapp.FragmentLayout_test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gpp.firstapp.ListView_Test.MyBaseAdapter;
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
    private LinearLayout LinearLayout_content;
    private JX jx;
    //ListView
//    private ListView activity_listview;
    //ListView里面的内容
//    private Button LV_bt;
//    private TextView LV_tv1;
//    private TextView LV_tv2;


    //引入适配器
//    private MyBaseAdapter myBaseAdapter;

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
        jx=new JX();
        ft.replace(R.id.LinearLayout_content,jx);
        ft.commit();
        jingxuan_IV.setImageResource(R.mipmap.credit_level_filling);
//        resetBackground(1);
    }

    @Override
    public void initView() {
        //初始化按钮
        FB_bt1 = (LinearLayout) findViewById(R.id.FB_bt1);
        FB_bt2 = (LinearLayout) findViewById(R.id.FB_bt2);
        FB_bt3 = (LinearLayout) findViewById(R.id.FB_bt3);
        FB_bt4 = (LinearLayout) findViewById(R.id.FB_bt4);
        //初始化按钮图片
        jingxuan_IV = (ImageView) findViewById(R.id.jingxuan_bt);
        paihang_IV = (ImageView) findViewById(R.id.panghang_bt);
        fenlei_IV = (ImageView) findViewById(R.id.fenlei_bt);
        guanli_IV = (ImageView) findViewById(R.id.guanli_bt);

        LinearLayout_content = (LinearLayout) findViewById(R.id.LinearLayout_content);
        //初始化Listview
//        activity_listview=(ListView)findViewById(R.id.activity_listview);

    }

    @Override
    public void initListener() {
        //设置按钮监听
        FB_bt1.setOnClickListener(this);
        FB_bt2.setOnClickListener(this);
        FB_bt3.setOnClickListener(this);
        FB_bt4.setOnClickListener(this);
        //Listiew绑定适配器
//        myBaseAdapter = new MyBaseAdapter(this);
//        activity_listview.setAdapter(myBaseAdapter);
    }

    @Override
    public void onClick(View v) {//点击处理
        ft = fm.beginTransaction();
        int id = v.getId();
        switch (id) {
            case R.id.FB_bt1:
                ft.replace(R.id.LinearLayout_content, new JX());
                resetBackground(1);
                break;
            case R.id.FB_bt2:
                ft.replace(R.id.LinearLayout_content, new PH());
                resetBackground(2);
                break;
            case R.id.FB_bt3:
                ft.replace(R.id.LinearLayout_content, new FL());
                resetBackground(3);
                break;
            case R.id.FB_bt4:
                ft.replace(R.id.LinearLayout_content, new GL());
                resetBackground(4);
                break;
        }
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
