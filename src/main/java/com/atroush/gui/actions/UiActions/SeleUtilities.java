package com.atroush.gui.actions.UiActions;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.atroush.gui.actions.BrowserActions.BrowserActions.driver;


public class SeleUtilities {
    public static final int timeOut = 10;


    public static void awaitilityWait(By element, int minTimeOut, int maxTimeOut) {
        Awaitility.await().atLeast(minTimeOut, TimeUnit.SECONDS).atMost(maxTimeOut, TimeUnit.SECONDS).pollInterval(minTimeOut, TimeUnit.SECONDS).until(() -> isElementVisible(element, maxTimeOut));
    }

    public static boolean isElementClickable(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return element != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementVisible(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForElementToBeClickable(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForThePresenceOfElement(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void waitForTheVisibilityOfElement(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForTheVisibilityOfElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public static void clickOnElement(By element) {

        waitForTheVisibilityOfElement(element, timeOut);
        waitForThePresenceOfElement(element, timeOut);
        waitForElementToBeClickable(element, timeOut);
        try {
            driver.findElement(element).click();
        } catch (StaleElementReferenceException e) {
            retryingFindElement(element, 5);
        }

    }

    public static void clickOnMultipleElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);

        for (WebElement element : elements) {
            try {
                waitForElementToBeClickable(element, timeOut);
                element.click();
            } catch (StaleElementReferenceException e) {
                System.out.println("Element became stale");
                retryingFindElement(locator, 5); // Retry if the element becomes stale
            }
        }
    }


    public static void setText(By element, String text) {
        waitForTheVisibilityOfElement(element, timeOut);
        waitForThePresenceOfElement(element, timeOut);
        waitForElementToBeClickable(element, timeOut);
        driver.findElement(element).sendKeys(text);
    }

    public static void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static WebElement retryingFindElement(By locator, int retries) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < retries) {
            try {
                element = driver.findElement(locator);
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException happened, retrying... " + attempts);
            }
            attempts++;
        }
        // If still null after retries, throw an exception or return null
        if (element == null) {
            throw new RuntimeException("Element not found after " + retries + " retries");
        }
        return element;
    }


    public static List<String> getMultipleText(By element) {
        List<String> prices = new ArrayList<String>();
        try {
            waitForTheVisibilityOfElement(element, timeOut);
            waitForThePresenceOfElement(element, timeOut);
            waitForElementToBeClickable(element, timeOut);

            List<WebElement> elements = driver.findElements(element);
            for (WebElement SingleElement : elements) {
                prices.add(SingleElement.getText());
            }

        } catch (StaleElementReferenceException e) {
            System.out.println("Element became stale: " + element);
            retryingFindElement(element, 5);
        }

        return prices;
    }

    public static String getText(By element) {
        String result = "";
        try {
            waitForTheVisibilityOfElement(element, timeOut);
            waitForThePresenceOfElement(element, timeOut);
            waitForElementToBeClickable(element, timeOut);

            result = driver.findElement(element).getText();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element became stale: " + element);
            retryingFindElement(element, 5);
        }
        return result;

    }
}
