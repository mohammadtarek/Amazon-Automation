package com.atroush.api.requests;

import com.atroush.api.helper.Endpoints;
import com.atroush.api.helper.PropertiesReader;
import com.atroush.api.requestModels.CreateUser_ReqModel;
import com.atroush.api.requestModels.UpdateUser_ReqModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateUser_Req {
    public static Response updateUser(String id, String name, String job) {
        UpdateUser_ReqModel updateUserReqModel=new UpdateUser_ReqModel();
        updateUserReqModel.setName(name);
        updateUserReqModel.setJob(job);
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(updateUserReqModel)
                .put(PropertiesReader.getValue("baseUrl") + Endpoints.updateUserEndpoint.replace("id", id));
    }
}
