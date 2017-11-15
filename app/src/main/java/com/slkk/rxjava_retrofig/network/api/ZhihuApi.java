package com.slkk.rxjava_retrofig.network.api;

import com.slkk.rxjava_retrofig.modle.ZhihuRootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by slkk on 2017/11/10.
 */

public interface ZhihuApi {

    @GET("api/4/news/latest")
    Observable<ZhihuRootBean> search();
}
