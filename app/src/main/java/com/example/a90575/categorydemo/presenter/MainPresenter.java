package com.example.a90575.categorydemo.presenter;

import com.example.a90575.categorydemo.moudle.MainMoudle;
import com.example.a90575.categorydemo.moudle.bean.LeftResultBean;
import com.example.a90575.categorydemo.view.interfaces.MainView;

public class MainPresenter extends BasePresenter<MainView> implements DataBack{
    private MainMoudle mainMoudle;

    public MainPresenter() {
        this.mainMoudle=new MainMoudle();
    }

    public void getDataFromServer(String url){
        mainMoudle.getLeftData(url,this);
    }

    @Override
    public void onSuccess(LeftResultBean leftResultBean) {
        getBaseView().onSuccess(leftResultBean);
    }
}
