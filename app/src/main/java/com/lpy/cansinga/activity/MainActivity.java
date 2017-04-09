package com.lpy.cansinga.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lpy.cansinga.R;
import com.lpy.cansinga.fragment.CalculateFragment;
import com.lpy.cansinga.fragment.CarTypeFragment;
import com.lpy.cansinga.fragment.CemDesignFragment;
import com.lpy.cansinga.fragment.SceneDesignFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Button scene_design_btn, type_design_btn, cem_design_btn, begin_calculate_btn;
    private LinearLayout fragment_container;
    private ImageView first_image;

    private SceneDesignFragment sceneDesignFragment;
    private CarTypeFragment carTypeFragment;
    private CemDesignFragment cemDesignFragment;
    private CalculateFragment calculateFragment;

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        sceneDesignFragment = new SceneDesignFragment();
//        manager = getSupportFragmentManager();
//        transaction = manager.beginTransaction();
//        transaction.add(R.id.fragment_container, sceneDesignFragment);
//        transaction.commit();
    }

    private void initView() {
        fragment_container = (LinearLayout) findViewById(R.id.fragment_container);
        first_image = (ImageView) findViewById(R.id.first_image);
        first_image.setVisibility(View.VISIBLE);
        scene_design_btn = (Button) findViewById(R.id.scene_design_btn);
        type_design_btn = (Button) findViewById(R.id.type_design_btn);
        cem_design_btn = (Button) findViewById(R.id.cem_design_btn);
        begin_calculate_btn = (Button) findViewById(R.id.begin_calculate_btn);

        scene_design_btn.setOnClickListener(this);
        type_design_btn.setOnClickListener(this);
        cem_design_btn.setOnClickListener(this);
        begin_calculate_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        first_image.setVisibility(View.GONE);
        scene_design_btn.setBackgroundResource(R.drawable.bg_checked_no);
        scene_design_btn.setTextColor(Color.BLACK);
        type_design_btn.setBackgroundResource(R.drawable.bg_checked_no);
        type_design_btn.setTextColor(Color.BLACK);
        cem_design_btn.setBackgroundResource(R.drawable.bg_checked_no);
        cem_design_btn.setTextColor(Color.BLACK);
        begin_calculate_btn.setBackgroundResource(R.drawable.bg_checked_no);
        begin_calculate_btn.setTextColor(Color.BLACK);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.scene_design_btn:
                if (sceneDesignFragment == null) {
                    sceneDesignFragment = new SceneDesignFragment();
                }
                ft.replace(R.id.fragment_container, sceneDesignFragment);
                scene_design_btn.setBackgroundResource(R.drawable.bg_checked_yes);
                scene_design_btn.setTextColor(Color.WHITE);
                break;
            case R.id.type_design_btn:
                if (carTypeFragment == null) {
                    carTypeFragment = new CarTypeFragment();
                }
                ft.replace(R.id.fragment_container, carTypeFragment);
                type_design_btn.setBackgroundResource(R.drawable.bg_checked_yes);
                type_design_btn.setTextColor(Color.WHITE);
                break;
            case R.id.cem_design_btn:
                if (cemDesignFragment == null) {
                    cemDesignFragment = new CemDesignFragment();
                }
                ft.replace(R.id.fragment_container, cemDesignFragment);
                cem_design_btn.setBackgroundResource(R.drawable.bg_checked_yes);
                cem_design_btn.setTextColor(Color.WHITE);
                break;
            case R.id.begin_calculate_btn:
                if (calculateFragment == null) {
                    calculateFragment = new CalculateFragment();
                }
                ft.replace(R.id.fragment_container, calculateFragment);
                begin_calculate_btn.setBackgroundResource(R.drawable.bg_checked_yes);
                begin_calculate_btn.setTextColor(Color.WHITE);
                break;
            default:
                break;
        }
        ft.commit();
    }
}
