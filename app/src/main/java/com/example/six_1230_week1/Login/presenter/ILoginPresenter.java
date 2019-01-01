package com.example.six_1230_week1.Login.presenter;

import com.example.six_1230_week1.Login.MainActivity;
import com.example.six_1230_week1.Login.model.ILoginModel;
import com.example.six_1230_week1.Login.model.LoginModel;
import com.example.six_1230_week1.api.Api;

public class ILoginPresenter implements LoginPresenter{
    private final ILoginModel loginModel;
    MainActivity mainActivity;

    public ILoginPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        loginModel=new ILoginModel();
    }
    @Override
    public void Login(String name, String pwd) {
        loginModel.getData(Api.LOGIN, name, pwd, new LoginModel.GetLoginCallBack() {
            @Override
            public void getsuccess(String data) {
                mainActivity.getPresenterData(data);
            }
        });
    }
}
