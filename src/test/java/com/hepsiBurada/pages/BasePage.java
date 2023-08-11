package com.hepsiBurada.pages;

import com.hepsiBurada.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
