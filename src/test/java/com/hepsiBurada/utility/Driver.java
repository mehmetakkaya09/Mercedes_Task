package com.hepsiBurada.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    static String browser;

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            if (System.getProperty("BROWSER") == null) {
                browser = ConfigurationReader.getProperty("browser");
            } else {
                browser = System.getProperty("BROWSER");
            }
            System.out.println("Browser: " + browser);
            switch (browser) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--disable-blink-features");
                        options.addArguments("--disable-blink-features=AutomationControlled");
                        options.addArguments("--disable-extensions");
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        String gridAddress = "";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driver = new RemoteWebDriver(url, desiredCapabilities);
                        driver.manage().window().maximize();
                        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features");
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.addArguments("--disable-extensions");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    break;

                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    break;

                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not support the requested browser");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
