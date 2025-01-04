package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.JavaScriptUtilities;
import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class Address_PageObj {
    //locators
    private final By fullNameInput = By.id("address-ui-widgets-enterAddressFullName");
    private final By phoneNumberInput = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By streetNameInput = By.id("address-ui-widgets-enterAddressLine1");
    private final By buildingNameInput = By.id("address-ui-widgets-enter-building-name-or-number");
    private final By cityInput = By.id("address-ui-widgets-enterAddressCity");
    private final By districtInput = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private final By nearestLandMarkInput = By.id("address-ui-widgets-landmark");
    private final By defaultAddressCheckbox = By.id("address-ui-widgets-use-as-my-default");
    private final By useThisAddressBtn = By.xpath("//span[@id='checkout-primary-continue-button-id']//input[@data-csa-c-slot-id='address-ui-widgets-continue-address-btn-bottom']");
    private final By addThisAddressBtn = By.xpath("//span[@id='address-ui-widgets-form-submit-button']//input");
    //variables
    private String cityInputPath = "//li[contains(text(),'value')]";
    private String districtInputPath = "//li[contains(text(),'value')]";

    public Address_PageObj setFullName(String fullName) {
        SeleUtilities.setText(fullNameInput, fullName);
        return this;
    }

    public Address_PageObj setPhoneNumber(String phoneNumber) {
        SeleUtilities.setText(phoneNumberInput, phoneNumber);
        return this;
    }

    public Address_PageObj setStreetName(String streetName) {
        SeleUtilities.setText(streetNameInput, streetName);
        return this;
    }

    public Address_PageObj setBuildingName(String buildingName) {
        SeleUtilities.setText(buildingNameInput, buildingName);
        return this;
    }

    public Address_PageObj setCity(String city) {
        SeleUtilities.setText(cityInput, city);
        SeleUtilities.clickOnElement(By.xpath(cityInputPath.replace("value", city)));
        return this;
    }

    public Address_PageObj setDistrict(String district) {
        SeleUtilities.setText(districtInput, district);
        SeleUtilities.clickOnElement(By.xpath(districtInputPath.replace("value", district)));
        return this;
    }

    public Address_PageObj setNearestLandMark(String nearestLandMark) {
        SeleUtilities.setText(nearestLandMarkInput, nearestLandMark);
        return this;
    }

    public Address_PageObj chooseDefaultAddress() {
        SeleUtilities.clickOnElement(defaultAddressCheckbox);
        return this;
    }

    public void clickUseThisAddress() {
        try {
            SeleUtilities.awaitilityWait(useThisAddressBtn, 2, 10);
            SeleUtilities.clickOnElement(useThisAddressBtn);
        } catch (Exception e) {
            System.out.println("Exception happened" + e.getMessage());
            SeleUtilities.clickOnElement(addThisAddressBtn);

        }
    }

}
