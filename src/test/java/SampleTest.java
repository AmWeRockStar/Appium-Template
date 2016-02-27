import core.BaseSettings;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class SampleTest {
    static AndroidDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        BaseSettings settings = new BaseSettings();
        driver =  settings.getDriver();
    }

    @Test
    public void clickOnButton() throws Exception{
        WebElement btnSample = driver.findElement(By.id("com.geekybase.appfortraining:id/button"));
        btnSample.click();
    }
    @Test
    public void getTextFromTextView() throws Exception {
        WebElement tvSomeText = driver.findElement(By.id("com.geekybase.appfortraining:id/textView"));
        String expected = "Sample Text";
        assertEquals(expected, tvSomeText.getText());
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
