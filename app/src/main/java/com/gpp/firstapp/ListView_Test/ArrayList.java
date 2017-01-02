package com.gpp.firstapp.ListView_Test;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/1.
 */

public class ArrayList {
    public static java.util.ArrayList<HashMap<String, Object>> getData() {

        java.util.ArrayList<HashMap<String, Object>> str = new java.util.ArrayList<HashMap<String, Object>>();
        for (int i = 1; i < 15; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("TextTitle", "第" + i + "行");
            map.put("Text", "" + i + "");
            str.add(map);
        }
        str.get(1).toString();
        return str;
    }
}
