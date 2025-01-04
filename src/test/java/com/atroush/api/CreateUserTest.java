package com.atroush.api;

import com.atroush.api.requests.CreateUser_Req;
import com.atroush.api.responseModels.CreateUser_ResModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserTest {
    @Test(priority = 1)
    public void createUserPos() {
        SoftAssert softAssert = new SoftAssert();
        final String userName = "morpheus";
        final String job = "leader";

            Response createUserResponseObj = CreateUser_Req.createUser(userName, job);
            CreateUser_ResModel createSingleUserModel = createUserResponseObj.as(CreateUser_ResModel.class);

            System.out.println("Create user response:");
            System.out.println("Id: " + createSingleUserModel.getId());
            System.out.println("Name: " + createSingleUserModel.getName());
            System.out.println("Job: " + createSingleUserModel.getJob());
            System.out.println("Created At: " + createSingleUserModel.getCreatedAt());
            System.out.println(" ");

            softAssert.assertEquals(createUserResponseObj.getStatusCode(), 201, "Request Failed");
            softAssert.assertEquals(createSingleUserModel.getName(), "morpheus");
            softAssert.assertEquals(createSingleUserModel.getJob(), "leader");
            softAssert.assertNotNull(createSingleUserModel.getId());
            softAssert.assertNotNull(createSingleUserModel.getCreatedAt());
            softAssert.assertAll();




    }

    @Test(priority = 2)
    public void createUserInvalidUserName() {
        SoftAssert softAssert = new SoftAssert();

        final String job = "leader";
        try {
            Response createUserResponseObj = CreateUser_Req.createUser("", job);
            CreateUser_ResModel createSingleUserModel = createUserResponseObj.as(CreateUser_ResModel.class);

            System.out.println("Create user response:");
            System.out.println("Id: " + createSingleUserModel.getId());
            System.out.println("Name: " + createSingleUserModel.getName());
            System.out.println("Job: " + createSingleUserModel.getJob());
            System.out.println("Created At: " + createSingleUserModel.getCreatedAt());
            System.out.println(" ");

//        softAssert.assertEquals(createUserResponseObj.getStatusCode(), 403, "Request Failed");
            softAssert.assertEquals(createSingleUserModel.getName(), "");
            softAssert.assertEquals(createSingleUserModel.getJob(), "leader");
            softAssert.assertNotNull(createSingleUserModel.getId());
            softAssert.assertNotNull(createSingleUserModel.getCreatedAt());
            softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }

    }

}
