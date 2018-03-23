package com.techkei.thirumaran.retrofit.model.dto.response;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Created by Thirumaran on 3/11/2018
 */

@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS_AND_ACCESSORS)

public class ContentResponse extends BaseResponse {


    @JsonField(name = "techkei_details")
    private ArrayList<TecheDetails> techeDetails;

    public ContentResponse() {
    }

    public ArrayList<TecheDetails> getTecheDetails() {
        return techeDetails;
    }

    public void setTecheDetails(ArrayList<TecheDetails> techeDetails) {
        this.techeDetails = techeDetails;
    }
}
