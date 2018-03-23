package com.techkei.thirumaran.retrofit.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techkei.thirumaran.retrofit.library.CustomException;
import com.techkei.thirumaran.retrofit.presenter.IPresenter.IPresenter;
import com.techkei.thirumaran.retrofit.utils.CodeSnippet;
import com.techkei.thirumaran.retrofit.view.IView.IView;

import butterknife.ButterKnife;

/**
 * Created by Thirumaran on 3/11/2018
 */
public abstract class BaseFragment extends Fragment implements IView {

    protected String TAG = getClass().getSimpleName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @Override
    public void bindPresenter(IPresenter iPresenter) {
    }

    @Override
    public void showMessage(String message) {
        ((IView) getActivity()).showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        ((IView) getActivity()).showMessage(resId);
    }

    @Override
    public void showMessage(CustomException e) {
        ((IView) getActivity()).showMessage(e);
    }

    @Override
    public void showProgressbar() {
        ((IView) getActivity()).showProgressbar();
    }

    @Override
    public void dismissProgressbar() {
        try {
            ((IView) getActivity()).dismissProgressbar();
        } catch (Exception e) {

        }

    }

    @Override
    public CodeSnippet getCodeSnippet() {
        return ((IView) getActivity()).getCodeSnippet();
    }

    protected abstract int getLayoutId();

}