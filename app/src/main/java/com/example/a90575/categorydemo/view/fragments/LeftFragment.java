package com.example.a90575.categorydemo.view.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.moudle.bean.LeftResultBean;
import com.example.a90575.categorydemo.presenter.MainPresenter;
import com.example.a90575.categorydemo.view.adapters.MyLeftAdapter;
import com.example.a90575.categorydemo.view.interfaces.MainView;

public class LeftFragment extends BaseFragment<MainPresenter> implements MainView {
    private String url="https://www.zhaoapi.cn/product/getCatagory";
    private RecyclerView left_recycler;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            leftResultBean = (LeftResultBean) msg.obj;
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            left_recycler.setLayoutManager(linearLayoutManager);
            adapter = new MyLeftAdapter(getActivity());
            adapter.setData(leftResultBean);
            left_recycler.setAdapter(adapter);

            //处理点击事件
            adapter.setLeftItemClickListener(new MyLeftAdapter.LeftItemClickListener() {
                @Override
                public void onLeftItemClick(View v, int position) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    rightFragment = new RightFragment();
                    Bundle bundle=new Bundle();
                    bundle.putString("cid",leftResultBean.getData().get(position).getCid()+"");
                    rightFragment.setArguments(bundle);
                    fragmentTransaction.replace(R.id.right_frame, rightFragment).commit();
                }
            });
        }
    };
    private MyLeftAdapter adapter;
    private LeftResultBean leftResultBean;
    private RightFragment rightFragment;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        getBasePresenter().getDataFromServer(url);
    }

    @Override
    protected MainPresenter initBasePresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        left_recycler = view.findViewById(R.id.left_recycler);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.left_fragment;
    }

    @Override
    public void onSuccess(LeftResultBean leftResultBean) {
        Message msg=Message.obtain();
        msg.obj=leftResultBean;
        handler.sendMessage(msg);
    }
}
