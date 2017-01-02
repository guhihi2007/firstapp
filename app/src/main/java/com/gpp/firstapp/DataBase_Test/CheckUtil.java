package com.gpp.firstapp.DataBase_Test;

import android.content.Context;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/12/29.
 */

public class CheckUtil {
    public static boolean CheckUserInfo(String name,String password){
        if (TextUtils.isEmpty(name)|| TextUtils.isEmpty(password)){
            return true;//用户名密码为空
        }
//        else if (!CheckPasswordLength(password)){
//            return true;
//        }
        return false;
    }

    private static boolean CheckPasswordLength(String password) {
        if (password.getBytes().length<6 || password.getBytes().length>10){
            return false;//长度要求不符
        }
        return true;
    }
}
