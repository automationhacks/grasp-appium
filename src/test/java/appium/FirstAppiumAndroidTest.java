package appium;

/*
This test checks if error pop up is displayed on the app after entering an invalid user name and password.
 */
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;

public class FirstAppiumAndroidTest
{

    private AppiumDriver driver;
    private String emailLoginId = "de.komoot.android:id/jka_v2_proceed_with_email_fragment";
    private String emailTextBoxId = "de.komoot.android:id/lsea_input_field_tet";
    private String invalidEmailString = "invalidEmail";
    private String nextButtonStringId = "de.komoot.android:id/lsea_next_button_tb";
    private String errorMessageId = "de.komoot.android:id/lsea_feedback_message_ttv";
    private String expectedErrorMessage = "Invalid email address";

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "BasicAndroidDevice");
        capabilities.setCapability("app", "C:\\technical\\mobile_apps\\apks\\komoot.apk");
        capabilities.setCapability("appPackage", "de.komoot.android");
        capabilities.setCapability("appActivity", "de.komoot.android.app.JoinKomootActivityV2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void logInWithInvalidEmail() {
        // Click email option
        WebElement emailLoginButton = driver.findElement(By.id(emailLoginId));
        emailLoginButton.click();

        // Wait for next screen and enter invalid email address
        WebElement emailTextBox = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id(emailTextBoxId)));
        emailTextBox.sendKeys(invalidEmailString);

        // Click on next button
        WebElement nextButton = driver.findElement(By.id(nextButtonStringId));
        nextButton.click();

        // Check expected error message is displayed
        WebElement errorMessage = (new WebDriverWait(driver, 10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id(errorMessageId)));
        assertEquals(errorMessage.getText(), expectedErrorMessage);
    }
}
