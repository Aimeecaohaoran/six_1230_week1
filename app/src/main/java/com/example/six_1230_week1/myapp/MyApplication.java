package com.example.six_1230_week1.myapp;

import android.app.Application;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .diskCacheFileCount(100)
                .memoryCache(new LruMemoryCache(5 * 1024 * 1024))
                .threadPoolSize(5)
                .build();
        ImageLoader.getInstance().init(build);
    }
}
