package com.gpp.firstapp.ListView_Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2017/1/1.
 */

public class MyBaseAdapter extends BaseAdapter {
    ArrayList arrayList;
    ViewHolder viewHolder;
    Context context;
    private LayoutInflater layoutInflater;//得到一个LayoutInflater对象，用来导入布局

    public MyBaseAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getCount() { //返回数据数组的长度
        return arrayList.getData().size();
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
        viewHolder.textView1.setText(arrayList.getData().get(position).get("TextTitle").toString());
        viewHolder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you chose：" + (position+1) + "line", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.textView2.setText(arrayList.getData().get(position).get("Text").toString());
        viewHolder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you chose：" + (position+1) + "line", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"你点击了："+(position+1)+"",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
