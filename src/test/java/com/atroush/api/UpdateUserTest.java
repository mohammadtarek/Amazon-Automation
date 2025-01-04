package com.atroush.api;

import com.atroush.api.requests.UpdateUser_Req;
import com.atroush.api.responseModels.UpdateUser_ResModel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateUserTest {
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

        softAssert.assertEquals(updateUserResponse.getStatusCode(), 200, "Request Failed");
        softAssert.assertNotNull(updateUserResModel.getName(), "Failed name not exist");
        softAssert.assertNotNull(updateUserResModel.getJob(), "Failed job not exist");
        softAssert.assertNotNull(updateUserResModel.getUpdatedAt(), "Failed: updatedAt not exist!");
        softAssert.assertAll();
    }
}
