package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class CheckOut_PageObj {
    //locators
    private final By addAddressBtn = By.id("add-new-address-desktop-sasp-tango-link");

    public void finalCheckout() {
        SeleUtilities.clickOnElement(addAddressBtn);
    }

}
