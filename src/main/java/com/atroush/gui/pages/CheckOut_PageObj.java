package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class CheckOut_PageObj {
    //locators
    private final By addAddressBtn = By.id("add-new-address-desktop-sasp-tango-link");
    private final By declinePrimeBtn = By.id("prime-declineCTA");
    private final By changeAddress = By.xpath("//a[contains(text(),'Change')]");
    private final By addNewAdress = By.id("add-new-address-popover-link");

    public CheckOut_PageObj declinePrime() {
        try {
            SeleUtilities.clickOnElement(declinePrimeBtn);
        } catch (Exception e) {
            System.out.println("Decline Prime didn't appear" + e.getMessage());
        }
        return this;
    }

    public void finalCheckout() {
        try {
            SeleUtilities.clickOnElement(addAddressBtn);
        } catch (Exception e) {
            try {
                SeleUtilities.clickOnElement(changeAddress);
                SeleUtilities.awaitilityWait(addNewAdress,3,10);
                SeleUtilities.clickOnElement(addNewAdress);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


}
