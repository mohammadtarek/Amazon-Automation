package com.atroush.gui.pages;

import com.atroush.gui.actions.UiActions.SeleUtilities;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart_PageObj {

    //locators
    private final By actualTotalPrice = By.xpath("//span[@id='sc-subtotal-amount-activecart']//span");
    private String itemName = "//span[contains(text(),'value')]";
    private final By itemNames = By.xpath("//span[@class='a-truncate-cut']");
    private final By checkOutBtn = By.name("proceedToRetailCheckout");

    //variables
    private double total = 0;
    private List<String> itemNamesList = new ArrayList<String>();
    private List<Double> finalTotalPrices = new ArrayList<Double>();

    public double calculateTotalPrice() {

        itemNamesList = SeleUtilities.getMultipleText(itemNames);
        List<Double> totalPrices = new ArrayList<Double>();
        totalPrices = getTotalPriceAfterClearing(itemNamesList);
        for (int i = 0; i < totalPrices.size(); i++) {
            total += totalPrices.get(i);
        }
        return total;
    }


    public double getActualTotalPrice() {
        return formatPriceToDouble(SeleUtilities.getText(actualTotalPrice));

    }

    public double formatPriceToDouble(String price) {
        return Double.parseDouble(price.replaceAll("[^0-9\\.]", ""));
    }

    private List<Double> getTotalPriceAfterClearing(List<String> itemsName) {

        By wholePriceLabel;
        By fractionalPriceLabel;
        String wholePricePath = "//span[@class='aok-align-center a-text-bold']//span[@class='a-price-whole']";
        String fractionalPricePath = "//span[@class='aok-align-center a-text-bold']//span[@class='a-price-fraction']";
        String ancestor = "/ancestor::ul";

        for (int i = 0; i < itemsName.size(); i++) {

            String finalWholePricePath = itemName.replace("value", itemsName.get(i)) + ancestor + wholePricePath;
            wholePriceLabel = By.xpath(finalWholePricePath);
            String wholePriceFormatted = SeleUtilities.getText(wholePriceLabel).replace(",", "");

            String finalFractionalPricePath = itemName.replace("value", itemsName.get(i)) + ancestor + fractionalPricePath;
            fractionalPriceLabel = By.xpath(finalFractionalPricePath);
            String fractionalPriceFormatted = SeleUtilities.getText(fractionalPriceLabel);

            finalTotalPrices.add(Double.parseDouble(wholePriceFormatted + "." + fractionalPriceFormatted));
        }
        return finalTotalPrices;
    }

    public int getCartItemsNum() {
        return itemNamesList.size();
    }

    public void clickCheckOut() {
        SeleUtilities.clickOnElement(checkOutBtn);
    }
}
