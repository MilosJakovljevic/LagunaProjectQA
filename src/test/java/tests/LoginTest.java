package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.Strings;

public class LoginTest extends BaseTest {

    //1.

    /**
     * Login test with valid email and valid password
     *
     * Test steps:
     *
     * 1.Navigate to : https://www.laguna.rs/
     * 2.In the right corner in header click on Prijava button
     * 3.Enter valid email and valid password
     * 4.Click on PRIJAVA button under password field
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on : https://www.laguna.rs/prijava.html
     * 4.Confirm that you are logged in :
     * 4.1 Odjava button in right corner in header is present
     * 4.2 Miloš Jakovljević name in right corner in header is present
     */

    @Test

    public void loginTestWithValidCredentials(){
        driver = openChromeDriver();
        log.info("Login test with valid email and valid password");
        try {
            log.info("1.Navigate to https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2.In the right corner in header click on Prijava button");
            basePage.clickOnPrijavaButtonMainPage();
            Reporter.log("2.1 Confirm that you are on : https://www.laguna.rs/prijava.html",true);
            assertUrl(driver.getCurrentUrl() , Strings.LOGIN_PAGE_URL);

            log.info("3.Enter valid email and valid password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.validEmailAndValidPassword();

            log.info("4.Click on PRIJAVA button under password field");
            loginPage.clickOnPrijavaButtonLoginPage();
            Reporter.log("assert 4.1 Odjava button in right corner in header is present",true);
            loginPage.isOdjavaButtonDisplayed();
            Reporter.log("assert 4.2 Miloš Jakovljević name in right corner in header is present",true);
            loginPage.isProfileNameDisplayed();

        }finally {
            driver.quit();
        }
    }

    //2.

    /**
     * Login test with valid email and invalid password
     *
     * Test steps:
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In the right corner in header click on Prijava button
     * 3. Enter valid email and invalid password
     * 4. Click on PRIJAVA button under password field
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on : https://www.laguna.rs/prijava.html
     * 4.1 Confirm that you are not logged in and message is displayed :
     *     Pogrešni podaci za prijavu, Molimo Vas pokušajte ponovo
     */

    @Test

    public void loginTestWithValidEMailAndInvalidPassword(){
        driver = openChromeDriver();
        log.info("Login test with valid email and invalid password");
        try {
            log.info("1.Navigate to https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2.In the right corner in header click on Prijava button");
            basePage.clickOnPrijavaButtonMainPage();
            Reporter.log("assert 2.1 https://www.laguna.rs/prijava.html is correct url",true);
            assertUrl(driver.getCurrentUrl() , Strings.LOGIN_PAGE_URL);

            log.info("3.Enter valid email and invalid password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.validEmailAndinvalidPassword();

            log.info("4.Click on PRIJAVA button under password field");
            loginPage.clickOnPrijavaButtonLoginPage();
            Reporter.log("assert 4.1 This message is displayed : Pogrešni podaci za prijavu, Molimo Vas pokušajte ponovo",true);
            loginPage.isErrorMessageForBadLoginDisplayed();

        }finally {
            driver.quit();
        }
    }

    //3.

    /**
     * Login test with valid email and no password input
     *
     * Test steps:
     *
     * 1. Navigate to : https://www.laguna.rs/
     * 2. In the right corner in header click on Prijava button
     * 3. Enter valid email and do not type any password
     * 4. Click on PRIJAVA button under password field
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on : https://www.laguna.rs/prijava.html
     * 4.1 Confirm that you are not logged in by error under password field : Polje je obavezno
     */

    @Test

    public void loginTestWithValidEMailAndNoPassword(){
        driver = openChromeDriver();
        log.info("Login test with valid email and no password input");
        try {
            log.info("1.Navigate to https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            log.info("2.In the right corner in header click on Prijava button");
            basePage.clickOnPrijavaButtonMainPage();
            Reporter.log("assert 2.1 https://www.laguna.rs/prijava.html is correct url",true);
            assertUrl(driver.getCurrentUrl() , Strings.LOGIN_PAGE_URL);

            log.info("3.Enter valid email and do not type any password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.typeValidMail();

            log.info("4.Click on PRIJAVA button under password field");
            loginPage.clickOnPrijavaButtonLoginPage();
            Reporter.log("Assert 4.1 Under password field is message : Polje je obavezno",true);
            loginPage.isErrorMessageForNoPasswordDisplayed();

        }finally {
            driver.quit();
        }
    }


}
