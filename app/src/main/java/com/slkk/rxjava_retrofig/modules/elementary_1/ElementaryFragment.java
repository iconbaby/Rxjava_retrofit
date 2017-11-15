package com.slkk.rxjava_retrofig.modules.elementary_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.slkk.rxjava_retrofig.BaseFragment;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.adapter.ZhuangbiListAdapter;
import com.slkk.rxjava_retrofig.modle.ZhihuRootBean;
import com.slkk.rxjava_retrofig.network.Network;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by slkk on 2017/11/10.
 */

public class ElementaryFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "ElementaryFragment";
    @BindView(R.id.rb_keai)
    RadioButton rbKeai;
    @BindView(R.id.rb_110)
    RadioButton rb110;
    @BindView(R.id.rb_zaixia)
    RadioButton rbZaixia;
    @BindView(R.id.rb_zhuangbi)
    RadioButton rbZhuangbi;
    @BindView(R.id.element_rv)
    RecyclerView elementRv;
    @BindView(R.id.swp)
    SwipeRefreshLayout swp;
    @BindView(R.id.radiaGroup)
    RadioGroup radiaGroup;

    private ZhuangbiListAdapter adapter = new ZhuangbiListAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elementary, container, false);
        ButterKnife.bind(this, view);

        elementRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        elementRv.setAdapter(adapter);

        swp.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW);
        swp.setEnabled(false);

        radiaGroup.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    private void loadImage(String key) {
        Log.i(TAG, "loadImage: " + key);
        disposable = Network.getZhuangbi()
                .search()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhihuRootBean>() {
                    @Override
                    public void accept(ZhihuRootBean zhihurootbean) throws Exception {
                        Log.i(TAG, "accept: ");
                        swp.setRefreshing(false);
                        adapter.setImage(zhihurootbean.getStories());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        swp.setRefreshing(false);
                    }
                })
        ;
//        Network.testRetrofit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        unsubsribe();
        swp.setRefreshing(true);
        adapter.setImage(null);
        switch (checkedId) {
            case R.id.rb_keai:
                loadImage(rbKeai.getText().toString());
                Log.i(TAG, "onCheckedChanged: ");
                break;
            case R.id.rb_110:
                break;
            case R.id.rb_zaixia:
                break;
            case R.id.rb_zhuangbi:
                break;
        }
    }
}
