package pages.example;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

@Getter
public class GoogleSearchedPage extends PageObject {
    @FindBy(xpath = "//*[@role='list']/*/*/*[contains(text(), 'Wszystko')]")
    private WebElement everything;
    @FindBy(id = "search")
    private WebElement searching;

    public GoogleSearchedPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }
    @Override
    public void waitForPageLoad() {
        waitForVisibilityAllElements(everything);
    }
}
