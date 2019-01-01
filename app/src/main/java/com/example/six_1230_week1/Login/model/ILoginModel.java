package com.example.six_1230_week1.Login.model;

import com.example.six_1230_week1.okhttp.OkHttp3;

public class ILoginModel implements LoginModel {
    @Override
    public void getData(final String url,final String username,final String pwd,final GetLoginCallBack getLoginCallBack) {
       OkHttp3.okHttpPost(url, "18712312312", "121212", new OkHttp3.GetBackPost() {
           @Override
           public void getTrue(String succ) {
          getLoginCallBack.getsuccess(succ);
           }
       });
    }
}
