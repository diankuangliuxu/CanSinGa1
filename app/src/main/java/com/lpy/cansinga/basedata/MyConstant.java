package com.lpy.cansinga.basedata;

import java.util.ArrayList;

/**
 * Created by liupengyuan on 2017/4/7.
 */

public class MyConstant {
    /**
     * 汽车数量
     */
    public static final int CAR_NUM = 1;

    /**
     * 碰撞速度
     */
    public static final float CAR_SPEED = 10f;

    /**
     * 制动系数
     */
    public static final float ZHI_DONG_XI_SHU = 0.1f;

    /**
     * 碰撞时间
     */
    public static final int CRASH_TIME = 1;

    /**
     * 车体重量集合
     */
    public static final ArrayList<Float> carWeightList = new ArrayList<>();

    /**
     * 吸能方案集合
     */
    public static final ArrayList<XnPlanItem> xnPlanList = new ArrayList<>();


}
