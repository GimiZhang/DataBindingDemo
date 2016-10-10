package com.example.administrator.databindingdemo;

import android.databinding.ObservableArrayMap;

/**
 * Created by Administrator on 2016/10/10.
 */

public class UserBean {

    public String name;
    public int age;
    public ObservableArrayMap<String,String> map = new ObservableArrayMap<>();

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
        map.put("hello","ni");
        map.put("hi","hao");
        map.put("ok","ya");
    }


}
