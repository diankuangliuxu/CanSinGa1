package com.lpy.cansinga.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lpy.cansinga.R;
import com.lpy.cansinga.adapter.RecycleViewLeftAdapter;
import com.lpy.cansinga.adapter.RecycleViewRightAdapter;

import java.util.ArrayList;

/**
 * ·列车编组
 * ·碰撞场景
 */
public class SceneDesignFragment extends Fragment {
    private View view;

    private Spinner car_number_spinner;//列车编组
    private ArrayAdapter arrayAdapter;
    private ArrayList<String> spinnerList = new ArrayList<>();
    private EditText speed_edit;//碰撞速度
    private EditText braking_coefficient_edit;//制动系数
    private EditText crash_time_edit;//碰撞时间

    private TextView crash_speed_text;//碰撞速度
    private TextView braking_coefficient_text;//制动系数

    private RecyclerView first_car_recycleview;
    private RecyclerView second_car_recycleview;

    private int carNums = 1;
    private ArrayList<String> arrayList = new ArrayList<>();

    private RecycleViewRightAdapter rightAdapter;
    private RecycleViewLeftAdapter leftAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scene_design, container, false);
        //初始化界面
        initView();
        //设置功能
        setFunc();
        return view;
    }

    private void setFunc() {
        for (int a = 0; a < 8; a++) {
            spinnerList.add((a + 1) + "");
        }
        arrayAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item_layout, spinnerList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item_layout);
        car_number_spinner.setAdapter(arrayAdapter);
        carNums = carNums*2;
        for (int i = 0; i < carNums; i++) {
            arrayList.add("车");
        }
        car_number_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                carNums = position + 1;
                arrayList.clear();
                for (int i = 0; i < carNums*2; i++) {
                    arrayList.add("车" + (i + 1));
                }
                rightAdapter.notifyDataSetChanged();
                leftAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        speed_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crash_speed_text.setText("碰撞速度" + speed_edit.getText().toString() + "km/h");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        braking_coefficient_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                braking_coefficient_text.setText("静止,制动系数=" + braking_coefficient_edit.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initView() {
        car_number_spinner = (Spinner) view.findViewById(R.id.car_number_spinner);
        speed_edit = (EditText) view.findViewById(R.id.speed_edit);
        braking_coefficient_edit = (EditText) view.findViewById(R.id.braking_coefficient_edit);
        crash_time_edit = (EditText) view.findViewById(R.id.crash_time_edit);
        crash_speed_text = (TextView) view.findViewById(R.id.crash_speed_text);
        braking_coefficient_text = (TextView) view.findViewById(R.id.braking_coefficient_text);

        crash_speed_text.setText("碰撞速度" + speed_edit.getText().toString() + "km/h");
        braking_coefficient_text.setText("静止,制动系数=" + braking_coefficient_edit.getText().toString());

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
    }

}
