package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.*;

public class ShoppingTest extends BaseTest {

    //1.

    /**
     * Add book to favourites and then from favourites page add it to shopping cart and
     * then from shopping page add it back to favourites and then delete book from favourites page
     *
     * Test steps :
     *
     * 1. Navigate to https://www.laguna.rs/ and login with valid creddentials
     * 2. In search field type name of a book (Majstor i Margarita) and click on that book in dropdown menu
     * 3. On the page of the book click on button : DODAJ NA LISTU ZELJA (in the right part of the screen)
     * 4. Now go to favourites page by clicking favourites button in right header
     * 5. Click on button : U korpu (in the right part of the screen)
     * 6. Now go to shopping page by clicking shopping cart button in right header
     * 7. Click on button : U zelje (in the right part of the screen)
     * 8. Now go to favourites page by clicking favourites button in right header
     * 9. Delete book by clicking on button : Brisanje , and after that click on Ok button in modal
     *
     * Expected results :
     *
     * 1.1  Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
     * 2.1 Assert that dropdown menu is present
     * 2.2 Assert that you are on book page
     * 3.1 Assert that message for succesfull adding to favourites is present
     * 3.2 Assert that number on favourites icon is 1
     * 4.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html
     * 4.2 Assert that naslov : Lista zelja is displayed
     * 5.1 Assert that button : POCETNA is displayed
     * 5.2 Assert that number on shopping cart icon is 1
     * 5.3 Assert that number on favourites icon is 0
     * 6.1 Assert that you are on : https://www.laguna.rs/spisak_korpa.html
     * 6.2 Assert that first part of ordering is displayed (1. Sadrzaj korpe)
     * 7.1 Assert that naslov : Korpa je prazna is displayed
     * 7.2 Assert that number on shopping cart icon is 0
     * 7.3 Assert that number on favourites icon is 1
     * 8.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html
     * 8.2 Assert that Majstor i Margarita book is there
     * 9.1 Assert that button : POCETNA is displayed
     * 9.2 Assert that number on shopping cart icon is 0
     * 9.3 Assert that number on favourites icon is 0
     */

    @Test

