package com.techkei.thirumaran.retrofit.presenter.IPresenter;

import android.os.Bundle;

/**
 * Created by Thirumaran on 3/11/2018
 */

public interface IPresenter {

    void onCreatePresenter(Bundle bundle);

    void onStartPresenter();

    void onStopPresenter();

    void onPausePresenter();

    void onResumePresenter();

    void onDestroyPresenter();
}