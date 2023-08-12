package com.hepsiBurada.step_definitions;

import com.hepsiBurada.pages.UserInfoPage;
import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountUpdate_StepDefs {

    UserInfoPage userInfoPage = new UserInfoPage();

    String firstDate = "";

    @Then("verify that user is on the {string} page")
    public void verify_that_user_is_on_the_page(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @When("user changes the birthdate")
    public void user_changes_the_birthdate() {
        firstDate = userInfoPage.birthdayInput.getAttribute("value").replaceAll("-", "");
        userInfoPage.fakeBirthDate();
    }

    @When("user clicks on update button")
    public void user_clicks_on_update_button() {
        BrowserUtility.sleep(2);
        BrowserUtility.clickWithJS(userInfoPage.updateButton);
    }

    @Then("verify the update")
    public void verify_the_update() {
        Assert.assertFalse(userInfoPage.birthdayInput.getAttribute("value").replaceAll("-", "").equals(firstDate));
    }

    @When("user logs out")
    public void user_logs_out() {
        userInfoPage.logoutButton.click();
    }

}
