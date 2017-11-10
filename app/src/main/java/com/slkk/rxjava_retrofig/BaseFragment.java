package com.slkk.rxjava_retrofig;

import android.app.Fragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by slkk on 2017/11/10.
 */

public class BaseFragment extends Fragment {
    protected Disposable disposable;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubsribe();
    }


    protected void unsubsribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
