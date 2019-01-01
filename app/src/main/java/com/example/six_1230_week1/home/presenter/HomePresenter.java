package com.example.six_1230_week1.home.presenter;

import com.example.six_1230_week1.api.Api;
import com.example.six_1230_week1.home.ShowActivity;
import com.example.six_1230_week1.home.model.HomeModel;
import com.example.six_1230_week1.home.model.IHomeModel;

public class HomePresenter implements IHomePresenter {
    private final HomeModel homeModel;
    ShowActivity showActivity;

    public HomePresenter(ShowActivity showActivity) {
        this.showActivity=showActivity;
        homeModel=new HomeModel();
    }

    @Override
    public void getData(String url) {
        homeModel.getHomeData(url, new IHomeModel.GetHomeCallBack() {
            @Override
            public void cheng(String data) {
                showActivity.getHomePreseterData(data);
            }
        });


    }

    @Override
    public void getImageData(String url) {
        homeModel.getHomeData(url, new IHomeModel.GetHomeCallBack() {
            @Override
            public void cheng(String data) {
                showActivity.getHomeImagePreseterData(data);
            }
        });

    }
}
