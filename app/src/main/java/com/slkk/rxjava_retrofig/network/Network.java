package com.slkk.rxjava_retrofig.network;

import com.slkk.rxjava_retrofig.network.api.ZhuangbiAPI;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by slkk on 2017/11/10.
 */

public class Network {
    private static ZhuangbiAPI zhuangbiAPI;
    private static GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private Network instance;

    public static ZhuangbiAPI getZhuangbi() {
        if (zhuangbiAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.zhuangbi.info/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhuangbiAPI = retrofit.create(ZhuangbiAPI.class);
        }
        return zhuangbiAPI;
    }
}
