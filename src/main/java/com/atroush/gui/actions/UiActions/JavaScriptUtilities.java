package com.atroush.gui.actions.UiActions;

import com.atroush.gui.actions.BrowserActions.BrowserActions;
import org.openqa.selenium.*;

public class JavaScriptUtilities {

    public static void clickElementWithJavaScript(By locator) {
        SeleUtilities.waitForElementToBeClickable(locator, 15);
        WebElement element = BrowserActions.driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserActions.driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

}

