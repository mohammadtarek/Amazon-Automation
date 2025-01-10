package com.atroush.gui.pages;

import com.atroush.gui.actions.BrowserActions.BrowserActions;
import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.atroush.gui.actions.BrowserActions.BrowserActions.driver;

public class ShoppingCart_PageObj {

    //locators
    private final By actualTotalPrice = By.xpath("//span[@id='sc-subtotal-amount-activecart']//span");
    private final By itemNames = By.xpath("//span[@class='a-truncate-cut']");
    private final By checkOutBtn = By.name("proceedToRetailCheckout");
    private final By deleteBtn = By.xpath("//input[contains(@name,'submit.delete.')]");

    //paths
//    private String itemName = "//span[contains(text(),'value')]";
    private String itemPricePath = "//span[contains(text(),'value')]/ancestor::ul//span[contains(@class,'a-price a-text-price sc-product-price sc-white-space-nowrap a-size-medium')]//span[contains(@aria-hidden,'true')]";

    //variables

    private List<String> itemNamesList = new ArrayList<String>();

    public double calculateTotalPrice() {

        itemNamesList = SeleUtilities.getMultipleText(itemNames);
//        List<Double> totalPrices = new ArrayList<Double>();
        return getTotalPriceAfterClearing(itemNamesList);
//        for (int i = 0; i < totalPrices.size(); i++) {
//            total += totalPrices.get(i);
//        }
//        return total;
    }


    public double getActualTotalPrice() {
        return formatPriceToDouble(SeleUtilities.getText(actualTotalPrice));

    }

    public double formatPriceToDouble(String price) {
        return Double.parseDouble(price.replaceAll("[^0-9\\.]", ""));
    }

    private double getTotalPriceAfterClearing(List<String> itemsName) {
        double totalPrice = 0.0;
        for (int i = 0; i < itemsName.size(); i++) {
            String price = SeleUtilities.getText(By.xpath(itemPricePath.replace("value", itemsName.get(i))));
            totalPrice += formatPriceToDouble(price);
        }
        return totalPrice;
    }
//
//    private List<Double> getTotalPriceAfterClearing(List<String> itemsName) {
//
//        By wholePriceLabel;
//        By fractionalPriceLabel;
//        String wholePricePath = "//span[@class='aok-align-center a-text-bold']//span[@class='a-price-whole']";
//        String fractionalPricePath = "//span[@class='aok-align-center a-text-bold']//span[@class='a-price-fraction']";
//        String ancestor = "/ancestor::ul";
//
//        for (int i = 0; i < itemsName.size(); i++) {
//
//            String finalWholePricePath = itemName.replace("value", itemsName.get(i)) + ancestor + wholePricePath;
//            wholePriceLabel = By.xpath(finalWholePricePath);
//            String wholePriceFormatted = SeleUtilities.getText(wholePriceLabel).replace(",", "");
//
//            String finalFractionalPricePath = itemName.replace("value", itemsName.get(i)) + ancestor + fractionalPricePath;
//            fractionalPriceLabel = By.xpath(finalFractionalPricePath);
//            String fractionalPriceFormatted = SeleUtilities.getText(fractionalPriceLabel);
//
//            finalTotalPrices.add(Double.parseDouble(wholePriceFormatted + "." + fractionalPriceFormatted));
//        }
//        return finalTotalPrices;
//    }


    public int getCartItemsNum() {
        return itemNamesList.size();
    }

    public void clickCheckOut() {
        SeleUtilities.clickOnElement(checkOutBtn);
    }

    public void clearCart() {
        List<WebElement> elements = new ArrayList<>();
        try {
            SeleUtilities.waitForElementToBeClickable(deleteBtn, 10);
            elements = BrowserActions.driver.findElements(deleteBtn);

        } catch (Exception e) {
            System.out.println("Cart is Empty" + e.getMessage());
        }

        if (elements.size() == 1) {
            SeleUtilities.waitForElementToBeClickable(deleteBtn, 10);
            elements.get(0).click();
        } else {
            int elementsSize = elements.size();
            for (int i = elementsSize - 1; i >= 0; i--) {

//                if (elements.size()  == 1) {
//                    try {
//                        System.out.println("last item of the list" + elements);
//                        SeleUtilities.awaitilityWait(deleteBtn, 2, 10);
//                        SeleUtilities.clickOnElement(deleteBtn);
//                    } catch (Exception e) {
//                        SeleUtilities.retryingFindElement(deleteBtn, 5);
//                        System.out.println("Element not found " + e.getMessage());
//                        SeleUtilities.retryingFindElement(deleteBtn, 5);
//                    }
//                } else {
                SeleUtilities.awaitilityWait(deleteBtn, 2, 5);
                SeleUtilities.waitForThePresenceOfElement(deleteBtn, 10);
                SeleUtilities.waitForElementToBeClickable(deleteBtn, 10);
                elements.get(i).click();
                try {
                    SeleUtilities.awaitilityWait(deleteBtn, 2, 5);
                    elements = driver.findElements(deleteBtn);
                } catch (Exception e) {
                    System.out.println("The cart is Empty now");
                }
//                }
            }
        }
    }
}
