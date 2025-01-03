package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.atroush.gui.actions.BrowserActions.BrowserActions.driver;

public class Results_PageObj {

    //locators
    private final By filterDropDown = By.id("a-autoid-0-announce");
    private final By highToLow = By.xpath("//a[contains(text(),'High to Low')]");
    //select all the addToCart buttons that it's item's price is less 15000
    private final By addToCartBtn = By.xpath("//span[@class='a-price-whole' and translate(., ',', '') < 15000] /ancestor::div[contains(@class,'puis-price-instructions-style')] /following-sibling::div[contains(@class,'top-mini')] //div[contains(@class,' aok-inline-block')]");
    private final By nextBtn = By.xpath("//a[text()='Next']");

    //variables
    private List<WebElement> elements;

    public Results_PageObj openFilterDropDown() {
        SeleUtilities.clickOnElement(filterDropDown);
        return this;
    }

    public Results_PageObj filterByHighToLow() {
        SeleUtilities.clickOnElement(highToLow);
        return this;
    }

    public Results_PageObj addItemsToCart() {
        SeleUtilities.waitForTheVisibilityOfElement(addToCartBtn);
        elements = driver.findElements(addToCartBtn);
        while (elements.isEmpty() & SeleUtilities.isElementClickable(nextBtn, 10)) {
            try {
                SeleUtilities.clickOnElement(nextBtn);
            } catch (NoSuchElementException e) {
                System.out.println("No Matched Results");
            }
        }
        if (!elements.isEmpty()) {
            SeleUtilities.clickOnMultipleElements(addToCartBtn);
        }
        return this;
    }

    public int getItemsNumber() {
        return elements.size();
    }
}
