package com.hepsiBurada.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoPage extends BasePage{
    @FindBy(id = "txtBirthDay")
    public WebElement birthdayInput;

    @FindBy(xpath = "(//button[.='Güncelle'])[1]")
    public WebElement updateButton;

    @FindBy(xpath ="//div[(.='Çıkış yap')and(@class='customerAccount-StaticMenuItem-359Tt')]")
    public WebElement logoutButton;

    /**
     * a fake date of birth is produced
     * this date is converted to month/day/year format
     * the / sign is removed and only the digits remain as String
     * birthday is written in the input
     */
    public void fakeBirthDate() {
        Faker faker = new Faker();
        Date birthday = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = sdf.format(birthday).replaceAll("/", "");
        birthdayInput.sendKeys(date);
    }



}
