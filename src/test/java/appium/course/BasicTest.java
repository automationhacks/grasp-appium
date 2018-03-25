package appium.course;

import appium.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    private AppiumDriver driver;

    /**
     * Test case:
     * 1. In API Demos, Tap Preference
     * 2. Tap Preference dependencies
     * 3. Tap on Wifi checkbox
     * 4. Tap Wifi settings
     * 5. Enter "WifiDemo" text in textbox
     * 6. Tap on Ok button
     */
    @Test
    public void basicTest() {
        driver = Base.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement preference = (
                new WebDriverWait(driver, 10)).until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.xpath("//android.widget.TextView[@text='Preference']")));
        preference.click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.TextView[contains(@text, 'Preference dependencies')]"))).click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("android:id/checkbox"))).click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//android.widget.TextView[@text='WiFi settings']"))).click();

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.className("android.widget.EditText"))).sendKeys("Hello World!");

        (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("android:id/button1"))).click();

    }

    @Test
    public void usingAndroidUIAutomator() {
        driver = Base.getDriver();
        // MobileBy with AndroidUIAutomator can be used to identify elements
        // Syntax ("attribute("value")")
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();

        // Each element has certain properties like clickable, enabled. To get elements with
        // some specific property we can use below syntax of AndroidUIAutomator
        int elements = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiSelector().clickable(true)")).size();
        System.out.println(elements);
    }
}
