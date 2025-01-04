package com.atroush.api.responseModels.getUser_resModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})

public class GetUser_ResModel {
    @JsonProperty("data")
    private Data data;
    @JsonProperty("support")
    private Support support;

    @JsonProperty("data")
    public Data getData() {
        return data;
    }



    @JsonProperty("support")
    public Support getSupport() {
        return support;
    }



}
