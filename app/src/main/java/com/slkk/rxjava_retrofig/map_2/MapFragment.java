package com.slkk.rxjava_retrofig.map_2;

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

public class MapFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }
}
