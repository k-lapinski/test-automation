package pages;

import com.aventstack.extentreports.ExtentTest;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public abstract class PageObject {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected Actions actions;
    ExtentTest test = TestListener.getTest();

    protected PageObject(WebDriver webDriver, WebDriverWait wait) {
        CustomLogger.setExtentTest(test);
        this.webDriver = webDriver;
        this.wait = wait;
        this.actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);

        CustomLogger.logInfo(String.format("Open: [%s]", getClass().getName()));
    }

    public abstract void waitForPageLoad();

    public void waitMiliseconds(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void waitForVisibilityElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        CustomLogger.logInfo(String.format("Wait for element: [%s]", webElement.getText()));
    }

    public void waitForVisibilityAllElements(WebElement... webElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));

        String elementsText = Arrays.stream(webElements)
                .map(WebElement::getText)
                .collect(Collectors.joining("] ["));

        CustomLogger.logInfo(String.format("Wait for elements: [%s]", elementsText));
    }

    public void clickElement(WebElement webElement) {
        waitForVisibilityElement(webElement);
        webElement.click();

        CustomLogger.logInfo(String.format("Click on the element: [%s]", webElement));
    }

    public void refreshPage() {
        webDriver.navigate()
                .refresh();

        CustomLogger.logInfo(String.format("Refresh page: [%s]", getClass().getName()));
    }

    public void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
        waitForVisibilityAllElements(sourceElement, targetElement);
        actions.dragAndDrop(sourceElement, targetElement).build().perform();

        CustomLogger.logInfo(String.format("Drag and drop element: [%s]", sourceElement));
    }

    public void uploadFile(WebElement fileInput, String absPath) {
        waitForVisibilityElement(fileInput);
        File uploadFile = new File(absPath);
        fileInput.sendKeys(uploadFile.getAbsolutePath());

        CustomLogger.logInfo(String.format("Upload file: [%s]", uploadFile.getAbsolutePath()));
    }
}
