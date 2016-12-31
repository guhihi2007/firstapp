package com.gpp.firstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_base);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        LV_base = (ListView) findViewById(R.id.LV_base);
        LV_bt = (Button) findViewById(R.id.LV_bt);
        LV_tv1 = (TextView) findViewById(R.id.LV_tv1);
        LV_tv2 = (TextView) findViewById(R.id.LV_tv2);
    }

    @Override
    public void initListener() {
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this);
        LV_base.setAdapter(myBaseAdapter);
    }


    @NonNull
    private ArrayList<HashMap<String, Object>> getData() {

        ArrayList<HashMap<String, Object>> str = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 15; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("TextTitle", "第" + i + "行");
            map.put("Text", "" + i + "");
            str.add(map);
        }
        str.get(1).toString();
        return str;
    }

    public final class ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public Button button;
    }

    private class MyBaseAdapter extends BaseAdapter {//新建一个类继承BaseAdapter，实现视图与数据的绑定

        private LayoutInflater layoutInflater;//得到一个LayoutInflater对象，用来导入布局

        public MyBaseAdapter(Context context) {
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() { //返回数据数组的长度
            return getData().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                convertView = layoutInflater.inflate(R.layout.baseadapter_listview_test,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.textView1=(TextView)convertView.findViewById(R.id.LV_tv1);
                viewHolder.textView2=(TextView)convertView.findViewById(R.id.LV_tv2);
                viewHolder.button=(Button)convertView.findViewById(R.id.LV_bt);
                convertView.setTag(viewHolder);
            }else {
                viewHolder =(ViewHolder) convertView.getTag();
            }
            viewHolder.textView1.setText(getData().get(position).get("TextTitle").toString());
            viewHolder.textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BaseAdapter_ListView_test.this, "you chose：" + (position+1) + "line", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.textView2.setText(getData().get(position).get("Text").toString());
            viewHolder.textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BaseAdapter_ListView_test.this, "you chose：" + (position+1) + "line", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BaseAdapter_ListView_test.this,"你点击了："+(position+1)+"",Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }

}
