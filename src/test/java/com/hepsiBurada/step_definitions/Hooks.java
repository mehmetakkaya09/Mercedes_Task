package com.hepsiBurada.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.hepsiBurada.utility.ConfigurationReader;
import com.hepsiBurada.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hooks {


    @Before
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @After()
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Driver.closeDriver();
    }


}
