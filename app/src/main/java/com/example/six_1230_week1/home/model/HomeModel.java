package com.example.six_1230_week1.home.model;

import com.example.six_1230_week1.okhttp.OkHttp3;

public class HomeModel implements IHomeModel{
    @Override
    public void getHomeData(String url, final GetHomeCallBack getHomeCallBack) {
        OkHttp3.okHttpGet(url, new OkHttp3.GetBackGet() {
            @Override
            public void getTrue(String succ) {
                getHomeCallBack.cheng(succ);
            }
        });
    }
}
