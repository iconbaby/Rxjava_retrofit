package com.slkk.rxjava_retrofig.network;

import com.slkk.rxjava_retrofig.network.api.ZhihuApi;

import okhttp3.OkHttpClient;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by slkk on 2017/11/10.
 */

public class Network {
    private static ZhihuApi zhihuApi;
    private static GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private Network instance;
    private static final String TAG = "Network";

    public static ZhihuApi getZhuangbi() {
        if (zhihuApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://news-at.zhihu.com/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhihuApi = retrofit.create(ZhihuApi.class);
        }

        return zhihuApi;
    }

//    public static void testRetrofit() {
////                .client(okHttpClient)
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://news-at.zhihu.com/")
//                .addConverterFactory(gsonConverterFactory)
////                .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                .build();
//        ZhihuApi zhihuApi = retrofit.create(ZhihuApi.class);
//        Call<ZhihuRootBean> search =  zhihuApi.search();
//        search.enqueue(new Callback<ZhihuRootBean>() {
//            @Override
//            public void onResponse(Call<ZhihuRootBean> call, Response<ZhihuRootBean> response) {
//                if (response.isSuccessful()) {
//                    ZhihuRootBean body = response.body();
//                    List<Stories> topStories = body.getStories();
//                    for (int i = 0; i <topStories.size() ; i++) {
//                        String title = topStories.get(i).getTitle();
//                        Log.i(TAG, "onResponse: "+title);
//
//                    }
//                    Log.i(TAG, "onResponse: " + body.toString() );
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ZhihuRootBean> call, Throwable t) {
//
//            }
//        });
//    }
}
