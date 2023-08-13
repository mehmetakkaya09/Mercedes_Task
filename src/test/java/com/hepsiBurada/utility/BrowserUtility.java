package com.hepsiBurada.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;


public class BrowserUtility {
    static Actions action = new Actions(Driver.getDriver());

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

    public static void hoverOver(WebElement element) {
        action.moveToElement(element).build().perform();
    }



}
