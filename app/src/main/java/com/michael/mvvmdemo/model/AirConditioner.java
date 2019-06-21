package com.michael.mvvmdemo.model;

public class AirConditioner
{
    //空调温度
    private int temperature;
    //风力级别
    private String windLevel;

    public static final String WIND_STRONG = "较强";
    public static final String WIND_MIDDLE = "中等";
    public static final String WIND_GENTLE = "舒适";

    public AirConditioner()
    {
        reset();
    }

    public void changeTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    /**
     * 重置
     * */
    public void reset()
    {
        temperature = 20;
        windLevel = WIND_MIDDLE;
    }

    /**
     * 当前温度指标
     * */
    public String getCurrentCondition()
    {
        return "温度:" + temperature + "度 | 风力：" + windLevel;
    }

    /**
     * 修改风力
     * */
    public void changeWindLevel()
    {
        if(windLevel.equals(WIND_STRONG))
        {
            windLevel = WIND_MIDDLE;
        }
        else if(windLevel.equals(WIND_MIDDLE))
        {
            windLevel = WIND_GENTLE;
        }
        else if(windLevel.equals(WIND_GENTLE))
        {
            windLevel = WIND_STRONG;
        }
    }
}
