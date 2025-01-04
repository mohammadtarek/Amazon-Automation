package com.atroush.api;

import com.atroush.api.requests.GetUser_Req;
import com.atroush.api.responseModels.getUser_resModel.GetUser_ResModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetUserTest {
    @Test(priority = 2)
    public void getUerTest() {
        SoftAssert softAssert = new SoftAssert();

        Response getUserResponseObj = GetUser_Req.getUser("2");
        GetUser_ResModel getUserResModel = getUserResponseObj.as(GetUser_ResModel.class);

        System.out.println("Get User Response: ");
        System.out.println("Id: " + getUserResModel.getData().getId());
        System.out.println("First Name: " + getUserResModel.getData().getFirstName());
        System.out.println("Last Name: " + getUserResModel.getData().getLastName());
        System.out.println("Email: " + getUserResModel.getData().getEmail());
        System.out.println("Avatar: " + getUserResModel.getData().getAvatar());
        System.out.println("Support Text: " + getUserResModel.getSupport().getText());
        System.out.println("Support URL: " + getUserResModel.getSupport().getUrl());
        System.out.println(" ");

        softAssert.assertEquals(getUserResponseObj.getStatusCode(), 200, "Request Failed");
        softAssert.assertNotNull(getUserResModel.getData().getId());
        softAssert.assertNotNull(getUserResModel.getData().getFirstName());
        softAssert.assertNotNull(getUserResModel.getData().getLastName());
        softAssert.assertNotNull(getUserResModel.getData().getEmail());
        softAssert.assertNotNull(getUserResModel.getData().getAvatar());

        softAssert.assertNotNull(getUserResModel.getSupport().getText());
        softAssert.assertNotNull(getUserResModel.getSupport().getUrl());
        softAssert.assertAll();
    }
}
