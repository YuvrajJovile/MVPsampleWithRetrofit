package com.techkei.thirumaran.retrofit.model.IBaseModelListner;

import com.techkei.thirumaran.retrofit.library.CustomException;

/**
 * Created by Thirumaran on 3/11/2018.
 */

public interface IBaseModelListner<T> {

    void onSuccessfulApi(long mTaskId, T data);

    void onFailureApi(long mTaskId, CustomException e);
}
