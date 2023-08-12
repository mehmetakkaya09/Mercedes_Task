package com.hepsiBurada.pages;

import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "#txtUserName")
    public WebElement userName;

    @FindBy(css ="#txtPassword")
    public WebElement password;

    public void login(String login, String username, String pass){
        clickFromAccountList(login);
        userName.sendKeys(username + Keys.ENTER);
        password.sendKeys(pass + Keys.ENTER);
    }

}
