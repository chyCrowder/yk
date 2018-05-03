package com.example.a90575.categorydemo.presenter;

import com.example.a90575.categorydemo.moudle.RightMoudle;
import com.example.a90575.categorydemo.moudle.bean.RightResultBean;
import com.example.a90575.categorydemo.view.interfaces.RightView;

public class RightPresenter extends BasePresenter<RightView> implements RightBack {
    private RightMoudle rightMoudle;

    public RightPresenter() {
        this.rightMoudle = new RightMoudle();
    }

    public void getDataFromServer(String url){
        rightMoudle.getRightData(url,this);
    }

    @Override
    public void onSuccess( RightResultBean rightResultBean) {
        getBaseView().onSuccess(rightResultBean);
    }
}
