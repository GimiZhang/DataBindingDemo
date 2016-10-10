package com.example.administrator.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.databindingdemo.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    private ActivityFirstBinding firstBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstBinding = DataBindingUtil.setContentView(this,R.layout.activity_first);
        firstBinding.setButtonClick(new ButtonClick());
    }

    public class ButtonClick{
        public void onClickBase(View view){
            startActivity(new Intent(FirstActivity.this,MainActivity.class));
        }

        public void onClickRecycle(View view){
            startActivity(new Intent(FirstActivity.this,RecycleActivity.class));
        }
    }
}
