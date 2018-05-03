package com.example.a90575.categorydemo.view.fragments;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.moudle.bean.RightResultBean;
import com.example.a90575.categorydemo.presenter.RightPresenter;
import com.example.a90575.categorydemo.view.interfaces.RightView;
import com.example.a90575.categorydemo.view.adapters.MyRightAdapter;

public class RightFragment extends BaseFragment<RightPresenter> implements RightView {
    private String url="https://www.zhaoapi.cn/product/getProductCatagory";
    private RecyclerView right_recycler;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RightResultBean rightResultBean= (RightResultBean) msg.obj;
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            right_recycler.setLayoutManager(linearLayoutManager);

            MyRightAdapter myRightAdapter=new MyRightAdapter(getActivity());
            myRightAdapter.setData(rightResultBean);
            right_recycler.setAdapter(myRightAdapter);
        }
    };
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        getBasePresenter().getDataFromServer(url);
    }

    @Override
    protected RightPresenter initBasePresenter() {
        return new RightPresenter();
    }

    @Override
    protected void initView() {
        right_recycler = view.findViewById(R.id.right_recycler);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.right_fragment;
    }

    @Override
    public void onSuccess( RightResultBean rightResultBean) {
            Message msg=Message.obtain();
            msg.obj=rightResultBean;
            handler.sendMessage(msg);
    }
}
