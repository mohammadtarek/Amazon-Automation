package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.JavaScriptUtilities;
import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class Home_PageObj {
    //locators
    private final By language_btn = By.xpath("//span[@class='icp-nav-flag icp-nav-flag-eg icp-nav-flag-lop'] ");
    private final By english_btn = By.xpath("//div[@id='nav-flyout-icp']//i[@class='icp-radio']");
    private final By all_burger = By.id("nav-hamburger-menu");
    private final By login_btn = By.id("nav-link-accountList");
    private final By cartBtn = By.id("nav-cart");

    public Home_PageObj changeLanguageToEnglish() {

        SeleUtilities.waitForTheVisibilityOfElement(language_btn);
        SeleUtilities.hoverOverElement(language_btn);
        SeleUtilities.clickOnElement(english_btn);
        return this;

    }

    public Home_PageObj openBurgerMenu() {

        SeleUtilities.awaitilityWait(all_burger, 1, 10);
        SeleUtilities.clickOnElement(all_burger);
        return this;
    }

    public Home_PageObj navigateToLoginPage() {
        SeleUtilities.awaitilityWait(all_burger, 3, 10);
        JavaScriptUtilities.clickElementWithJavaScript(login_btn);
        return this;
    }

    public Home_PageObj navigateToCart() {
        SeleUtilities.awaitilityWait(all_burger, 3, 10);
        JavaScriptUtilities.clickElementWithJavaScript(cartBtn);
        return this;
    }
}
