package com.gpp.firstapp.Login_Test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gpp.firstapp.DataBase_Test.DBUtil;
import com.gpp.firstapp.R;

/**
 * Created by Administrator on 2016/12/26.
 */

public class RegisterActivity extends Activity implements View.OnClickListener, Initialization {


    private EditText new_username_ET;
    private EditText new_password_ET;
    private Button user_sub_btn;
    DBUtil dbUtil= new DBUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();
        initListener();
    }

    @Override
    public void initView() {

        new_username_ET = (EditText) findViewById(R.id.new_username_ET);
        new_password_ET = (EditText) findViewById(R.id.new_password_ET);
        user_sub_btn = (Button) findViewById(R.id.user_sub_btn);
    }

    @Override
    public void initListener() {
        user_sub_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name =new_username_ET.getText().toString();
        String password = new_password_ET.getText().toString();

        dbUtil.insertDB(RegisterActivity.this,name,password);
    }





}
