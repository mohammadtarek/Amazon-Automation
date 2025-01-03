package com.atroush.gui.tests;

import com.atroush.gui.actions.BrowserActions.BrowserActions;
import com.atroush.gui.helper.ConfigReader;
import com.atroush.gui.helper.JsonFileParser;
import com.atroush.gui.pages.*;
import com.atroush.gui.pages.Category_PageObj;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAddVideoGames {
    //objects
    ConfigReader configReader = new ConfigReader();
    BrowserActions browserActions = new BrowserActions();
    SoftAssert softAssert = new SoftAssert();
    //variables
    protected final String baseUrl = configReader.getProperty("baseUrl");


    //private WebDriver driver;

    @BeforeClass

    public void setup() {
        browserActions.initializeTheWebDrivers("chrome");
        browserActions.maximizeScreen();
        browserActions.navigateTo(baseUrl);
    }

    @Test
    public void selectVideoGames() {
        //obj initialization
        Home_PageObj homePageObj = new Home_PageObj();
        NavBurgerMenu_PageObj catMenuPageObj = new NavBurgerMenu_PageObj();
        Category_PageObj categoryPageObj = new Category_PageObj();
        Results_PageObj resultsPageObj = new Results_PageObj();
        ShoppingCart_PageObj shoppingCartPageObj = new ShoppingCart_PageObj();
        CheckOut_PageObj checkOutPageObj = new CheckOut_PageObj();

        changeLangeuageToEnglish();

        navigateToLoginPage();
        login();
        openBurgerMenu();

        catMenuPageObj.selectVideoGames();
        categoryPageObj.selectFreeShipping().selectNewCondition();
        resultsPageObj.openFilterDropDown().filterByHighToLow().addItemsToCart();

        homePageObj.navigateToCart();

        assertIemsTotalPrice(shoppingCartPageObj.calculateTotalPrice(), shoppingCartPageObj.getActualTotalPrice());
        validateCartItemsNum(shoppingCartPageObj.getCartItemsNum(), resultsPageObj.getItemsNumber());
        shoppingCartPageObj.clickCheckOut();
        checkOutPageObj.finalCheckout();
        setAddressDetails();
        softAssert.assertAll();

    }

    public void changeLangeuageToEnglish() {
        Home_PageObj homePageObj = new Home_PageObj();
        homePageObj.changeLanguageToEnglish();
    }

    public void navigateToLoginPage() {
        Home_PageObj homePageObj = new Home_PageObj();
        homePageObj.navigateToLoginPage();
    }

    public void login() {
        LoginEmail_PageObj loginEmailPageObj =new LoginEmail_PageObj();
        LoginPassword_PageObj loginPasswordPageObj = new LoginPassword_PageObj();

        loginEmailPageObj.setEmail(configReader.getProperty("username"))
                .clickContinue();
        loginPasswordPageObj.setPassword( configReader.getProperty("password"))
                .clickLogin();

    }

    public void openBurgerMenu() {
        Home_PageObj homePageObj = new Home_PageObj();
        homePageObj.openBurgerMenu();
    }

    public void setAddressDetails() {
        try {
            JsonFileParser jsonFileParser = new JsonFileParser();
            Address_PageObj addressPageObj = new Address_PageObj();
            addressPageObj.setFullName(jsonFileParser.getValue("fullName")).
                    setPhoneNumber(jsonFileParser.getValue("phoneNumber")).
                    setStreetName(jsonFileParser.getValue("streetName")).
                    setBuildingName(jsonFileParser.getValue("buildingName")).
                    setCity(jsonFileParser.getValue("city")).
                    setDistrict(jsonFileParser.getValue("district")).
                    setNearestLandMark("nearestLandMark").
                    chooseDefaultAddress().
                    clickUseThisAddress();
        } catch (Exception e) {
            System.out.println("Exception happened while accessing the json file" + e.getMessage());
        }

    }

    public void assertIemsTotalPrice(double expectedTotalPrice, double actualTotalPrice) {

        softAssert.assertEquals(actualTotalPrice, expectedTotalPrice, "In Correct Total Price Calculation");
    }

    public void validateCartItemsNum(int expecteTodtalNumber, int cartTotalNumber) {

        softAssert.assertEquals(cartTotalNumber, expecteTodtalNumber, "Cart Items Not Matched");
    }

    @AfterClass
    public void tearDown() {
        if (BrowserActions.driver != null) {
            BrowserActions.driver.quit();
        }
    }


}