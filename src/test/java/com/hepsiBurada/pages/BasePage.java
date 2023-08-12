package com.hepsiBurada.pages;

import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.Driver;
import org.apache.commons.collections.BagUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#myAccount")
    public WebElement accountButton;

    @FindBy(css = "#login")
    public WebElement loginButton;

    @FindBy(xpath = "//a[.='Çıkış Yap']")
    public WebElement logoutButton;

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
