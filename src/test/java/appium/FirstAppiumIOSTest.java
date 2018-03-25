package appium;

/*
Simple test to verify addition of 2 numbers for IOS app
*/

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FirstAppiumIOSTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.2");
        capabilities.setCapability("deviceName", "iPhone 6s");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "/Users/gaurav/mobile_apps/app/TestApp.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addNumbers() {
        MobileElement firstNumber = (MobileElement) driver.findElement(By.name("TextField1"));
        firstNumber.sendKeys("5");

        MobileElement secondNumber = (MobileElement) driver.findElement(By.name("TextField2"));
        secondNumber.sendKeys("10");

        MobileElement computeSum = (MobileElement) driver.findElement(By.name("ComputeSumButton"));
        computeSum.click();

        MobileElement answer = (MobileElement) (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.name("Answer")));
        assertEquals(answer.getText(), "15");
    }



}
