package com.techkei.thirumaran.retrofit.view.IView;

import com.techkei.thirumaran.retrofit.model.dto.response.ContentResponse;

/**
 * Created by Thirumaran on 3/11/2018
 */

public interface IMainActivityView extends IView{
    void setSuccessDatya(ContentResponse data);

    void setFailureMessage(String message);
}
