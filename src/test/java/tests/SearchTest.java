package tests;
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
        print("Click on search button without typing anything in search bar");
        try {
            print("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2. In middle of header click on search button without typing anything in search bar");
            basePage.clickOnSearchButton();
            //assert 2.1 Confirm that you are on : https://www.laguna.rs/
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);
            //assert 2.2 Error message is displayed : Minimalan broj slova za pretragu je 2.
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
        print("Type one letter in search field and then click search button");
        try {
            print("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2. In middle of header in search field type one letter");
            basePage.searchBarSendKeys("a");
            print("3. Click search");
            basePage.clickOnSearchButton();
            //assert 3.1 Confirm that you are on : https://www.laguna.rs/
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);
            //assert 3.2 Error message is displayed : Minimalan broj slova za pretragu je 2.
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
        print("Type two letters in search field and then click search button");
        try {
            print("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2. In middle of header in search field type two letters");
            basePage.searchBarSendKeys("ma");
            print("3. Click search");
            basePage.clickOnSearchButton();
            //assert 3.1 In the middle of the page under header is displayed : Pretraga
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
        print("Search for a specific writer and inspect his page");
        try {
            print("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2. In middle of header in search field type : Robert Dzordan");
            basePage.searchBarSendKeys("Robert Dzordan");
            // 2.1 Assert that dropdown menu is present
            basePage.isSuggestionsMenuFromSearhBarDisplayed();

            print("3. In dropdown menu click on his name");
            basePage.clickOnWriter();
            // 3.1 Assert that current url is : https://www.laguna.rs/a37_autor_robert_dzordan_laguna.html
            assertUrl(driver.getCurrentUrl(), Strings.ROBERT_DZORDAN_URL);
            // 3.2 Assert that his image is displayed
            WritersPage writersPage = new WritersPage(driver);
            writersPage.isAuthorPhotoDisplayed();
            // 3.3 Assert that his biography is displayed
            writersPage.isAuthorBiographyDisplayed();
            // 3.4 Assert that his books are displayed
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
        print("Search for a specific book and inspect its page");
        try {
            print("1. Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2. In middle of header in search field, type : Zivotinjska farma");
            basePage.searchBarSendKeys("Zivotinjska farma");
            // 2.1 Assert that dropdown menu is present
            basePage.isSuggestionsMenuFromSearhBarDisplayed();

            print("3. Click on search button in header");
            basePage.clickOnSearchButton();
            // 3.1 Assert that current url is : https://www.laguna.rs/pretraga-laguna-zivotinjska-farma-str-1.html
            assertUrl(driver.getCurrentUrl(), Strings.ZIVOTINJSKA_FARMA_SEARCH_PAGE);

            print("4. Click on Zivotinjska farma in search results");
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickOnZivotinjskaFarmaOnSearchPage();
            // 4.1 Assert that current url is : https://www.laguna.rs/n5208_knjiga_zivotinjska_farma_laguna.html
            assertUrl(driver.getCurrentUrl(), Strings.ZIVOTINJSKA_FARMA_URL);
            /* 4.2 Assert that after you click on the cover of the book,
               larger cover will be displayed in the middle of the screen */
            BooksPage booksPage = new BooksPage(driver);
            booksPage.clickOnCoverOfTheBookToSeeLargerCover();
            // 4.3 Assert that data of this book is displayed (under social network share icons)
            booksPage.isBookDataDisplayed();
            /* 4.4 Assert that after you click on : ODLOMAK button (under the image of the book),
            you are redirected on a new tab,where the part of the book is displayed for example */
            booksPage.clickOnOdlomakButton();
            basePage.waitForNewUrl(Strings.ODLOMAK_ZIVOTINJSKA_FARMA);
            assertUrl(driver.getCurrentUrl(), Strings.ODLOMAK_ZIVOTINJSKA_FARMA);

        }finally {
            driver.quit();
        }
    }


}
