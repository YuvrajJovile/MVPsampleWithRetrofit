package com.techkei.thirumaran.retrofit.webservice;

import com.techkei.thirumaran.retrofit.model.dto.request.ContentRequest;
import com.techkei.thirumaran.retrofit.model.dto.response.ContentResponse;
import com.techkei.thirumaran.retrofit.utils.Constants;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Thirumaran on 3/11/2018
 */

public interface ApiInterface {

    @POST("content.php/")
    @Headers("Content-Type: application/json")
    Call<ContentResponse> getContentSync(@Body ContentRequest request);

}
