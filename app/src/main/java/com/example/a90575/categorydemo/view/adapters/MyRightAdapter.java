package com.example.a90575.categorydemo.view.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.moudle.bean.RightResultBean;

import java.util.List;

public class MyRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private  RightResultBean rightResultBean;
    public MyRightAdapter(Context context) {
        this.context = context;
    }

    public void setData( RightResultBean rBean){
        this.rightResultBean=rBean;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.right_item,null);
        MyRightViewHolder myRightViewHolder=new MyRightViewHolder(view);
        return  myRightViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyRightViewHolder myRightViewHolder= (MyRightViewHolder) holder;
        myRightViewHolder.right_item_name.setText(rightResultBean.getData().get(position).getName());

        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false);
        myRightViewHolder.right_item_recycler.setLayoutManager(gridLayoutManager);

        List<RightResultBean.DataBean.ListBean> list = rightResultBean.getData().get(position).getList();

        MyRightItemAdapter myRightItemAdapter=new MyRightItemAdapter(context);
        myRightItemAdapter.setData(list);
        myRightViewHolder.right_item_recycler.setAdapter(myRightItemAdapter);
        myRightItemAdapter.setOnItemImgListener(new MyRightItemAdapter.OnItemImgListener() {
            @Override
            public void onItemImgClick(View v, int itemposition) {
                Toast.makeText(context,rightResultBean.getData().get(position).getList().get(itemposition).getName()+"被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rightResultBean.getData().size();
    }

    class MyRightViewHolder extends RecyclerView.ViewHolder{
        TextView right_item_name;
        RecyclerView right_item_recycler;
        public MyRightViewHolder(View itemView) {
            super(itemView);
            right_item_name=itemView.findViewById(R.id.right_itme_name);
            right_item_recycler=itemView.findViewById(R.id.right_item_recycler);
        }
    }
}
