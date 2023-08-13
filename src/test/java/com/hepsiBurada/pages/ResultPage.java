package com.hepsiBurada.pages;

import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ResultPage extends BasePage{

    @FindBy(xpath = "(//div[.='Sepete ekle']/..)[last()]")
    public WebElement addToCartButton;

    /**
     * hover over the item number requested in the parameter
     * adds to cart when add to cart option is visible
     * @param itemNumber
     */
    public void selectItem(int itemNumber) {
        String xpath = "(//div[@class='product-list']//div[@data-test-id=\"product-info-wrapper\"])["+itemNumber+"]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtility.waitForClickable(element, 10);
        BrowserUtility.scrollToElement(element);
        BrowserUtility.sleep(2);
        BrowserUtility.hoverOver(element);
        BrowserUtility.sleep(2);
        addToCartButton.click();
    }

}