    public void addBookToFavouritesThenToShoppingCartThanBackToFavouritesAndDeleteIt(){
        driver = openChromeDriver();
        log.info("Add book to favourites and then from favourites page add it to shopping cart and then from shopping page add it back to favourites and then delete book from favourites page");
        try {
            log.info("1. Navigate to https://www.laguna.rs/ and login with valid creddentials");
            LoginPage loginPage = new LoginPage(driver);
            Reporter.log("1.1 Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in",true);
            loginPage.loginWithValidCreddentialsWithAsserts();

            log.info("2. In search field type name of a book (Majstor i Margarita) and click on that book in dropdown menu");
            BasePage basePage = new BasePage(driver);
            basePage.searchBarSendKeys("Majstor i Margarita");
            Reporter.log("2.1 Assert that dropdown menu is present",true);
            basePage.isSuggestionsMenuFromSearhBarDisplayed();
            basePage.clickOnMajstorIMargarita();
            BooksPage booksPage = new BooksPage(driver);
            Reporter.log("2.2 Assert that you are on book page",true);
            booksPage.assertThatYouAreOnBookPage();

            log.info("3. On the page of the book click on button : DODAJ NA LISTU ZELJA (in the right part of the screen)");
            booksPage.clickDodajNaListuZelja();
            Reporter.log("3.1 Assert that message for succesfull adding to favourites is present",true);
            booksPage.uspesnoDodatoNaListuZeljaMessage();
            Reporter.log("3.2 Assert that number on favourites icon is 1",true);
            String currentNumberOnFavouritesIcon = basePage.getNumberFromFavouritesIcon();
            assert currentNumberOnFavouritesIcon.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnFavouritesIcon;

            log.info("4. Now go to favourites page by clicking favourites button in right header");
            basePage.clickOnFavouritesButton();
            Reporter.log("4.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.FAVOURITES_PAGE_URL);
            Reporter.log("4.2 Assert that naslov : Lista zelja is displayed",true);
            FavouritesPage favouritesPage = new FavouritesPage(driver);
            favouritesPage.isListaZeljaNaslovDisplayed();

            log.info("5. Click on button : U korpu (in the right part of the screen)");
            favouritesPage.clickOnUKorpuButton();
            Reporter.log("5.1 Assert that button : POCETNA is displayed",true);
            favouritesPage.isPocetnaButtonFavouritesPageDisplayed();
            Reporter.log("5.2 Assert that number on shopping cart icon is 1",true);
            String currentNumberOnShoppingCartIcon = basePage.getNumberFromShopingIcon();
            assert currentNumberOnShoppingCartIcon.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnShoppingCartIcon;
            Reporter.log("5.3 Assert that number on favourites icon is 0",true);
            String currentNumberOnFavouritesIconAfterMovingToCart = basePage.getNumberFromFavouritesIcon();
            assert currentNumberOnFavouritesIconAfterMovingToCart.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnFavouritesIconAfterMovingToCart;

            log.info("6. Now go to shopping page by clicking shopping cart button in right header");
            basePage.clickOnShoppingCartButton();
            Reporter.log("6.1 Assert that you are on : https://www.laguna.rs/spisak_korpa.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.SHOPPING_PAGE_URL);
            Reporter.log("6.2 Assert that first part of ordering is displayed (1. Sadrzaj korpe)",true);
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.isSadrzajKorpeDisplayed();

            log.info("7. Click on button : U zelje (in the right part of the screen)");
            shoppingPage.clickUZeljeButton();
            Reporter.log("7.1 Assert that naslov : Korpa je prazna is displayed",true);
            shoppingPage.isPocetnaButtonShoppingPageDisplayed();
            Reporter.log("7.2 Assert that number on shopping cart icon is 0",true);
            String numberOnShoppingIconAfterMovingToFavourites = basePage.getNumberFromShopingIcon();
            assert numberOnShoppingIconAfterMovingToFavourites.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + numberOnShoppingIconAfterMovingToFavourites;
            Reporter.log("7.3 Assert that number on favourites icon is 1",true);
            String numberOnFavouritesIconAfterMovingFromCart = basePage.getNumberFromFavouritesIcon();
            assert numberOnFavouritesIconAfterMovingFromCart.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + numberOnFavouritesIconAfterMovingFromCart;

            log.info("8. Now go to favourites page by clicking favourites button in right header");
            basePage.clickOnFavouritesButton();
            Reporter.log("8.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.FAVOURITES_PAGE_URL);
            Reporter.log("8.2 Assert that Majstor i Margarita book is there",true);
            favouritesPage.isMajstorIMargaritaInFavouritesDisplayed();

            log.info("9. Delete book by clicking on button : Brisanje , and after that click on Ok button in modal");
            favouritesPage.clickOnBrisanjeButton();
            favouritesPage.clickOnOkBrisanjeButton();
            Reporter.log("9.1 Assert that button : POCETNA is displayed",true);
            favouritesPage.isPocetnaButtonFavouritesPageDisplayed();
            Reporter.log("9.2 Assert that number on shopping cart icon is 0",true);
            String numberOnShoppingCartIconInTheEnd = basePage.getNumberFromShopingIcon();
            assert numberOnShoppingCartIconInTheEnd.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + numberOnShoppingCartIconInTheEnd;
            Reporter.log("9.3 Assert that number on favourites icon is 0",true);
            String numberOnFavouritesIconInTheEnd = basePage.getNumberFromFavouritesIcon();
            assert numberOnFavouritesIconInTheEnd.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + numberOnFavouritesIconInTheEnd;

        }finally {
            driver.quit();
        }
    }

    //2.

    /**
     * Order two books (all steps except the last one when you really order books)
     *
     * Test steps :
     *
     * 1. Navigate to https://www.laguna.rs/ and login with valid creddentials
     * 2. In the search field type : tocak vremena and click on result from dropdown menu
     * 3. Add to cart : Gospodar haosa - deo prvi, from first page , and : Veliki lov, from second page
     * 4. Now go to shopping cart
     * 5. Click on : DALJE button
     * 6. Select post number and place of living (18330 Babusnica) from dropdown menu and then click on : DALJE button
     * 7. Choose way of paying and delivery (first option) and then click on: DALJE button
     * 8. Agree with both terms and conditions above the KUPOVINA button
     *
     * Expected results :
     *
     * 1.1  Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
     * 2.1 Assert that dropdown menu is present
     * 3.1 Assert that you are on book page
     * 3.2 Assert that you are on second book page
     * 3.3 Assert that number on shopping cart icon is 2
     * 4.1 Assert that you are on shopping page
     * 4.2 Assert that both books are in the cart
     * 5.1 Assert that you are on : https://www.laguna.rs/kupovina_unos_podataka.html
     * 5.2 Assert that 2.Licni podaci is visible (in red box)
     * 6.1 Assert that you are on : https://www.laguna.rs/kupovina_odabir_placanja.html
     * 6.2 Assert that 3. Nacin placanja is visible (in red box)
     * 7.1 Assert that you are on : https://www.laguna.rs/kupovina_potvrda.html
     * 7.2 Assert that 4. Potvrda kupovine is visible (in red box)
     * 7.3 Assert that KUPOVINA button is displayed
     */

    @Test

    public void orderTwoBooks(){
        driver = openChromeDriver();
        log.info("Order two books (all steps except the last one when you really order books)");
        try {
            log.info("1. Navigate to https://www.laguna.rs/ and login with valid creddentials");
            LoginPage loginPage = new LoginPage(driver);
            Reporter.log("1.1 Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in",true);
            loginPage.loginWithValidCreddentialsWithAsserts();

            log.info("2. In the search field type : tocak vremena and click on result from dropdown menu");
            BasePage basePage = new BasePage(driver);
            basePage.searchBarSendKeys("tocak vremena");
            Reporter.log("2.1 Assert that dropdown menu is present",true);
            basePage.isSuggestionsMenuFromSearhBarDisplayed();
            basePage.clickOnTocakVremenaDropdown();
            Reporter.log("2.2 Assert that Tocak Vremena naslov is displayed",true);
            SearchPage searchPage = new SearchPage(driver);
            searchPage.isTocakVremenaNaslovDisplayed();

            log.info("3. Add to cart : Gospodar haosa - deo prvi, from first page , and : Veliki lov, from second page");
            searchPage.clickOnGospodarHaosa();
            Reporter.log("3.1 Assert that you are on first book page",true);
            BooksPage booksPage = new BooksPage(driver);
            booksPage.assertThatYouAreOnBookPage();
            //Add first book
            booksPage.clickDodajUKorpu();
            driver.navigate().back();
            searchPage.clickOnPageTwo();
            //Add second book
            searchPage.clickOnVelikiLov();
            Reporter.log("3.2 Assert that you are on second book page",true);
            booksPage.assertThatYouAreOnBookPage();
            assertUrl(driver.getCurrentUrl(), Strings.VELIKI_LOV_URL);
            booksPage.clickDodajUKorpu();
            Reporter.log("3.3 Assert that number on shopping cart icon is 2",true);
            String currentNumberOnShoppingCartIcon = basePage.getNumberFromShopingIcon();
            assert currentNumberOnShoppingCartIcon.equals("2") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnShoppingCartIcon;

            log.info("4. Now go to shopping cart");
            basePage.clickOnShoppingCartButton();
            Reporter.log("4.1 Assert that you are on shopping page",true);
            assertUrl(driver.getCurrentUrl(), Strings.SHOPPING_PAGE_URL);
            Reporter.log("4.2 Assert that both books are in the cart",true);
            searchPage.isGospodarHaosaDisplayed();
            searchPage.isVelikiLovDisplayed();

            log.info("5. Click on : DALJE button");
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.clickDaljeButton();
            Reporter.log("5.1 Assert that you are on : https://www.laguna.rs/kupovina_unos_podataka.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_UNOS_PODATAKA_URL);
            Reporter.log("5.2 Assert that 2. Licni podaci is visible (in red box)",true);
            shoppingPage.isLicniPodaciDisplayed();

            log.info("6. Select post number and place of living (18330 Babusnica) from dropdown menu and then click on : DALJE button");
            shoppingPage.clickAndTypePostCode();
            shoppingPage.clickDaljeButton();
            Reporter.log("6.1 Assert that you are on : https://www.laguna.rs/kupovina_odabir_placanja.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_ODABIR_PLACANJA_URL);
            Reporter.log("6.2 Assert that 3. Nacin placanja is visible (in red box)",true);
            shoppingPage.isNacinPlacanjaDisplayed();

            log.info("7. Choose way of paying and delivery (first option) and then click on : DALJE button");
            shoppingPage.clickOnPlacanjePouzecemButton();
            shoppingPage.clickDaljeButton();
            Reporter.log("7.1 Assert that you are on : https://www.laguna.rs/kupovina_potvrda.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_POTVRDA_URL);
            Reporter.log("7.2 Assert that 4. Potvrda kupovine is visible (in red box)",true);
            shoppingPage.isPotvrdaKupovineDisplayed();
            Reporter.log("7.3 Assert that KUPOVINA button is displayed",true);
            shoppingPage.isKupovinaButtonDisplayed();

            // While loop for deleting everything from cart at the end of test
            basePage.atTheEndOfTestDeleteAllFromCartWhileLoop();

        }finally {
            driver.quit();
        }
    }

    //3.

    /**
     * Fill form for becoming a member of Laguna
     *
     * Test steps :
     *
     * 1. Navigate to https://www.laguna.rs/ (don't log in)
     * 2. In search bar type name of the book (Kandze),click on search button,and then click on book from search page
     * 3. Add book to cart
     * 4. Go to shopping cart and click on DALJE button
     * 5. Check first option (Želim da postanem član kluba čitalaca)
     * 6. Fill in forms and click on DALJE button
     *
     * Expected results :
     *
     * 1.1 Assert that url is : https://www.laguna.rs/
     * 2.1 Assert that url is : https://www.laguna.rs/n3073_knjiga_kandze_laguna.html
     * 3.1 Assert that message : Uspesno dodato u korpu is displayed on top of the page
     * 4.1 Assert that book "Kandze" is in shopping page
     * 6.1 Assert that : 3. Nacin placanja is displayed (in red box)
     */

    @Test

    public void fillFormForBecomingAMemberOfLaguna(){
        driver = openChromeDriver();
        log.info("Fill form for becoming a member of Laguna");
        try {
            log.info("1. Navigate to https://www.laguna.rs/ (don't log in)");
            BasePage basePage = new BasePage(driver);
            Reporter.log(" 1.1 Assert that url is : https://www.laguna.rs/",true);
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);

            log.info("2. In search bar type name of the book (Kandze),click on search button,and then click on book from search page");
            basePage.searchBarSendKeys("kandze");
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickOnSearchButton();
            searchPage.clickOnKandzeSearchPage();
            Reporter.log("2.1 Assert that url is : https://www.laguna.rs/n3073_knjiga_kandze_laguna.html",true);
            assertUrl(driver.getCurrentUrl(), Strings.KANDZE_KNJIGA_URL);

            log.info("3. Add book to cart");
            BooksPage booksPage = new BooksPage(driver);
            booksPage.clickDodajUKorpu();
            Reporter.log("3.1 Assert that message : Uspesno dodato u korpu is displayed on top of the page",true);
            booksPage.uspesnoDodatoUKorpuMessage();

            log.info("4. Go to shopping cart and click on DALJE button");
            basePage.clickOnShoppingCartButton();
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.clickDaljeButton();
            Reporter.log("4.1 Assert that book \"Kandze\" is in shopping page",true);
            shoppingPage.isKandzeUKorpiDisplayed();

            log.info("5. Check first option (Želim da postanem član kluba čitalaca)");
            shoppingPage.clickOnZelimClan();

            log.info("6. Fill in forms and click on DALJE button");
            shoppingPage.fillForm();
            shoppingPage.clickAndTypePostCode();
            shoppingPage.selectDateDropdown("29","Oktobar","1991");
            shoppingPage.clickDaljeButton();
            Reporter.log("6.1 Assert that : 3. Nacin placanja is displayed (in red box)",true);
            shoppingPage.isNacinPlacanjaDisplayed();

        }finally {
            driver.quit();
        }
    }


}
