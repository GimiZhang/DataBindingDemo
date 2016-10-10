package com.example.administrator.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用dataBinding 的RecycleView的Adapter
 * Created by Administrator on 2016/10/10.
 */

public class RecycleAdapter extends RecyclerView.Adapter<BindViewHolder> {

    private static final int ITEM_VIEW_SHOW_ON = 0;
    private static final int ITEM_VIEW_SHOW_OFF = 1;
    private OnItemClickListener mOnItemClickListenerm;
    private LayoutInflater mLayoutInflater;
    private List<UserBean> mUserList;

    public interface OnItemClickListener {
        void onUserClick(UserBean userBean);
    }


    public void setmOnItemClickListenerm(OnItemClickListener mOnItemClickListenerm) {
        this.mOnItemClickListenerm = mOnItemClickListenerm;
    }


    public RecycleAdapter(Context context) {
        super();
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUserList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        final UserBean userBean = mUserList.get(position);
        if (userBean.isFire) {
            return ITEM_VIEW_SHOW_ON;
        } else {
            return ITEM_VIEW_SHOW_OFF;
        }
    }

    @Override
    public BindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = null;
        if(viewType == ITEM_VIEW_SHOW_OFF){
            binding = DataBindingUtil.inflate(mLayoutInflater,R.layout.item_view_off,parent,false);
        }else{
            binding = DataBindingUtil.inflate(mLayoutInflater,R.layout.item_view_on,parent,false);
        }

        return new BindViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindViewHolder holder, int position) {
        final UserBean userBean = mUserList.get(position);
        holder.getBinding().setVariable(BR.user,userBean);
        holder.getBinding().executePendingBindings();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListenerm != null){
                    mOnItemClickListenerm.onUserClick(userBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList == null ? 0 : mUserList.size();
    }

    public void addAll(List<UserBean> userBeen){
        mUserList.addAll(userBeen);
    }

    public void add(UserBean userBean){
        mUserList.add(userBean);
        notifyItemInserted(mUserList.size());
    }

    public void remove(){

        if(mUserList.size() == 0){
            return;
        }

        mUserList.remove(0);
        notifyItemRemoved(0);
    }
}
