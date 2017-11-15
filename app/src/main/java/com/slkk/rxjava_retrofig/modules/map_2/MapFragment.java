package com.slkk.rxjava_retrofig.modules.map_2;

import android.graphics.Color;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slkk.rxjava_retrofig.BaseFragment;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.adapter.MapFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by slkk on 2017/11/10.
 */

public class MapFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.acb_last)
    AppCompatButton acbLast;
    @BindView(R.id.acb_next)
    AppCompatButton acbNext;
    @BindView(R.id.map_rv)
    RecyclerView mapRv;
    @BindView(R.id.map_swp)
    SwipeRefreshLayout mapSwp;
    private MapFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        acbLast.setOnClickListener(this);
        acbNext.setOnClickListener(this);

        mapRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mapRv.setAdapter(adapter);

        mapSwp.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        mapSwp.setEnabled(true);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acb_last:
                break;
            case R.id.never:
                break;
        }
    }
}
