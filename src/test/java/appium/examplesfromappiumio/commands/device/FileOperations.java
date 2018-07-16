package appium.examplesfromappiumio.commands.device;

import appium.BaseAndroid;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOperations {

    private AndroidDriver driver;

    @BeforeTest
    public void setup() {
       driver = (AndroidDriver) BaseAndroid.getDriver();
    }

    @AfterTest
    public void teardown() {
       driver.quit();
    }

    @Test
    public void pushFileOntoDeviceTest() throws IOException {
        File localFilePath = new File("src/test/resources/test_data/dummy.txt");
        String deviceFolderPath = "sdcard/test_data/dummy.txt";

        // File pushed to remote device is always converted into Base 64
        // Hence while retrieving we need to convert it to UTF8

        driver.pushFile(deviceFolderPath, localFilePath);

        byte[] returnedData = driver.pullFile(deviceFolderPath);
        String convertedFile = new String(returnedData, StandardCharsets.UTF_8);
        System.out.println("File after pulling from device: " + convertedFile);
    }

    @Test
    public void pullFolderFromDeviceTest() throws IOException {
        byte[] folder = driver.pullFolder("sdcard/test_data");
        FileUtils.writeByteArrayToFile(new File("out/results/output.txt"), folder);
    }
}
