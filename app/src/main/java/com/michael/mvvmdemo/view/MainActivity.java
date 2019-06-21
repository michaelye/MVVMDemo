package com.michael.mvvmdemo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.michael.mvvmdemo.R;
import com.michael.mvvmdemo.databinding.ActivityMainBinding;
import com.michael.mvvmdemo.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity
{

    private MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //布局文件名是activity_main.xml，所以生成的对应的Binding类为ActivityMainBinding
        //再通过setViewModel()方法，将View（ActivityMainBinding/activity_main.xml文件）和ViewModel绑定起来
        //绑定后，便可以在布局文件中直接调用ViewModel中的方法和字段
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(mainViewModel);

        mainViewModel.onCreate();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mainViewModel.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mainViewModel.onResume();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mainViewModel.onDestroy();
    }
}
