package com.slkk.rxjava_retrofig.module.cache_6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slkk.rxjava_retrofig.BaseFragment;
import com.slkk.rxjava_retrofig.R;

/**
 * Created by slkk on 2017/11/10.
 */

public class CacheFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cache, container, false);
        return view;

    }
}
