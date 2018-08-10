package com.wanda.advancedlight.presenter;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by PC on 2018/8/10.
 */

public class ExampleHelper {

    SharedPreferences sp;
    android.content.SharedPreferences.Editor editor;
    Context mContext;

    public ExampleHelper(Context context, String name){
        mContext = context;
        sp = mContext.getSharedPreferences(name,0);
        editor = sp.edit();
    }
    public void putValue(String key,String value){
        editor = sp.edit();
        editor.putString(key,value);
        editor.commit();

    }
    public String getValue(String key){
        return sp.getString(key,null);
    }
}
