package com.techkei.thirumaran.retrofit.model;

import com.techkei.thirumaran.retrofit.library.CustomException;
import com.techkei.thirumaran.retrofit.model.IBaseModelListner.IBaseModelListner;
import com.techkei.thirumaran.retrofit.model.dto.request.ContentRequest;
import com.techkei.thirumaran.retrofit.model.dto.response.ContentResponse;
import com.techkei.thirumaran.retrofit.webservice.ApiClient;
import com.techkei.thirumaran.retrofit.webservice.ApiInterface;

/**
 * Created by Thirumaran on 3/11/2018
 */

public class ContentApiModel extends BaseModel<ContentResponse> {


    private long mCurrentTaskId = -1;
    private IBaseModelListner<ContentResponse> iBaseModelListner;


    public ContentApiModel(IBaseModelListner<ContentResponse> iBaseModelListner) {
        this.iBaseModelListner = iBaseModelListner;
    }

    public void putContentSync(long mTaskId, ContentRequest request) {
        this.mCurrentTaskId = mTaskId;

        enQueueTask(mCurrentTaskId, ApiClient.getClient().create(ApiInterface.class).getContentSync(request));
    }

    @Override
    public void onSuccessfulApi(long mTaskId, ContentResponse data) {
        iBaseModelListner.onSuccessfulApi(mTaskId, data);
    }

    @Override
    public void onFailureApi(long mTaskId, CustomException e) {
        iBaseModelListner.onFailureApi(mTaskId, e);
    }

}
