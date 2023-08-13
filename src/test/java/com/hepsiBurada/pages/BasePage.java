package com.hepsiBurada.pages;

import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#myAccount")
    public WebElement accountButton;

    /**
     * navigates to each page in the account list by typing the name of the page and hovering over
     * @param name
     */
    public void clickFromAccountList(String name) {
        String xpath = "(//div[starts-with(@class,'sf-OldMyAccount-')])[last()]//a[.='" + name + "']";
        BrowserUtility.sleep(2);
        BrowserUtility.hoverOver(accountButton);
        BrowserUtility.sleep(2);
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    @FindBy(xpath = "//span[.='Giriş Yap']")
    public WebElement loginText;

    @FindBy(xpath = "//span[.='task mercedes']")
    public WebElement accountName;

    @FindBy(id = "shoppingCart")
    public WebElement cart;

    @FindBy(id = "cartItemCount")
    public WebElement cartItemCount;

    @FindBy(xpath = "//a[@title='Hepsiburada']")
    public WebElement homePage;

    @FindBy(xpath = "//div[.='ARA']/preceding-sibling::div")
    public WebElement searchBoxClick;

    @FindBy(xpath = "//div[@aria-haspopup='listbox']/input")
    public WebElement searchBox;


}
