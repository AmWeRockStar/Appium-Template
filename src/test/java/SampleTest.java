import core.BaseSettings;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleTest {
    AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = BaseSettings.getDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
