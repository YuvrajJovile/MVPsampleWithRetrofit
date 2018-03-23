package com.techkei.thirumaran.retrofit.utils;

/**
 * Created by Thirumaran on 3/11/2018
 */

public interface Constants {

    interface InternalHttpCode {
        int SUCCESS_CODE = 200;
        int UNAUTH_CODE = 401;
        int ERROR_CODE = 400;
        int FAILURE_CODE = 0;
        int NOT_FOUND = 404;

    }

    interface HttpErrorMessage {
        String INTERNAL_SERVER_ERROR = "server maintance error";
    }


    interface apiKeys {
        long CONTENT_API = 501;
    }
}
