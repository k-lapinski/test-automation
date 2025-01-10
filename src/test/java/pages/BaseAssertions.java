package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;

public interface BaseAssertions {

    default void checkElementIsOnThePage(WebElement... webElements) {
        Arrays.stream(webElements)
                .forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    default void checkTextInTheElement(WebElement webElement, String text) {
        String textInWebElement = webElement.getText();
        Assert.assertTrue(textInWebElement.contains(text), String.format("The content of the item is not as expected: \n'%s' \ndoes not contain \n'%s'", textInWebElement, text));
    }
}
