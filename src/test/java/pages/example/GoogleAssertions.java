package pages.example;

import pages.BaseAssertions;

public interface GoogleAssertions extends BaseAssertions {
    default void verifyGoogleMainPage(GooglePage googlePage) {
        googlePage.waitForPageLoad();
        checkElementIsOnThePage(googlePage.getGmailButton(), googlePage.getGrafikaButton());
    }

    default void verifySearchingEngine(GoogleSearchedPage googleSearchedPage, String textToVerify) {
        googleSearchedPage.waitForPageLoad();
        checkTextInTheElement(googleSearchedPage.getSearching(), textToVerify);
    }
}
