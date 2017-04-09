package com.lpy.cansinga.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.XLabels;
import com.lpy.cansinga.R;

import java.util.ArrayList;


/**
 * 开始计算
 */
public class CalculateFragment extends Fragment {
    private View view;

    private LineChart mLineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calculate, container, false);

        mLineChart = (LineChart) view.findViewById(R.id.lineChart);
        //设置描述文字
        mLineChart.setDescription("");
        //设置X轴位置在底部
        mLineChart.getXLabels().setPosition(XLabels.XLabelPosition.BOTTOM);
        //模拟一个x轴的数据  12/1 12/2 ... 12/7
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            xValues.add("" + (double)i/5);
        }

        //模拟一组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> yValue = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            yValue.add(new Entry(i, i));
//        }
        yValue.add(new Entry(-1, 0));
        yValue.add(new Entry(-2, 0));
        yValue.add(new Entry(0, 0));
        yValue.add(new Entry(1, 0));
        yValue.add(new Entry(-1, 0));
        yValue.add(new Entry(2, 0));
        //构建一个LineDataSet 代表一组Y轴数据 （比如不同的彩票： 七星彩  双色球）
        LineDataSet dataSet = new LineDataSet(yValue, "双色球");
        dataSet.setDrawCubic(true);
        dataSet.setColor(Color.BLUE);
        //模拟第二组组y轴数据(存放y轴数据的是一个Entry的ArrayList) 他是构建LineDataSet的参数之一
        ArrayList<Entry> yValue1 = new ArrayList<>();

        yValue1.add(new Entry(-2, 0));
        yValue1.add(new Entry(2, 1));
        yValue1.add(new Entry(1, 2));
        yValue1.add(new Entry(-1, 3));
        yValue1.add(new Entry(0, 4));
        yValue1.add(new Entry(1, 5));

        //构建一个LineDataSet 代表一组Y轴数据 （比如不同的彩票： 七星彩  双色球）
        LineDataSet dataSet1 = new LineDataSet(yValue1, "七星彩");
        dataSet1.setColor(Color.BLACK);
        dataSet1.setDrawCubic(true);
        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();

        //将数据加入dataSets
        dataSets.add(dataSet);
        dataSets.add(dataSet1);

        //构建一个LineData  将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);

        //将数据插入
        mLineChart.setData(lineData);

        return view;
    }

}
