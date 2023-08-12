package com.hepsiBurada.step_definitions;

import com.hepsiBurada.pages.CartPage;
import com.hepsiBurada.pages.LoginPage;
import com.hepsiBurada.pages.ResultPage;
import com.hepsiBurada.utility.BrowserUtility;
import com.hepsiBurada.utility.ConfigurationReader;
import com.hepsiBurada.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Cart_StepDefs {

    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    ResultPage resultPage = new ResultPage();

    String homepageTitle = "";

    double firstPrice = 0;

    int firsQuantity = 0;

    int currentItemNumber = 0;

    @Given("user is on the homepage {string}")
    public void userIsOnTheHomepage(String title) {
        homepageTitle = title;
        Assert.assertEquals(homepageTitle, Driver.getDriver().getTitle());
    }

    @When("user logs in with valid credentials {string}")
    public void userLogsInWithValidCredentials(String name) {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        Assert.assertTrue(loginPage.accountName.getText().equals(name));
    }


    @When("user deletes old products from the cart")
    public void userDeletesOldProductsFromTheCart() {
        cartPage.deleteItems();
    }

    @And("user types {string} in the search box")
    public void userTypesInTheSearchBox(String laptop) {
        loginPage.searchBoxClick.click();
        loginPage.searchBox.sendKeys(laptop + Keys.ENTER);
    }

    @And("user adds the {int}st and {int}rd products from the search result to the cart")
    public void userAddsTheFirstAndThirdProductsFromTheSearchResultToTheCart(int itemNum1, int itemNum3) {
        resultPage.selectItem(itemNum1);
        resultPage.selectItem(itemNum3);
    }

    @And("user navigates to the cart page {string}")
    public void userNavigatesToTheCartPage(String cartPageTitle) {
        cartPage.cart.click();
        Assert.assertEquals(cartPageTitle, Driver.getDriver().getTitle());
    }

    @Then("verify items in cart")
    public void verifyItemsInCart() {
        Assert.assertTrue(cartPage.selectedCheckBox.isDisplayed());
    }

    @When("user increases the quantity of product {int}")
    public void userIncreasesTheQuantityOfAnyProduct(int itemNumber) {
        currentItemNumber = itemNumber;
        firstPrice = cartPage.productPrice(itemNumber);
        firsQuantity = cartPage.productQuantity(itemNumber);
        cartPage.increaseItem(itemNumber);
        BrowserUtility.sleep(2);
    }

    @Then("verify the increase in product quantity and amount together")
    public void verifyTheIncreaseInProductQuantityAndAmountTogether() {
        Assert.assertTrue(firstPrice < cartPage.productPrice(currentItemNumber));
        Assert.assertTrue(firsQuantity < cartPage.productQuantity(currentItemNumber));

    }

    @When("user returns to homepage without making a purchase")
    public void userReturnsToHomepageWithoutMakingAPurchase() {
        cartPage.homePage.click();
        Assert.assertEquals(homepageTitle, Driver.getDriver().getTitle());
    }

    @And("user logs out")
    public void userLogsOut() {
        BrowserUtility.hoverOver(loginPage.accountButton);
        loginPage.logoutButton.click();
    }

    @Then("verify that logout is done {string}")
    public void verifyThatLogoutIsDone(String login) {
        Assert.assertTrue(loginPage.loginText.getText().equals(login));
    }


}
