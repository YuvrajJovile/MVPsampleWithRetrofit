package com.techkei.thirumaran.retrofit.model;

import android.util.Log;

import com.techkei.thirumaran.retrofit.library.CustomException;
import com.techkei.thirumaran.retrofit.library.ExceptionTracker;
import com.techkei.thirumaran.retrofit.model.IBaseModelListner.IBaseModelListner;
import com.techkei.thirumaran.retrofit.model.dto.response.BaseResponse;
import com.techkei.thirumaran.retrofit.utils.Constants;
import com.techkei.thirumaran.retrofit.webservice.ApiClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Thirumaran on 3/11/2018
 */

public abstract class BaseModel<T extends BaseResponse> implements IBaseModelListner<T> {
    private static final String TAG = "BaseModel";
    private long mCurrentTaskId = -1;

    private Callback<T> baseModelCallBackListener = new Callback<T>() {
        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (response.isSuccessful()) {
                if (response.code() == Constants.InternalHttpCode.SUCCESS_CODE) {
                    onSuccessfulApi(mCurrentTaskId, response.body());
                    Log.d("Response body", "" + response.body());
                } else if (response.code() == Constants.InternalHttpCode.ERROR_CODE) {
                    Log.e(TAG, "ERROR: " + response.body());
                    onSuccessfulApi(mCurrentTaskId, response.body());
                } else if (response.errorBody() != null) {
                    Log.e(TAG, "Exception: " + response.errorBody());
                    onFailureApi(mCurrentTaskId, new CustomException(response.code(), response.errorBody().toString()));
                }
                if (response.body() != null) {
                    onSuccessfulApi(mCurrentTaskId, response.body());
                } else {
                    onFailureApi(mCurrentTaskId, new CustomException());
                }
            } else {
                try {
                    Converter<ResponseBody, T> converter = ApiClient.getClient().responseBodyConverter(BaseResponse.class, new Annotation[0]);
                    onFailureApi(mCurrentTaskId, new CustomException(response.code(), converter.convert(response.errorBody())));

                  /*  if(response.code() == Constants.InternalHttpCode.UNAUTH_CODE){
                        Intent intent = new Intent();
                        intent.setClass(get)
                    }*/
                } catch (IOException e) {
                    ExceptionTracker.track("");
                    e.printStackTrace();
                    onFailureApi(mCurrentTaskId, new CustomException(response.code(), "Our server is under maintenance. Kindly try after some time!"));
                }
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            Log.e("Localize Message", "" + t.getLocalizedMessage());
            onFailureApi(mCurrentTaskId, new CustomException(500, "Internal server error"));
        }
    };


    /***/
    public BaseModel() {
    }

    protected void enQueueTask(long taskId, Call<T> tCall) {
        this.mCurrentTaskId = taskId;
        tCall.enqueue(baseModelCallBackListener);
    }


}

