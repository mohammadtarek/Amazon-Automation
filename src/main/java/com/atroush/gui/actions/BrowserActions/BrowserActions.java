package com.atroush.gui.actions.BrowserActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {
    public static WebDriver driver;

    public void initializeTheWebDrivers(String browser) {
        try {
            if (browser.toLowerCase().equals(Browsers.chrome.toString())) {
                driver = new ChromeDriver();
            }

        } catch (Exception e) {
            System.out.println("Exception Happened: "+e.getMessage());

        }
    }


    public void navigateTo(String url) {
        driver.get(url);
    }

    public void maximizeScreen() {
        driver.manage().window().maximize();
    }



    enum Browsers {
        chrome,
    }

}
