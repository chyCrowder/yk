package com.example.a90575.categorydemo.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.moudle.bean.LeftResultBean;

public class MyLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LeftResultBean leftResultBean;
    public MyLeftAdapter(Context context) {
        this.context = context;
    }

    public void setData(LeftResultBean lBean){
        this.leftResultBean=lBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.left_item,null);
        LeftViewHolder leftViewHolder=new LeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            final LeftViewHolder leftViewHolder= (LeftViewHolder) holder;
            leftViewHolder.left_item_name.setText(leftResultBean.getData().get(position).getName()+"");
            leftViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPosition = leftViewHolder.getLayoutPosition();
                    leftItemClickListener.onLeftItemClick(v,layoutPosition);
                }
            });
    }

    @Override
    public int getItemCount() {
        return leftResultBean.getData().size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder{
        TextView left_item_name;
        public LeftViewHolder(View itemView) {
            super(itemView);
            left_item_name=itemView.findViewById(R.id.left_item_name);
        }
    }
    public LeftItemClickListener leftItemClickListener;

    public void setLeftItemClickListener(LeftItemClickListener leftItemClickListener){
        this.leftItemClickListener=leftItemClickListener;
    }

    public interface LeftItemClickListener{
        void onLeftItemClick(View v,int position);
    }
}
