package appium.examplesfromappiumio.commands.session.logs;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class LogsTest {

    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BaseAndroid.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getAvailableLogTypesTest() {
        Set<String> logs = driver.manage().logs().getAvailableLogTypes();
        logs.forEach(System.out::println);
    }

    @Test
    public void getLogsTest() {
        LogEntries logs = driver.manage().logs().get("logcat");
        logs.forEach(System.out::println);

        LogEntries clientLogs = driver.manage().logs().get("client");
        clientLogs.forEach(System.out::println);
    }
}
