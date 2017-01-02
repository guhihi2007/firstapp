package com.gpp.firstapp.FragmentLayout_test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gpp.firstapp.R;


/**
 * Created by Administrator on 2017/1/1.
 */

public class FL extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fenlei,null);
    }
}
