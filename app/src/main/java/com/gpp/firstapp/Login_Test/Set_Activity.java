package com.gpp.firstapp.Login_Test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gpp.firstapp.Login_Test.Initialization;
import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Set_Activity extends Activity implements Initialization,View.OnClickListener {
    @Override
    public void onClick(View v) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_activity);
    }
}
