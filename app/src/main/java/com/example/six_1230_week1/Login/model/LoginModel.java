package com.example.six_1230_week1.Login.model;

public interface LoginModel {
    void getData(String url,String username,String pwd,GetLoginCallBack getLoginCallBack);
    interface GetLoginCallBack{
       public void getsuccess(String data);
    }
}
