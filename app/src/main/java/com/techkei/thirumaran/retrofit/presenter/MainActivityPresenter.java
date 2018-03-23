package com.techkei.thirumaran.retrofit.presenter;

import android.os.Bundle;

import com.techkei.thirumaran.retrofit.library.CustomException;
import com.techkei.thirumaran.retrofit.model.ContentApiModel;
import com.techkei.thirumaran.retrofit.model.IBaseModelListner.IBaseModelListner;
import com.techkei.thirumaran.retrofit.model.dto.request.ContentRequest;
import com.techkei.thirumaran.retrofit.model.dto.response.ContentResponse;
import com.techkei.thirumaran.retrofit.presenter.IPresenter.IMainActivityPresenter;
import com.techkei.thirumaran.retrofit.view.IView.IMainActivityView;

import static com.techkei.thirumaran.retrofit.utils.Constants.apiKeys.CONTENT_API;

/**
 * Created by Thirumaran on 3/11/2018
 */

public class MainActivityPresenter extends BasePresenter implements IMainActivityPresenter {

    private IMainActivityView iMainActivityView;
    IBaseModelListner<ContentResponse> iBaseModelListner = new IBaseModelListner<ContentResponse>() {
        @Override
        public void onSuccessfulApi(long mTaskId, ContentResponse data) {
            iMainActivityView.setSuccessDatya(data);
        }

        @Override
        public void onFailureApi(long mTaskId, CustomException e) {
            iMainActivityView.setFailureMessage(e.getMessage());
        }
    };

    public MainActivityPresenter(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }

    @Override
    public void postData(String data) {
        if (data != null) {
            ContentRequest request = new ContentRequest();
            request.setPg(data);
            ContentApiModel apiModel = new ContentApiModel(iBaseModelListner);
            apiModel.putContentSync(CONTENT_API, request);


        }
    }
}
