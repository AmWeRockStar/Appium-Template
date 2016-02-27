package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BaseSettings {

    private AndroidDriver driver;

    public AndroidDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidTestDevice");
        if (driver == null)
            try {
                driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (Exception e) {
            }
        return driver;
    }
}
