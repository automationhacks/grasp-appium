package appium.selfexploration.commands.geolocation;

import appium.BaseAndroid;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;

public class GeoLocationTest {

    @Test
    public void modifyingGeoLocation() {
        AppiumDriver driver = BaseAndroid.getDriver();
        // Method has not yet been implemented (Need to check)
        Location location = driver.location();
        System.out.println(location.getLatitude());

        Location newLocation = new Location(40.7143528, -74.0059731, 10);
        driver.setLocation(newLocation);
    }
}
