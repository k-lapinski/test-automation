package pages.example;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

@Getter
public class GooglePage extends PageObject {
    @FindBy(xpath = "//button/*[contains(text(), 'Odrzuć wszystko')]")
    private WebElement odrzucWszystkoButton;

    @FindBy(xpath = "//*[contains(text(), 'Gmail')]")
    private WebElement gmailButton;

    @FindBy(xpath = "//*[contains(text(), 'Grafika')]")
    private WebElement grafikaButton;

    @FindBy(xpath = "//*[@title='Szukaj']")
    private WebElement searchingInput;

    @FindBy(xpath = "//input[@value='Szukaj w Google' and @role='button']")
    private WebElement searchInGoogle;

    public GooglePage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public GoogleSearchedPage goToSearch() {
        clickElement(searchInGoogle);

        return new GoogleSearchedPage(webDriver, wait);
    }
    @Override
    public void waitForPageLoad() {
        waitForVisibilityAllElements(odrzucWszystkoButton, grafikaButton);
    }
}
