package com.example.a90575.categorydemo.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.presenter.BasePresenter;
import com.example.a90575.categorydemo.view.interfaces.BaseView;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    private P basePresenter;
    public View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentLayout(),container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        basePresenter=initBasePresenter();
        basePresenter.attachView(this);
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract P initBasePresenter();

    protected P getBasePresenter(){
        return basePresenter;
    }

    protected abstract void initView();

    protected abstract int getFragmentLayout();
}
