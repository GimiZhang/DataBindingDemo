package com.example.administrator.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.databindingdemo.databinding.ActivityRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private ActivityRecycleBinding recycleBinding;
    private RecycleAdapter mAdapter;

    public class ButtonClick {
        public void addClick(View view) {
            mAdapter.add(new UserBean("哈哈",25,true));
        }

        public void removeClick(View view) {
            mAdapter.remove();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recycleBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);
        recycleBinding.setButtonclick(new ButtonClick());
        mAdapter = new RecycleAdapter(this);
        recycleBinding.activityRecycle.setLayoutManager(new LinearLayoutManager(this));
        recycleBinding.activityRecycle.setAdapter(mAdapter);
        mAdapter.setmOnItemClickListenerm(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onUserClick(UserBean userBean) {
                Toast.makeText(RecycleActivity.this,new StringBuilder().append(userBean.age).toString(),Toast.LENGTH_SHORT).show();
            }
        });

        List<UserBean> mList = new ArrayList<>();
        mList.add(new UserBean("王五1",22,false));
        mList.add(new UserBean("王五2",21,false));
        mList.add(new UserBean("王五3",25,true));
        mList.add(new UserBean("王五4",23,false));
        mList.add(new UserBean("王五5",28,true));
        mAdapter.addAll(mList);

    }
}
