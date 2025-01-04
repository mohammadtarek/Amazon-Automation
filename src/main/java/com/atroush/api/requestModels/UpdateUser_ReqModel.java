package com.atroush.api.requestModels;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})

public class UpdateUser_ReqModel {


    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("job")
    public void setJob(String job) {
        this.job = job;
    }


}
