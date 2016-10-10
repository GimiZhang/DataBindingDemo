package com.example.administrator.databindingdemo;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2016/10/10.
 */

public class BindViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    public BindViewHolder(T bingding) {
        super(bingding.getRoot());
        mBinding = bingding;
    }

    public T getBinding(){
        return mBinding;
    }
}
