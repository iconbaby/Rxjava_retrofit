package com.slkk.rxjava_retrofig.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by slkk on 2017/11/16.
 */

public class GankApiResults {
    public boolean error;
    public @SerializedName ("results") List<GankImage> images;
}
