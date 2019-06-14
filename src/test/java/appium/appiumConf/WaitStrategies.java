package appium.appiumConf;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitStrategies {
    private AppiumDriver driver;

    private String accessibility = "//android.widget.TextView[contains(@text, 'Accessibility')]";
    private String customView = "//android.widget.TextView[contains(@text, 'Custom View')]";
    private String talkBack = "//android.widget.TextView";

    @BeforeMethod
    public void before() {
        driver = BaseAndroid.getDriver();
    }

    @Test
    public void staticHardCodedWaits() throws InterruptedException {
        driver.findElementByXPath(accessibility).click();

        Thread.sleep(3000);
        driver.findElementByXPath(customView).click();

        Thread.sleep(3000);
        String text = driver.findElementById("content").findElement(By.xpath(talkBack)).getText();

        Assert.assertTrue(text.contains("TalkBack"));
    }

    @Test
    public void implicitWaits() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath(accessibility).click();
        driver.findElementByXPath(customView).click();
        String text = driver.findElementById("content").findElement(By.xpath(talkBack)).getText();

        Assert.assertTrue(text.contains("TalkBack"));
    }

    @Test
    public void explicitWaits() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(accessibility))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(customView))).click();

        String actualText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")))
                .findElement(By.xpath(talkBack)).getText();

        Assert.assertTrue(actualText.contains("TalkBack"));
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
