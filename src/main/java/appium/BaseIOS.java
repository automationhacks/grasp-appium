package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseIOS {

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {

        File srcDir = new File("src");
        File appPath = new File(srcDir, "/test/resources/ios/UICatalog.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());

        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("ERROR! Appium server url is invalid!");
        }

        return driver;
    }
}
