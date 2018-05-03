package com.example.a90575.categorydemo.moudle;

import com.example.a90575.categorydemo.Utils.OkHttpUtil;
import com.example.a90575.categorydemo.moudle.bean.LeftResultBean;
import com.example.a90575.categorydemo.presenter.DataBack;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainMoudle{
    public void getLeftData(String url, final DataBack dataBack){
        OkHttpUtil.getInstance().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson=new Gson();
                LeftResultBean leftResultBean = gson.fromJson(json, LeftResultBean.class);
                dataBack.onSuccess(leftResultBean);
            }
        });
    }


}
