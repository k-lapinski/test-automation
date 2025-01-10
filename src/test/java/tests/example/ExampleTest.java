package tests.example;

import databases.DatabaseManager;
import org.selenium.PropertyEnum;
import org.testng.annotations.Test;
import pages.BaseTest;

import pages.example.GoogleAssertions;
import pages.example.GooglePage;
import pages.example.GoogleSearchedPage;

public class ExampleTest extends BaseTest implements GoogleAssertions {

   // @BeforeMethod
    private void insertDataBeforeEveryTest() {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.insertData("test", "test");
    }

  //  @AfterMethod(onlyForGroups = "smoke")
    private void deleteDataAfterTestX() {
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.deleteData("test");
    }

    @Test(description = "T.1 - Google - Verify search engine and page", groups = {"smoke"})
    public void firstTest(){
        // Go to google page
        GooglePage googlePage = new GooglePage(driver, wait);
        verifyGoogleMainPage(googlePage);

        // Print login and click on element odrzucWszystkoButton
        System.out.println(PropertyEnum.TESTOWY_LOGIN.get());
        googlePage.clickElement(googlePage.getOdrzucWszystkoButton());

        // Use drag n drop and searching
        googlePage.dragAndDropElement(googlePage.getGmailButton(), googlePage.getSearchingInput());
        GoogleSearchedPage googleSearchedPage = googlePage.goToSearch();
        verifySearchingEngine(googleSearchedPage, "Gmail");
    }

    @Test(description = "T.2 - Google - Check 'O nas' button and refreshing page")
    public void secondTest() {
        // Go to google page
        GooglePage googlePage = new GooglePage(driver, wait);
        verifyGoogleMainPage(googlePage);

        // Refresh page
        googlePage.refreshPage();
    }
}
