package tests;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;



public class SearchTest extends BaseTest {

    //1.

    /**
     * Click on search button without typing anything in search bar
     *
     * Test steps :
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In middle of header click on search button without typing anything in search bar
     *
     * Expected results :
     * 2.1 Confirm that you are on : https://www.laguna.rs/
     * 2.2 Error message is displayed : Minimalan broj slova za pretragu je 2.
     */

    @Test

    public void clickOnSearchButtonWithoutTypingAnythingInSearchBar(){
        driver = openChromeDriver();
        log.info("Click on search button without typing anything in search bar");
        try {
            log.info("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2. In middle of header click on search button without typing anything in search bar");
            basePage.clickOnSearchButton();
            Reporter.log("assert 2.1 Confirm that you are on : https://www.laguna.rs/",true);
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);
            Reporter.log("assert 2.2 Error message is displayed : Minimalan broj slova za pretragu je 2.",true);
            basePage.isErrorMessageForSearchDisplayed();

        }finally {
            driver.quit();
        }
    }

    //2.

    /**
     * Type one letter in search field and then click search button
     *
     * Test steps :
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In middle of header in search field, type one letter
     * 3. Click search
     *
     * Expected results :
     * 3.1 Confirm that you are on : https://www.laguna.rs/
     * 3.2 Error message is displayed : Minimalan broj slova za pretragu je 2.
     */

    @Test

    public void typeOneLetterInSearchFieldAndThenClickSearchButton(){
        driver = openChromeDriver();
        log.info("Type one letter in search field and then click search button");
        try {
            log.info("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2. In middle of header in search field type one letter");
            basePage.searchBarSendKeys("a");
            log.info("3. Click search");
            basePage.clickOnSearchButton();
            Reporter.log("assert 3.1 Confirm that you are on : https://www.laguna.rs/",true);
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);
            Reporter.log("assert 3.2 Error message is displayed : Minimalan broj slova za pretragu je 2.",true);
            basePage.isErrorMessageForSearchDisplayed();

        }finally {
            driver.quit();
        }
    }

    //3.

    /**
     * Type two letters in search field and then click search button
     *
     * Test steps :
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In middle of header in search field, type two letters
     * 3. Click search
     *
     * Expected results :
     * 3.1 In the middle of the page under header is displayed : Pretraga
     */

    @Test

    public void typeTwoLettersInSearchFieldAndThenClickSearchButton (){
        driver = openChromeDriver();
        log.info("Type two letters in search field and then click search button");
        try {
            log.info("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2. In middle of header in search field type two letters");
            basePage.searchBarSendKeys("ma");
            log.info("3. Click search");
            basePage.clickOnSearchButton();
            Reporter.log("assert 3.1 In the middle of the page under header is displayed : Pretraga",true);
            SearchPage searchPage = new SearchPage(driver);
            searchPage.isPretragaDisplayedInSearchPage();

        }finally {
            driver.quit();
        }
    }

    //4.

    /**
     * Search for a specific writer and inspect his page
     *
     * Test steps :
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In middle of header in search field, type : Robert Dzordan
     * 3. In dropdown menu click on his name
     *
     * Expected results :
     *
     * 2.1 Assert that dropdown menu is present
     * 3.1 Assert that current url is : https://www.laguna.rs/a37_autor_robert_dzordan_laguna.html
     * 3.2 Assert that his image is displayed
     * 3.3 Assert that his biography is displayed
     * 3.4 Assert that his books are displayed
     */

    @Test

    public void searchForASpecificWriterAndInspectHisPage(){
        driver = openChromeDriver();
        log.info("Search for a specific writer and inspect his page");
        try {
            log.info("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2. In middle of header in search field type : Robert Dzordan");
            basePage.searchBarSendKeys("Robert Dzordan");
            Reporter.log("2.1 Assert that dropdown menu is present",true);
            basePage.isSuggestionsMenuFromSearhBarDisplayed();

            log.info("3. In dropdown menu click on his name");
            basePage.clickOnWriter();
            Reporter.log("3.1 Assert that current url is : https://www.laguna.rs/a37_autor_robert_dzordan_laguna.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.ROBERT_DZORDAN_URL);
            Reporter.log("3.2 Assert that his image is displayed",true);
            WritersPage writersPage = new WritersPage(driver);
            writersPage.isAuthorPhotoDisplayed();
            Reporter.log("3.3 Assert that his biography is displayed",true);
            writersPage.isAuthorBiographyDisplayed();
            Reporter.log("3.4 Assert that his books are displayed",true);
            writersPage.isListOfAuthorBooksDisplayed();

        }finally {
            driver.quit();
        }
    }

    //5.

    /**
     * Search for a specific book and inspect its page
     *
     * Test steps :
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In middle of header in search field, type : Zivotinjska farma
     * 3. Click on search button in header
     * 4. Click on Zivotinjska farma in search results
     *
     * Expected results :
     *
     * 2.1 Assert that dropdown menu is present
     * 3.1 Assert that current url is : https://www.laguna.rs/pretraga-laguna-zivotinjska-farma-str-1.html
     * 4.1 Assert that current url is : https://www.laguna.rs/n5208_knjiga_zivotinjska_farma_laguna.html
     * 4.2 Assert that after you click on the cover of the book,
     * larger cover will be displayed in the middle of the screen
     * 4.3 Assert that data of this book is displayed (under social network share icons)
     * 4.4 Assert that after you click on : ODLOMAK button (under the image of the book),
     * you are redirected on a new tab,where the part of the book is displayed for example
     */

    @Test

    public void searchForASpecificBookAndInspectItsPage(){
        driver = openChromeDriver();
        log.info("Search for a specific book and inspect its page");
        try {
            log.info("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2. In middle of header in search field, type : Zivotinjska farma");
            basePage.searchBarSendKeys("Zivotinjska farma");
            Reporter.log("2.1 Assert that dropdown menu is present",true);
            basePage.isSuggestionsMenuFromSearhBarDisplayed();

            log.info("3. Click on search button in header");
            basePage.clickOnSearchButton();
            Reporter.log("3.1 Assert that current url is : https://www.laguna.rs/pretraga-laguna-zivotinjska-farma-str-1.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.ZIVOTINJSKA_FARMA_SEARCH_PAGE);

            log.info("4. Click on Zivotinjska farma in search results");
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickOnZivotinjskaFarmaOnSearchPage();
            Reporter.log("4.1 Assert that current url is : https://www.laguna.rs/n5208_knjiga_zivotinjska_farma_laguna.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.ZIVOTINJSKA_FARMA_URL);
            Reporter.log("4.2 Assert that after you click on the cover of the book,larger cover will be displayed in the middle of the screen",true);
            BooksPage booksPage = new BooksPage(driver);
            booksPage.clickOnCoverOfTheBookToSeeLargerCover();
            Reporter.log("4.3 Assert that data of this book is displayed (under social network share icons)",true);
            booksPage.isBookDataDisplayed();
            Reporter.log("4.4 Assert that after you click on : ODLOMAK button (under the image of the book),you are redirected on a new tab,where the part of the book is displayed for example",true);
            booksPage.clickOnOdlomakButton();
            basePage.waitForNewUrl(Strings.ODLOMAK_ZIVOTINJSKA_FARMA);
            assertUrl(driver.getCurrentUrl(), Strings.ODLOMAK_ZIVOTINJSKA_FARMA);

        }finally {
            driver.quit();
        }
    }


}
