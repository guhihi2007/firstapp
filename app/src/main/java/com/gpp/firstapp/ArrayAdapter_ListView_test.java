package com.gpp.firstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/30.
 * （1）定义一个数组来存放ListView中item的内容。
 * （2）通过实现ArrayAdapter的构造函数来创建一个ArrayAdapter的对象。
 * ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strs)
 * 第一个参数为上下文，第二个参数为一个包含TextView，用来填充ListView的每一行的布局资源ID。第三个参数为ListView的内容。
 * 其中第二个参数可以自定义一个layout，但是这个layout必须要有TextView控件
 * 常用的还有如下几种，可实现带RadioButton和CheckBox的ListView
 * a、通过指定android.R.layout.simple_list_item_checked这个资源，实现带选择框的ListView。
 * 需要用setChoiceMode()方法设定选择为多选还是单选，否则将不能实现选择效果
 * b、通过指定android.R.layout.simple_list_item_multiple_choice这个资源实现带CheckBox的ListView。
 * 同样的，需要用setChoiceMode()方法来设置单选或者多选
 * c、通过指定android.R.layout.simple_list_item_single_choice这个资源实现带RadioButton的ListView。
 * 这里要注意的是，这里并不是指定了单选。是多选还是单选要通过setChoiceMode()方法来指定
 * （3）通过ListView的setAdapter()方法绑定ArrayAdapter。
 *
 */

public class ArrayAdapter_ListView_test extends Activity implements Initialization, View.OnClickListener {


    public static final String[] first = new String[]{"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"};
    public static final String[] second = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private ListView firstLV;
    private ListView secondLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayadapter_listview_test);
        initView();
        initListener();
    }

    @Override
    public void initView() {
        firstLV = (ListView) findViewById(R.id.firstLV);
        firstLV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, first));
        firstLV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        secondLV = (ListView) findViewById(R.id.secondLV);
        secondLV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, second));
        secondLV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void initListener() {
        //通过如下的代码就可以为ListView绑定一个点击监听器
        firstLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Context context = ArrayAdapter_ListView_test.this;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(context, "you chose：" + (parent) + "line", Toast.LENGTH_SHORT).show();
            }
        });
        secondLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Context context = ArrayAdapter_ListView_test.this;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "你点击了：" + (parent) + "行", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


}