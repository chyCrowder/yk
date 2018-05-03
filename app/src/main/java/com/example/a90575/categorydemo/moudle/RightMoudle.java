package com.example.a90575.categorydemo.moudle;

import com.example.a90575.categorydemo.Utils.OkHttpUtil;
import com.example.a90575.categorydemo.moudle.bean.RightResultBean;
import com.example.a90575.categorydemo.presenter.RightBack;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RightMoudle {
    public void getRightData(String url, final RightBack rightBack){
        OkHttpUtil.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson=new Gson();
                RightResultBean rightResultBean = gson.fromJson(json, RightResultBean.class);
                rightBack.onSuccess(rightResultBean);
            }
        });
    }
}
