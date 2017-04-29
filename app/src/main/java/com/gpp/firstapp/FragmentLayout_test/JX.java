package com.gpp.firstapp.FragmentLayout_test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.gpp.firstapp.ListView_Test.MyBaseAdapter;
import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2017/1/1.
 */

public class JX extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.jingxuan,null);
        ListView listView = (ListView)view.findViewById(R.id.LV_listview);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getActivity());
        listView.setAdapter(myBaseAdapter);
        return view;
    }

}
