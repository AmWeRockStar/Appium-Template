import core.BaseSettings;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.JVM)
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
        (driver.findElement(By.name("OK"))).click();
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

    @Test
    public void when_press_on_checkbox_state_should_are_change() throws Exception {
        WebElement chkBox = driver.findElement(By.id("com.geekybase.appfortraining:id/checkBox"));
        chkBox.click();
        assertEquals("" + true, chkBox.getAttribute("checked"));
    }

    @Test
    public void move_seekbar_from_0_to_something() throws Exception {
        WebElement seekBar = driver.findElement(By.id("com.geekybase.appfortraining:id/seekBar"));
        int originalX = seekBar.getLocation().getX();
        int originY = seekBar.getLocation().getY();

        int moveTo = originalX + seekBar.getSize().getWidth();
        TouchAction tAcion = new TouchAction(driver);
        tAcion.press(originalX, originY).moveTo(moveTo - 10, originY).release().perform();
    }

    @Test
    public void put_github_username_should_see_fullname() throws Exception {
        driver.startActivity("com.geekybase.appfortraining", "com.geekybase.appfortraining.activity.ThreeActivity");

        WebElement edtUsername = driver.findElement(By.id("com.geekybase.appfortraining:id/edtUser"));
        edtUsername.sendKeys("werockstar");
        WebElement btnSearch = driver.findElement(By.id("com.geekybase.appfortraining:id/btnSearch"));
        btnSearch.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.geekybase.appfortraining:id/tvFullName")));

        WebElement textFullName = driver.findElement(By.id("com.geekybase.appfortraining:id/tvFullName"));
        assertEquals("Kotchaphan Muangsan", textFullName.getText());
    }

    @Test
    public void swipe_from_one_fragment_to_two_fragment() throws Exception {
        driver.startActivity("com.geekybase.appfortraining", "com.geekybase.appfortraining.activity.FourActivity");
        Thread.sleep(400);
//        int w = driver.manage().window().getSize().getWidth();
//        int h = driver.manage().window().getSize().getHeight();
        driver.swipe(800, 500, 100, 500, 400);
        WebElement content = driver.findElement(By.id("com.geekybase.appfortraining:id/viewPager"));
        assertEquals("Two", content.getAttribute("name"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
