package com.lpy.cansinga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.lpy.cansinga.R;

import java.util.ArrayList;

/**
 * Created by 1040084322@qq.com on 2017/4/1.
 */
public class XNTypeAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> xnPlanList;
    private ArrayList<String> xncurveList;
    private LayoutInflater inflater;

    public XNTypeAdapter(Context mContext, ArrayList<String> xnPlanList, ArrayList<String> xncurveList) {
        this.mContext = mContext;
        this.xnPlanList = xnPlanList;
        this.xncurveList = xncurveList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return xnPlanList == null ? 0 : xnPlanList.size();
    }

    @Override
    public Object getItem(int position) {
        return xnPlanList.get(position);
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
            convertView = inflater.inflate(R.layout.item_xnplan_layout, null);
            holder.xnplan_textview = (TextView) convertView.findViewById(R.id.xnplan_textview);
            holder.xncurve_textview = (TextView) convertView.findViewById(R.id.xncurve_textview);
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
        holder.xnplan_textview.setText("吸能方案" + (position + 1));
        final int deleteIndex = position;
        holder.delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xnPlanList.remove(deleteIndex);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView xnplan_textview;
        TextView xncurve_textview;
        Button delete_btn;
    }
}
