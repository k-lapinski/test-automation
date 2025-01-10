package pages;

import jdk.jshell.spi.ExecutionControl;
import org.selenium.BrowserConfig;
import org.selenium.PropertyEnum;
import org.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListener.class)
public abstract class BaseTest {
    private static final Duration TIME_OUT_IN_SECONDS = Duration.ofSeconds(Integer.parseInt(PropertyEnum.TIMEOUT.get()));
    protected static String address = new BrowserConfig().getAddress();
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeMethod (alwaysRun = true)
    public static void initialize() throws ExecutionControl.NotImplementedException {
        driver = new WebDriverFactory().createInstance();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        driver.get(address);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

        driver.manage()
                .window()
                .maximize();
    }

    @AfterMethod (alwaysRun = true)
    public static void closeBrowser() {
        driver.quit();
    }
}
