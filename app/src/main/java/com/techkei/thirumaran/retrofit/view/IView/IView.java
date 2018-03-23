package com.techkei.thirumaran.retrofit.view.IView;

import android.support.v4.app.FragmentActivity;

import com.techkei.thirumaran.retrofit.library.CustomException;
import com.techkei.thirumaran.retrofit.presenter.IPresenter.IPresenter;
import com.techkei.thirumaran.retrofit.utils.CodeSnippet;

/**
 * Created by Thirumaran on 3/11/2018
 */
public interface IView {

    void showMessage(String message);

    void showMessage(int resId);

    void showMessage(CustomException e);


    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void bindPresenter(IPresenter iPresenter);

    CodeSnippet getCodeSnippet();

}