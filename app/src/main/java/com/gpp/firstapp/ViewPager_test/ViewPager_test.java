package com.gpp.firstapp.ViewPager_test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/2.
 */

public class ViewPager_test extends Activity implements Initialization, View.OnClickListener {


    private LinearLayout id_jx_bt;
    private LinearLayout id_ph_bt;
    private LinearLayout id_fl_bt;
    private LinearLayout id_gl_bt;
    private ViewPager viewPager;
    private LinearLayout button_test;
    private ArrayList<View> list_vw= new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        initView();
        initListener();

    }


    @Override
    public void initView() {

        viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        button_test=(LinearLayout)findViewById(R.id.LinearLayout_view);
        id_jx_bt = (LinearLayout) findViewById(R.id.id_jx_bt);
        id_fl_bt = (LinearLayout) findViewById(R.id.id_fl_bt);
        id_ph_bt = (LinearLayout) findViewById(R.id.id_ph_bt);
        id_gl_bt = (LinearLayout) findViewById(R.id.id_gl_bt);

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View jingxuan = layoutInflater.inflate(R.layout.jingxuan,null);
        View paihang = layoutInflater.inflate(R.layout.paihang,null);
        View feilei = layoutInflater.inflate(R.layout.fenlei,null);
        View guanli = layoutInflater.inflate(R.layout.guanli,null);
        //把布局添加到list_vm
        list_vw.add(jingxuan);
        list_vw.add(paihang);
        list_vw.add(feilei);
        list_vw.add(guanli);

    }

    @Override
    public void initListener() {
        id_jx_bt.setOnClickListener(this);
        id_ph_bt.setOnClickListener(this);
        id_fl_bt.setOnClickListener(this);
        id_gl_bt.setOnClickListener(this);


        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list_vw.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                 container.addView(list_vw.get(position));
                return list_vw.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list_vw.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentPage = viewPager.getCurrentItem();
                switch (currentPage){
                    case 0:
                        //改变按钮颜色
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_jx_bt:
                viewPager.setCurrentItem(0);//点击按钮改变ViewPager
                break;
            case R.id.id_ph_bt:
                viewPager.setCurrentItem(1);
                break;
            case R.id.id_fl_bt:
                viewPager.setCurrentItem(2);

                break;
            case R.id.id_gl_bt:
                viewPager.setCurrentItem(3);

                break;
        }
    }


}
