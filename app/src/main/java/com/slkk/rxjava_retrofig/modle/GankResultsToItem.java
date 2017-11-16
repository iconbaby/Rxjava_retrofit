package com.slkk.rxjava_retrofig.modle;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.functions.Function;

/**
 * Created by slkk on 2017/11/16.
 */

public class GankResultsToItem implements Function<GankApiResults, List<GankItem>> {
    public static GankResultsToItem instance = new GankResultsToItem();
    private static final String TAG = "GankResultsToItem";
    private GankResultsToItem() {
    }

    public static GankResultsToItem getInstance() {
        return instance;
    }

    @Override
    public List<GankItem> apply(GankApiResults gankApiResults) throws Exception {
        Log.i(TAG, "apply: ");
        List<GankImage> images = gankApiResults.images;
        List<GankItem> gankItems = new ArrayList<>(images.size());
        SimpleDateFormat inputformat = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss.SS'Z'");
        SimpleDateFormat outputformat = new SimpleDateFormat("yy/MM/dd/ HH:mm:ss");
        for (GankImage image : images) {
            GankItem item = new GankItem();
            Date date = inputformat.parse(image.createdAt);
            item.descreption = outputformat.format(date);
            item.imgUrl = image.url;
            Log.i(TAG, "apply: "+image.url);
            Log.i(TAG, "apply: "+item.descreption);
            gankItems.add(item);
        }
        Log.i(TAG, "apply: "+gankItems.size());
        return gankItems;
    }
}
