package com.atroush.api.requests;


import com.atroush.api.helper.Endpoints;
import com.atroush.api.helper.PropertiesReader;
import com.atroush.api.requestModels.CreateUser_ReqModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser_Req {

  public static Response createUser(String name,String job){
      CreateUser_ReqModel createUserReqModel=new CreateUser_ReqModel();
      createUserReqModel.setName(name);
      createUserReqModel.setJob(job);
      return RestAssured
              .given()
              .log().all()
              .contentType("application/json")
              .body(createUserReqModel)
              .post(PropertiesReader.getValue("baseUrl") +Endpoints.createUserEndpoint);
  }
}
