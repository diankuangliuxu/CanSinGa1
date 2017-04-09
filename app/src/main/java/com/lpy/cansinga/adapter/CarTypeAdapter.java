package com.lpy.cansinga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lpy.cansinga.R;

import java.util.ArrayList;

/**
 * Created by 1040084322@qq.com on 2017/4/1.
 */
public class CarTypeAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> carNameList;
    private ArrayList<String> carWeightList;
    private LayoutInflater inflater;

    public CarTypeAdapter(Context mContext, ArrayList<String> carWeightList, ArrayList<String> carNameList) {
        this.mContext = mContext;
        this.carWeightList = carWeightList;
        this.carNameList = carNameList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return carNameList == null ? 0 : carNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return carNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_cartype_layout, null);
            holder.car_name_edit = (TextView) convertView.findViewById(R.id.car_name_edit);
            holder.car_weight_edit = (EditText) convertView.findViewById(R.id.car_weight_edit);
            holder.delete_btn = (Button) convertView.findViewById(R.id.delete_btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position==0){
            holder.delete_btn.setClickable(false);
            holder.delete_btn.setVisibility(View.INVISIBLE);
        }else {
            holder.delete_btn.setClickable(true);
            holder.delete_btn.setVisibility(View.VISIBLE);
        }
        holder.car_name_edit.setText("m" + (position + 1));
        final int deletePosition = position;
        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carNameList.remove(deletePosition);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView car_name_edit;
        EditText car_weight_edit;
        Button delete_btn;
    }
}
