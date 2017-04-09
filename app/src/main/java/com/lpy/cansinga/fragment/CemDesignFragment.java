package com.lpy.cansinga.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.lpy.cansinga.R;
import com.lpy.cansinga.adapter.RecycleViewLeftAdapter;
import com.lpy.cansinga.adapter.RecycleViewRightAdapter;

import java.util.ArrayList;

/**
 * ·车辆分布
 * ·CEM设计
 */
public class CemDesignFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView crash_speed_text;//碰撞速度
    private TextView braking_coefficient_text;//制动系数

    private RecyclerView first_car_recycleview;
    private RecyclerView second_car_recycleview;

    private int carNums = 6;
    private ArrayList<String> arrayList = new ArrayList<>();

    private RecycleViewRightAdapter rightAdapter;
    private RecycleViewLeftAdapter leftAdapter;

    /**
     * 车吸能方案选择相关
     */
    private LinearLayout car_design_linear;//显示隐藏
    private TextView car_number_text;//哪辆车
    private TextView commit_text;//确定
    private Spinner spinner1, spinner2, spinner3;
    private ArrayAdapter sp1Adapter;
    private ArrayAdapter sp2Adapter;
    private ArrayAdapter sp3Adapter;

    private ArrayList<String> xnPlanLeftList = new ArrayList<>();//吸能方案左侧选择
    private ArrayList<String> carWeightList = new ArrayList<>();//车体重量选择
    private ArrayList<String> xnPlanRightList = new ArrayList<>();//吸能方案右侧选择


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cem_design, container, false);

        initView();
        for (int i = 0; i < carNums; i++) {
            arrayList.add("车" + (i + 1));
        }
        return view;
    }

    private void initView() {
        crash_speed_text = (TextView) view.findViewById(R.id.crash_speed_text);
        braking_coefficient_text = (TextView) view.findViewById(R.id.braking_coefficient_text);
        crash_speed_text.setText("碰撞速度 100km/h");
        braking_coefficient_text.setText("静止,制动系数=0");
        first_car_recycleview = (RecyclerView) view.findViewById(R.id.first_car_recycleview);
        second_car_recycleview = (RecyclerView) view.findViewById(R.id.second_car_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        first_car_recycleview.setLayoutManager(layoutManager);
        rightAdapter = new RecycleViewRightAdapter(getActivity(), arrayList);
        first_car_recycleview.setAdapter(rightAdapter);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        second_car_recycleview.setLayoutManager(layoutManager2);
        leftAdapter = new RecycleViewLeftAdapter(getActivity(), arrayList);
        second_car_recycleview.setAdapter(leftAdapter);
        /********************************************************************/
        car_design_linear = (LinearLayout) view.findViewById(R.id.car_design_linear);
//        car_design_linear.setVisibility(View.GONE);
        car_number_text = (TextView) view.findViewById(R.id.car_number_text);
        commit_text = (TextView) view.findViewById(R.id.commit_text);
        commit_text.setOnClickListener(this);
        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        xnPlanLeftList.clear();
        xnPlanRightList.clear();
        carWeightList.clear();
        for (int a = 0; a < 8; a++) {
            xnPlanLeftList.add((a + 1) + "");
            xnPlanRightList.add((a + 1) + "");
            carWeightList.add((40+a)+"t");
        }
        sp1Adapter = new ArrayAdapter(getActivity(), R.layout.spinner_select_layout, xnPlanLeftList);
        sp1Adapter.setDropDownViewResource(R.layout.spinner_item_layout);
        spinner1.setAdapter(sp1Adapter);
        sp2Adapter = new ArrayAdapter(getActivity(), R.layout.spinner_select_layout, carWeightList);
        sp2Adapter.setDropDownViewResource(R.layout.spinner_item_layout);
        spinner2.setAdapter(sp2Adapter);
        sp3Adapter = new ArrayAdapter(getActivity(), R.layout.spinner_select_layout, xnPlanRightList);
        sp3Adapter.setDropDownViewResource(R.layout.spinner_item_layout);
        spinner3.setAdapter(sp3Adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
