package com.slkk.rxjava_retrofig.modules.map_2;

import android.graphics.Color;
import android.media.MediaActionSound;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.slkk.rxjava_retrofig.BaseFragment;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.adapter.MapFragmentAdapter;
import com.slkk.rxjava_retrofig.modle.GankItem;
import com.slkk.rxjava_retrofig.modle.GankResultsToItem;
import com.slkk.rxjava_retrofig.network.Network;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by slkk on 2017/11/10.
 */

public class MapFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "MapFragment";
    @BindView(R.id.acb_last)
    AppCompatButton acbLast;
    @BindView(R.id.acb_next)
    AppCompatButton acbNext;
    @BindView(R.id.map_rv)
    RecyclerView mapRv;
    @BindView(R.id.map_swp)
    SwipeRefreshLayout mapSwp;
    private MapFragmentAdapter adapter= new MapFragmentAdapter();

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
        mapSwp.setEnabled(false);
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
                loadItem();
                Log.i(TAG, "onClick: ");
                break;
            case R.id.never:
                break;
        }
    }

    private void loadItem() {
        Log.i(TAG, "loadItem: ");
        mapSwp.setRefreshing(true);
        unsubsribe();
        Network.getGankApi()
                .loadGank(10, 1)
                .map(GankResultsToItem.getInstance())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<GankItem>>() {
                    @Override
                    public void accept(List<GankItem> items) throws Exception {
                        Log.i(TAG, "accept: "+items.size());
                        mapSwp.setRefreshing(false);
                        adapter.setItem(items);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mapSwp.setRefreshing(false);
                        Log.i(TAG, "accept: "+throwable.toString());
                        Toast.makeText(getActivity(), "加载错误", Toast.LENGTH_LONG).show();
                    }
                });

    }
}
