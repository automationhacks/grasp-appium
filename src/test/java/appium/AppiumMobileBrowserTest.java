package appium;

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

import static junit.framework.TestCase.assertEquals;

public class AppiumMobileBrowserTest {

    private AppiumDriver driver;
    private DesiredCapabilities capabilities;

    @Before
    public void setUp() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "donatello");
        capabilities.setCapability("browserName", "Browser");

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
        driver.get("https://www.google.com");

        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib"))).
                sendKeys("appium.io");

        (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.elementToBeClickable(By.name("btnG"))).
                        click();

        boolean found = false;

        try {
            WebElement searchResult = (new WebDriverWait(driver, 10)).
                    until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"http://appium.io/\"]")));

            if(searchResult.isDisplayed())
                found = true;
        }
        catch (NoSuchElementException e) {
            System.out.println("Element not displayed successfully");
        }

        assertEquals(found, true);

    }
}
