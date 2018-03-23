package com.techkei.thirumaran.retrofit.presenter;

import com.techkei.thirumaran.retrofit.presenter.IPresenter.IPresenter;
import com.techkei.thirumaran.retrofit.view.IView.IView;

/**
 * Created by Thirumaran on 3/11/2018
 */

public abstract class BasePresenter implements IPresenter {

    protected String TAG = getClass().getSimpleName();

    private IView iView;

    public BasePresenter(){

    }

    public BasePresenter(IView iView) {
        this.iView = iView;
        iView.bindPresenter(this);
    }


    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }
}