package com.example.six_1230_week1.home.model;

public interface IHomeModel {
    public void getHomeData(String url,GetHomeCallBack getHomeCallBack);
    interface GetHomeCallBack{
        public void cheng(String data);
    }
}
