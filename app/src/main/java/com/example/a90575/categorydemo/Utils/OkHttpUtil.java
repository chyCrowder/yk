package com.example.a90575.categorydemo.Utils;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtil {
    static OkHttpUtil okHttpUtil;
    static OkHttpClient okHttpClient;

    private OkHttpUtil() {

    }

    public static OkHttpUtil getInstance(){
        if(okHttpUtil==null){
            synchronized (OkHttpUtil.class){
                if(okHttpUtil==null){
                    okHttpUtil=new OkHttpUtil();
                    okHttpClient=new OkHttpClient.Builder()
                            .readTimeout(5000, TimeUnit.SECONDS)
                            .connectTimeout(5000,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpUtil;
    }

    //get请求
    public void doGet(String url, Callback callback){
        Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    //post
    public void doPost(String url, Map<String,String> parms, Callback callback){
        FormBody.Builder builder=new FormBody.Builder();
        Iterator<String> iterator = parms.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = parms.get(key);
            builder.add(key,value);
        }
        Request request=new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
