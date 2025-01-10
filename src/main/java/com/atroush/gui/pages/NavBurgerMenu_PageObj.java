package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.JavaScriptUtilities;
import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

public class NavBurgerMenu_PageObj {

    //locators
    private final By videoGamesBtn = By.xpath("//div[text()='Video Games']");
    private final By allVideoGamesBtn = By.xpath("//a[text()='All Video Games']");
    private final By seeAllBtn = By.xpath("//a[@aria-label='See All Categories']");

    public NavBurgerMenu_PageObj selectVideoGames() {
        SeleUtilities.awaitilityWait(seeAllBtn,1,5);
        SeleUtilities.clickOnElement(seeAllBtn);
        SeleUtilities.clickOnElement(videoGamesBtn);
        JavaScriptUtilities.clickElementWithJavaScript(allVideoGamesBtn);
        return this;
    }

}
