package com.techkei.thirumaran.retrofit.model.dto.request;

import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by Thirumaran on 3/11/2018.
 */

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)
public class BaseRequest {



    private String category;
    private String input;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
