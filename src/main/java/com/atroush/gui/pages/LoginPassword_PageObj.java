package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class LoginPassword_PageObj {

    //locators
    private final By passwordInput = By.id("ap_password");
    private final By loginBtn = By.id("signInSubmit");

    public LoginPassword_PageObj setPassword(String password) {

        SeleUtilities.setText(passwordInput, password);
        return this;
    }

    public void clickLogin() {

        SeleUtilities.clickOnElement(loginBtn);
    }
}
