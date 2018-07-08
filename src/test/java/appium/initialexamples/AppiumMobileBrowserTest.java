package appium.initialexamples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class AppiumMobileBrowserTest {

    private AppiumDriver driver;
    private DesiredCapabilities capabilities;

    @Before
    public void setUp() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android device");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }
        catch (MalformedURLException e) {
            System.out.println("Invalid URL provided for appium server");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void performGoogleSearch() {
        driver.get("https://facebook.com");

        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("m_login_email"))).
                sendKeys("appium.io");

        WebElement searchResult = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name=\"login\"]")));
        searchResult.click();

        boolean found = false;

        try {
            WebElement password = (new WebDriverWait(driver, 10)).
                    until(ExpectedConditions.presenceOfElementLocated(By.id("m_login_password")));
            if(password.isDisplayed())
                found = true;
        }
        catch (NoSuchElementException e) {
            System.out.println("Password box not displayed successfully");
        }

        driver.navigate().back();

        assertTrue(found);

    }
}
