package com.atroush.api;

import com.atroush.api.requests.CreateUser_Req;
import com.atroush.api.requests.GetUser_Req;
import com.atroush.api.requests.UpdateUser_Req;
import com.atroush.api.responseModels.CreateUser_ResModel;
import com.atroush.api.responseModels.UpdateUser_ResModel;
import com.atroush.api.responseModels.getUser_resModel.GetUser_ResModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApisTest {
    String userName = "morpheus";
    String job = "leader";

    @Test(priority = 1)
    public void createUserTest() {
        SoftAssert softAssert = new SoftAssert();

        Response createUserResponseObj = CreateUser_Req.createUser(userName, job);
        CreateUser_ResModel createSingleUserModel = createUserResponseObj.as(CreateUser_ResModel.class);
        softAssert.assertEquals(createSingleUserModel.getName(), "morpheus");
        softAssert.assertEquals(createSingleUserModel.getJob(), "leader");
        softAssert.assertNotNull(createSingleUserModel.getId());
        softAssert.assertNotNull(createSingleUserModel.getCreatedAt());

        System.out.println("Create user response:");
        System.out.println("Id: " + createSingleUserModel.getId());
        System.out.println("Name: " + createSingleUserModel.getName());
        System.out.println("Job: " + createSingleUserModel.getJob());
        System.out.println("Created At: " + createSingleUserModel.getCreatedAt());
        System.out.println(" ");
        softAssert.assertAll();

    }

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
        softAssert.assertNotNull(getUserResModel.getData().getId());
        softAssert.assertNotNull(getUserResModel.getData().getFirstName());
        softAssert.assertNotNull(getUserResModel.getData().getLastName());
        softAssert.assertNotNull(getUserResModel.getData().getEmail());
        softAssert.assertNotNull(getUserResModel.getData().getAvatar());

        softAssert.assertNotNull(getUserResModel.getSupport().getText());
        softAssert.assertNotNull(getUserResModel.getSupport().getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void updateUserTest() {
        SoftAssert softAssert = new SoftAssert();

        Response updateUserResponse = UpdateUser_Req.updateUser("2", "morpheus_updated", "Manager");
        UpdateUser_ResModel updateUserResModel = updateUserResponse.as(UpdateUser_ResModel.class);

        System.out.println("Update User Response: ");
        System.out.println("Updated At: " + updateUserResModel.getUpdatedAt());
        System.out.println("Updated Name: " + updateUserResModel.getName());
        System.out.println("Updated Job: " + updateUserResModel.getJob());
        System.out.println(" ");

        softAssert.assertNotNull(updateUserResModel.getName(), "Failed name not exist");
        softAssert.assertNotNull(updateUserResModel.getJob(), "Failed job not exist");
        softAssert.assertNotNull(updateUserResModel.getUpdatedAt(), "Failed: updatedAt not exist!");
        softAssert.assertAll();
    }
}
