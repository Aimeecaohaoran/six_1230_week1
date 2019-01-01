package com.example.six_1230_week1.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.six_1230_week1.Login.MainActivity;
import com.example.six_1230_week1.R;
import com.example.six_1230_week1.home.adapter.HomeAdapte;
import com.example.six_1230_week1.home.adapter.HomeGridAdapte;
import com.example.six_1230_week1.home.adapter.HomeGriddAdapte;
import com.example.six_1230_week1.home.bean.Bannerbaen;
import com.example.six_1230_week1.home.bean.HomeBean;
import com.example.six_1230_week1.home.presenter.HomePresenter;
import com.example.six_1230_week1.home.view.IHomeView;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity implements IHomeView {

    private ListView listView;
    private GridView gridView,grid_rx;
    private XBanner xbanner;
    private HomePresenter homePresenter;
    private HomeBean homeBean;
    private HomeGridAdapte homeAdapteg;
    private HomeAdapte homeAdapte;
    private HomeGriddAdapte homeAdaptegg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        listView =findViewById(R.id.list_view);
        gridView=findViewById(R.id.grid_view);
        xbanner = findViewById(R.id.xbanner);
        grid_rx = findViewById(R.id.grid_view_rx);
        homePresenter = new HomePresenter(this);
        homePresenter.getData("http://172.17.8.100/small/commodity/v1/commodityList");
        homePresenter.getImageData("http://172.17.8.100/small/commodity/v1/bannerShow");
    }

    @Override
    public void getHomePreseterData(final String data) {
        Gson gson = new Gson();
        homeBean = gson.fromJson(data, HomeBean.class);
        new Thread(){
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listView.setAdapter(new HomeAdapte(ShowActivity.this,homeBean));
                        gridView.setAdapter(new HomeGridAdapte(ShowActivity.this,homeBean));
                        grid_rx.setAdapter(new HomeGriddAdapte(ShowActivity.this,homeBean));
                    }
                });
            }
        }.start();
    }


    @Override
    public void getHomeImagePreseterData(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                final List<String> list = new ArrayList<>();
                Bannerbaen bannerbaen = gson.fromJson(data, Bannerbaen.class);
                List<Bannerbaen.ResultBean> result = bannerbaen.getResult();
                for (int i = 0; i<result.size();i++){
                    list.add(result.get(i).getImageUrl());
                }
                xbanner.setData(list,null);
                xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(ShowActivity.this).load(list.get(position)).into((ImageView) view);
                    }
                });
                xbanner.setPageTransformer(Transformer.Default);
                xbanner.setPageChangeDuration(1000);
            }
        });
    }
}
