package com.example.a90575.categorydemo.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.moudle.bean.RightResultBean;

import java.util.ArrayList;
import java.util.List;

public class MyRightItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<RightResultBean.DataBean.ListBean> rlist;
    public MyRightItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<RightResultBean.DataBean.ListBean> list){
        if(rlist==null){
            rlist=new ArrayList<>();
        }
        rlist.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.right_item_recycler,null);
        RightItemViewHolder rightItemViewHolder=new RightItemViewHolder(view);
        return rightItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final RightItemViewHolder rightItemViewHolder= (RightItemViewHolder) holder;
        rightItemViewHolder.itemTitle.setText(rlist.get(position).getName());
        Glide.with(context).load(rlist.get(position).getIcon()).into(rightItemViewHolder.itemImg);
        rightItemViewHolder.itemImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int layoutPosition = rightItemViewHolder.getLayoutPosition();
                onItemImgListener.onItemImgClick(v,layoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rlist.size();
    }

    class RightItemViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImg;
        TextView itemTitle;
        public RightItemViewHolder(View itemView) {
            super(itemView);
            itemImg=itemView.findViewById(R.id.right_item_recycler_img);
            itemTitle=itemView.findViewById(R.id.right_item_recycler_title);
        }
    }

    public OnItemImgListener onItemImgListener;
    public interface OnItemImgListener{
        void onItemImgClick(View v,int position);
    }

    public void setOnItemImgListener(OnItemImgListener ImgListener){
        this.onItemImgListener=ImgListener;
    }
}
