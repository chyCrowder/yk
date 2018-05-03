package com.example.a90575.categorydemo.presenter;

import com.example.a90575.categorydemo.view.interfaces.BaseView;

public class BasePresenter<V extends BaseView> {
    private V baseView;

    public void attachView(V baseView){
        this.baseView=baseView;
    }

    public void detachView(){
        if(this.baseView!=null){
            this.baseView=baseView;
        }
    }

    public V getBaseView(){
        return baseView;
    }
}
