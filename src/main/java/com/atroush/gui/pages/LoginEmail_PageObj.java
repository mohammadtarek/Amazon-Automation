package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class LoginEmail_PageObj {
    private final By emailInput = By.id("ap_email");
    private final By continueBtn = By.id("continue");
    public LoginEmail_PageObj setEmail(String email){
        SeleUtilities.setText(emailInput, email);
        return this;

    }
    public void clickContinue(){
        SeleUtilities.clickOnElement(continueBtn);
    }
}
