package com.lpy.cansinga.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lpy.cansinga.R;
import com.lpy.cansinga.adapter.CarTypeAdapter;
import com.lpy.cansinga.adapter.XNTypeAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * ·车辆类型
 * ·吸能方案
 */
public class CarTypeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout main_linear;
    private TextView add_car_type_text;
    private TextView add_xineng_type_text;
    private ListView car_type_listview;
    private ListView xineng_type_listview;
    /**
     * 吸能方案选择布局
     */
    private LinearLayout xnplan_linear;//界面显示隐藏控制
    private LinearLayout linear_flag;//界面显示隐藏控制
    private TextView xnplan_title_text;//吸能方案标题
    private Button xnplan_commit_btn;//吸能方案确定
    private Spinner xnplan_left_spinner;//左边选择
    private Spinner xnplan_right_spinner;//右边选择
    private EditText fengzhili_edit;//峰力值
    private EditText xingcheng_edit;//行程
    private EditText ykg_ykl_edit;//压溃管-压溃力
    private EditText fpq_ykl_edit;//防爬器-压溃力
    private EditText zxnq_ykl_edit;//主吸能器-压溃力
    private EditText ykg_xc_edit;//压溃管-行程
    private EditText fpq_xc_edit;//防爬器-行程
    private EditText zxnq_xc_edit;//主吸能器-行程

    private ArrayList<String> spinner1List = new ArrayList<>();
    private ArrayAdapter adapter1;
    private ArrayList<String> spinner2List = new ArrayList<>();
    private ArrayAdapter adapter2;

    /**
     * 车辆种类适配
     */
    private CarTypeAdapter carTypeAdapter;
    private ArrayList<String> carNameList = new ArrayList<>();
    private ArrayList<String> carWeightList = new ArrayList<>();
    /**
     * 吸能方案适配
     */
    private XNTypeAdapter xnTypeAdapter;
    private ArrayList<String> xnPlanList = new ArrayList<>();
    private ArrayList<String> xncurveList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_type, container, false);
        initView();
        initCarTypeData();
        initXnPlanData();
        xineng_type_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                main_linear.setVisibility(View.GONE);
                xnplan_linear.setVisibility(View.VISIBLE);
                Log.e("aaaaa","??????");
            }
        });
        xnplan_left_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        xnplan_right_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    linear_flag.setVisibility(View.INVISIBLE);
                    fpq_ykl_edit.setVisibility(View.INVISIBLE);
                    fpq_xc_edit.setVisibility(View.INVISIBLE);
                    zxnq_ykl_edit.setVisibility(View.INVISIBLE);
                    zxnq_xc_edit.setVisibility(View.INVISIBLE);
                }else{
                    linear_flag.setVisibility(View.VISIBLE);
                    fpq_ykl_edit.setVisibility(View.VISIBLE);
                    fpq_xc_edit.setVisibility(View.VISIBLE);
                    zxnq_ykl_edit.setVisibility(View.VISIBLE);
                    zxnq_xc_edit.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private void initXnPlanData() {
        xnTypeAdapter = new XNTypeAdapter(getActivity(), xnPlanList, xncurveList);
        xineng_type_listview.setAdapter(xnTypeAdapter);
        if (xnPlanList.size() == 0) {
            xnPlanList.add(" ");
            xncurveList.add(" ");
        }
        add_xineng_type_text.setOnClickListener(this);
    }

    private void initCarTypeData() {
        carTypeAdapter = new CarTypeAdapter(getActivity(), carNameList, carWeightList);
        car_type_listview.setAdapter(carTypeAdapter);
        if (carNameList.size() == 0) {
            carNameList.add(" ");
            carWeightList.add(" ");
        }
        add_car_type_text.setOnClickListener(this);
    }

    private void initView() {
        main_linear = (LinearLayout) view.findViewById(R.id.main_linear);
        main_linear.setVisibility(View.VISIBLE);
        add_car_type_text = (TextView) view.findViewById(R.id.add_car_type_text);
        add_xineng_type_text = (TextView) view.findViewById(R.id.add_xineng_type_text);
        car_type_listview = (ListView) view.findViewById(R.id.car_type_listview);
        xineng_type_listview = (ListView) view.findViewById(R.id.xineng_type_listview);

        xnplan_linear = (LinearLayout) view.findViewById(R.id.xnplan_linear);
        linear_flag = (LinearLayout) view.findViewById(R.id.linear_flag);
        xnplan_linear.setVisibility(View.GONE);
        linear_flag.setVisibility(View.VISIBLE);
        xnplan_title_text = (TextView) view.findViewById(R.id.xnplan_title_text);
        xnplan_commit_btn = (Button) view.findViewById(R.id.xnplan_commit_btn);
        xnplan_commit_btn.setOnClickListener(this);
        fengzhili_edit = (EditText) view.findViewById(R.id.fengzhili_edit);
        xingcheng_edit = (EditText) view.findViewById(R.id.xingcheng_edit);
        ykg_ykl_edit = (EditText) view.findViewById(R.id.ykg_ykl_edit);
        fpq_ykl_edit = (EditText) view.findViewById(R.id.fpq_ykl_edit);
        zxnq_ykl_edit = (EditText) view.findViewById(R.id.zxnq_ykl_edit);
        ykg_xc_edit = (EditText) view.findViewById(R.id.ykg_xc_edit);
        fpq_xc_edit = (EditText) view.findViewById(R.id.fpq_xc_edit);
        zxnq_xc_edit = (EditText) view.findViewById(R.id.zxnq_xc_edit);

        xnplan_left_spinner = (Spinner) view.findViewById(R.id.xnplan_left_spinner);
        spinner1List.clear();
        spinner1List.add("ZB型橡胶缓冲器");
        spinner1List.add("ZB型胶泥缓冲器");
        adapter1 = new ArrayAdapter(getActivity(), R.layout.spinner_item_layout, spinner1List);
        adapter1.setDropDownViewResource(R.layout.spinner_item_layout);
        xnplan_left_spinner.setAdapter(adapter1);

        xnplan_right_spinner = (Spinner) view.findViewById(R.id.xnplan_right_spinner);
        spinner2List.clear();
        spinner2List.add("压溃管+蜂窝防爬器");
        spinner2List.add("压溃管/蜂窝防爬器");
        adapter2 = new ArrayAdapter(getActivity(), R.layout.spinner_item_layout, spinner2List);
        adapter2.setDropDownViewResource(R.layout.spinner_item_layout);
        xnplan_right_spinner.setAdapter(adapter2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_car_type_text://添加车辆种类
                carNameList.add(" ");
                carWeightList.add(" ");
                carTypeAdapter.notifyDataSetChanged();
                break;
            case R.id.add_xineng_type_text://添加吸能方案
                xnPlanList.add(" ");
                xncurveList.add(" ");
                xnTypeAdapter.notifyDataSetChanged();
                break;
            case R.id.xnplan_commit_btn://吸能方案确定
                main_linear.setVisibility(View.VISIBLE);
                xnplan_linear.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}
