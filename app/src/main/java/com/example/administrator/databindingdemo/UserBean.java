package com.example.administrator.databindingdemo;

import android.databinding.ObservableArrayMap;

/**
 * Created by Administrator on 2016/10/10.
 */

public class UserBean{

    public String name;
    public int age;
    public boolean isFire;
    public ObservableArrayMap<String,String> map = new ObservableArrayMap<>();

    public UserBean(String name, int age, boolean flag) {
        this.name = name;
        this.age = age;
        this.isFire = flag;
        map.put("hello","ni");
        map.put("hi","hao");
        map.put("ok","ya");
    }


}
