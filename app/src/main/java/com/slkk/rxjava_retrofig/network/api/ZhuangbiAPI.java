package com.slkk.rxjava_retrofig.network.api;

import com.slkk.rxjava_retrofig.modle.ZhuangbiImage;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by slkk on 2017/11/10.
 */

public interface ZhuangbiAPI {

    @GET("search")
    Observable<List<ZhuangbiImage>> search(@Query("q") String query);

}
