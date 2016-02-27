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
        driver = settings.getDriver();
    }

    @Test
    public void when_click_on_button_should_see_dialog_message_hello_click() throws Exception {
        WebElement btnSample = driver.findElement(By.id("com.geekybase.appfortraining:id/button"));
        btnSample.click();
        WebElement message = driver.findElement(By.id("android:id/message"));
        assertEquals("Hello click", message.getText());
    }

    @Test
    public void should_see_text_sample_text() throws Exception {
        WebElement tvSomeText = driver.findElement(By.id("com.geekybase.appfortraining:id/textView"));
        String expected = "Sample Text";
        assertEquals(expected, tvSomeText.getText());
    }

    @Test
    public void when_click_toggle_button_should_see_close_state_to_open_state() throws Exception {
        WebElement toggleBtn = driver.findElement(By.id("com.geekybase.appfortraining:id/toggleButton"));
        toggleBtn.click();
        assertEquals("เปิด", toggleBtn.getText());
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
