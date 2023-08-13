package com.hepsiBurada.pages;

import com.hepsiBurada.utility.ConfigurationReader;
import com.hepsiBurada.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = ".basket_delete_1U-UX")
    public WebElement deleteProducts;

    @FindBy(xpath = "//button[.='Tümünü sil']")
    public WebElement deleteAll;

    @FindBy(xpath = "//h1[.='Sepetin şu an boş']")
    public WebElement cartEmptyText;

    @FindBy(id = "selectedCheckBox")
    public WebElement selectedCheckBox;

    /**
     * increments the number of products by one according to the item number
     * @param itemNumber
     */
    public void increaseItem(int itemNumber){
        String xpath = "(//a[@aria-label=\"Ürünü Arttır\"])["+itemNumber+"]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    /**
     * takes the price of the product as a String and returns it as an Double
     * @param itemNumber
     * @return Double price of the selected product
     */
    public double productPrice(int itemNumber){
        String xpath = "(//div[starts-with(@class,'pricebox_right_')])["+itemNumber+"]/div/div";
        String price = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        return Double.parseDouble(price.substring(0,price.indexOf(",")));
    }

    /**
     * takes the quantity of the product as a String and returns it as an Integer
     * @param itemNumber
     * @return Integer quantity of the item
     */
    public int productQuantity(int itemNumber){
        String xpath = "(//div[starts-with(@class,'product_quantities_')])["+itemNumber+"]//input";
        String quantity = Driver.getDriver().findElement(By.xpath(xpath)).getAttribute("value");
        return Integer.parseInt(quantity);
    }

    /**
     *Firstly looks at the number of products in the cart.
     * If there are products in the cart, it goes to CartPage.
     * Deletes all products.
     * Verifies that the basket is empty
     */
    public void deleteItems() {
        int itemCount = Integer.parseInt(cartItemCount.getText());
        if (itemCount > 0) {
            cart.click();
            if (deleteProducts.isDisplayed()) {
                deleteProducts.click();
                deleteAll.click();
                Assert.assertTrue(cartEmptyText.isDisplayed());
                homePage.click();
            }
        }

    }


}
