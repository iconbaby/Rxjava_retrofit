package com.slkk.rxjava_retrofig.network.api;

import com.slkk.rxjava_retrofig.modle.GankApiResults;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by slkk on 2017/11/16.
 */

public interface GankApi {
    @GET("api/data/福利/{number}/{page}")
    Observable<GankApiResults> loadGank(@Path("number") int number, @Path("page") int page);
}
