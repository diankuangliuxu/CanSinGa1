package com.lpy.cansinga.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lpy.cansinga.R;

import java.util.ArrayList;

/**
 * Created by 1040084322@qq.com on 2017/4/1.
 */
public class RecycleViewRightAdapter extends RecyclerView.Adapter<RecycleViewRightAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<String> arrayList;
    private LayoutInflater inflater;
    private MyItemClickListener mItemClickListener;

    public RecycleViewRightAdapter(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycleview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.text.setText(arrayList.get(position));
        holder.jiemian_text.setText("界面" + (position + 1));
        if (position == arrayList.size()/2 - 1) {
            holder.text.setBackgroundResource(R.drawable.bg_item_head);
        } else {
            holder.text.setBackgroundResource(R.drawable.bg_item);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size()/2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView jiemian_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            jiemian_text = (TextView) itemView.findViewById(R.id.jiemian_text);
        }
    }

    /**
     * 创建一个回调接口
     */
    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    /**
     * 在activity里面adapter就是调用的这个方法,将点击事件监听传递过来,并赋值给全局的监听
     *
     * @param myItemClickListener
     */
    public void setItemClickListener(MyItemClickListener myItemClickListener) {
        this.mItemClickListener = myItemClickListener;
    }
}
