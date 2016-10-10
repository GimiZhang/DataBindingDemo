package com.example.administrator.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    final UserBean userBean = new UserBean("张三",27,false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(userBean);
        binding.viewstub.getViewStub().inflate();
        binding.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean.name="李四";
                binding.tvTitle.setText(userBean.name);
            }
        });

        binding.setPresenter(new Presenter());
    }


    public class Presenter{

        public void onTextChanged(CharSequence s, int start, int before, int count){
            userBean.name = s.toString();
            binding.setUser(userBean);
        }

        public void onClick(View view){
            Toast.makeText(MainActivity.this,new StringBuilder().append(userBean.age).toString(),Toast.LENGTH_SHORT).show();
        }

        /**
         * 将xml中的对象回传到java代码中
         * @param userBean
         */
        public void onClickListenerBinding(UserBean userBean){
            Toast.makeText(MainActivity.this,userBean.name,Toast.LENGTH_SHORT).show();
        }
    }
}
