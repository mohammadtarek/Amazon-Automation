package com.atroush.api.requests;

import com.atroush.api.helper.Endpoints;
import com.atroush.api.helper.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUser_Req {

    public static Response getUser(String id) {
        return RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .get(PropertiesReader.getValue("baseUrl") + Endpoints.getUserEndpoint.replace("id", id));

    }
}
