package appium.selfexploration.commands.session;

import appium.BaseAndroid;
import appium.BaseIOS;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenshotTest {

    private AppiumDriver driver;

    @Test
    public void takeScreenshot() throws InterruptedException {
        driver = BaseAndroid.getDriver();
        Thread.sleep(2000);

        takeScreenshotAsFile("out/test/results");

        driver.quit();
    }

    @Test
    public void takeScreenshotIOS() throws InterruptedException {
        driver = BaseIOS.getDriver();
        Thread.sleep(2000);

        takeScreenshotAsFile("out/test/results");

        driver.quit();
    }

    private void takeScreenshotAsFile(String basePath) {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        String screenshotName = UUID.randomUUID().toString();
        File targetPath = new File(basePath, screenshotName + ".jpg");

        try {
            FileUtils.copyFile(screenshot, targetPath);
        }
        catch (IOException e) {
            System.out.println("Unable to take screenshot");
        }
    }
}
