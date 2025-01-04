package com.atroush.api.responseModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job",
        "id",
        "createdAt"
})

public class CreateUser_ResModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("job")
    public String getJob() {
        return job;
    }
    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }
}
