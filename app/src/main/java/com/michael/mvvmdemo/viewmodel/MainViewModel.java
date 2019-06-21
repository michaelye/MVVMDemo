package com.michael.mvvmdemo.viewmodel;

import android.databinding.ObservableField;
import android.widget.SeekBar;

import com.michael.mvvmdemo.model.AirConditioner;

/**
 * ViewModel持有Model，直接与Model通信，但却没有直接与（Activity）直接通信
 *
 * View（Activity）中持有ViewModel，可以直接与ViewModel通信
 *
 * 通过DataBindingUtil工具，将View（布局文件）与ViewModel绑定起来
 * 以前布局文件能做的事情很少，但是现在，可以直接在布局文件中编写逻辑，调用ViewModel中的方法和字段
 *
 * */
public class MainViewModel implements ViewModel
{

    //Model
    private AirConditioner airConditionerModel;

    //指定可观察字段，这样在布局文件中就可以引用到该字段，并实时监听到该字段的变化
    public final ObservableField<String> temperatureAndWind = new ObservableField<>();


    public MainViewModel()
    {
        this.airConditionerModel = new AirConditioner();
    }

    @Override
    public void onCreate()
    {
        this.airConditionerModel = new AirConditioner();
        updateUI();
    }

    @Override
    public void onPause()
    {

    }

    @Override
    public void onResume()
    {

    }

    @Override
    public void onDestroy()
    {

    }

    /**
     * 温度发生变化时候调用
     * */
    public void onTemperatureChanged(SeekBar seekBar, int temperature, boolean fromUser)
    {
        airConditionerModel.changeTemperature(temperature);
        updateUI();
    }

    /**
     * 风力发生变化时候调用
     * */
    public void onWindLevelChanged()
    {
        airConditionerModel.changeWindLevel();
        updateUI();
    }

    /**
     * 更新UI时调用
     * */
    private void updateUI()
    {
        temperatureAndWind.set(airConditionerModel.getCurrentCondition());
    }
}
