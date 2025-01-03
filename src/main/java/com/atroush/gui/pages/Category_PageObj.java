package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class Category_PageObj {
    private final By freeShipping_checkbox = By.xpath("//input[contains(@aria-labelledby, 'Free Shipping')]/following-sibling::i");
    private final By newCondition = By.xpath("//span[text()='New']");

    public Category_PageObj selectFreeShipping() {
        SeleUtilities.clickOnElement(freeShipping_checkbox);
        return this;
    }

    public Category_PageObj selectNewCondition() {
        SeleUtilities.clickOnElement(newCondition);
        return this;
    }
}
