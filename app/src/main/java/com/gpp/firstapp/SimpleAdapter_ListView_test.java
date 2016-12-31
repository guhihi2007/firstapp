package com.gpp.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/31.
 *
 * 使用simpleAdapter的数据一般都是用HashMap构成的列表，列表的每一节对应ListView的每一行。
 * 通过SimpleAdapter的构造函数，将HashMap的每个键的数据映射到布局文件中对应控件上。这个布局文件一般根据自己的需要来自己定义。
 * 梳理一下使用SimpleAdapter的步骤。
 * （1）根据需要定义ListView每行所实现的布局。
 * （2）定义一个HashMap构成的列表，将数据以键值对的方式存放在里面。
 * （3）构造SimpleAdapter对象。
 * （4）将LsitView绑定到SimpleAdapter上。
 *
 */

public class SimpleAdapter_ListView_test extends Activity implements Initialization{

    private ListView LV_simple;
    private ImageView LV_image;
    private TextView TV_textview1;
    private TextView TV_textview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        initView();
        initListener();


    }

    @Override
    public void initView() {

        LV_simple=(ListView)findViewById(R.id.LV_listview);
        LV_image=(ImageView)findViewById(R.id.LV_imageView);
        TV_textview1=(TextView)findViewById(R.id.TV_textView1);
        TV_textview2=(TextView)findViewById(R.id.TV_textView2);



    }

    @Override
    public void initListener() {
        ArrayList<HashMap<String,Object>>  str = new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<15;i++){
            HashMap<String,Object> map= new HashMap<String, Object>();
            map.put("Image",R.drawable.background);
            map.put("TextTitle","第"+i+"行");
            map.put("Text",""+i+"");
            str.add(map);
        }
        SimpleAdapter simpleAdapter= new SimpleAdapter(this,str,R.layout.simpleadapter_listview_test,new String[]{"Image","TextTitle","Text"},new int[]{R.id.LV_imageView,R.id.TV_textView1,R.id.TV_textView2});
        LV_simple.setAdapter(simpleAdapter);
        LV_simple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleAdapter_ListView_test.this, "you chose：" + (position+1) + "line", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
