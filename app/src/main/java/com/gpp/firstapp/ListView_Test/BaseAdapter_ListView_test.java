package com.gpp.firstapp.ListView_Test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/31.
 * 在ListView的使用中，有时候还需要在里面加入按钮等控件，实现单独的操作。
 * 也就是说，这个ListView不再只是展示数据，也不仅仅是这一行要来处理用户的操作，而是里面的控件要获得用户的焦点。
 * 可以试试用SimpleAdapter添加一个按钮到ListView的条目中，会发现可以添加，但是却无法获得焦点，点击操作被ListView的Item所覆盖。
 * 这时候最方便的方法就是使用灵活的适配器BaseAdapter了
 * 使用BaseAdapter必须写一个类继承它，同时BaseAdapter是一个抽象类，继承它必须实现它的方法。BaseAdapter的灵活性就在于它要重写很多方法
 * ListView的原理:
 * 当系统开始绘制ListView的时候，首先调用getCount()方法。得到它的返回值，即ListView的长度。
 * 然后系统调用getView()方法，根据这个长度逐一绘制ListView的每一行。
 * 也就是说，如果让getCount()返回1，那么只显示一行。而getItem()和getItemId()则在需要处理和取得Adapter中的数据时调用
 */


public class BaseAdapter_ListView_test extends Activity implements Initialization {

    private ListView LV_base;
    private Button LV_bt;
    private TextView LV_tv1;
    private TextView LV_tv2;
    MyBaseAdapter myBaseAdapter;//自定义适配器


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_base);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        LV_base = (ListView) findViewById(R.id.LV_base);//适配器对应的listview
        LV_bt = (Button) findViewById(R.id.LV_bt);//listview的内容
        LV_tv1 = (TextView) findViewById(R.id.LV_tv1);//listview的内容
        LV_tv2 = (TextView) findViewById(R.id.LV_tv2);//listview的内容
    }

    @Override
    public void initListener() {
        myBaseAdapter = new MyBaseAdapter(this);
        LV_base.setAdapter(myBaseAdapter);//配置适配器
    }

}
