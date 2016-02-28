package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSettings {

    private AndroidDriver driver;

    public AndroidDriver getDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidTestDevice");
        if (driver == null)
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        return driver;
    }
}
