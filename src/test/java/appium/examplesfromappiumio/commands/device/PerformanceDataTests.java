package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PerformanceDataTests {

    @Test (groups = {"run_this"})
    public void getPerformanceDataTest() throws Exception {
        AppiumDriver driver = BaseAndroid.getDriver();
        String appPackage = "io.appium.android.apis";

        List<String> perfDataTypes = ((AndroidDriver) driver).getSupportedPerformanceDataTypes();
        System.out.println("Different available perf data types are: ");
        perfDataTypes.forEach(System.out::println);

        Thread.sleep(3000);
        List<List<Object>> cpuInfo = ((AndroidDriver) driver).getPerformanceData(appPackage, "cpuinfo", 10);
        cpuInfo.forEach(System.out::println);

        List<List<Object>> memoryInfo = ((AndroidDriver) driver).getPerformanceData(appPackage, "memoryinfo", 10);
        Thread.sleep(3000);

        List<List<Object>> batteryInfo = ((AndroidDriver) driver).getPerformanceData(appPackage, "batteryinfo", 10);
        Thread.sleep(3000);

        List<List<Object>> networkInfo = ((AndroidDriver) driver).getPerformanceData(appPackage, "networkinfo", 10);
        Thread.sleep(3000);

        driver.quit();
    }
}
