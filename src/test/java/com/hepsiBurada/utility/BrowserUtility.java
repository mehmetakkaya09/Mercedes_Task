package com.hepsiBurada.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserUtility {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void waitForClickable(WebElement element, int seconds) {
        new WebDriverWait(Driver.getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibility(WebElement element, int seconds) {
        new WebDriverWait(Driver.getDriver(), seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisibility(WebElement element, int seconds) {
        new WebDriverWait(Driver.getDriver(), seconds).until(ExpectedConditions.invisibilityOf(element));
    }

}
