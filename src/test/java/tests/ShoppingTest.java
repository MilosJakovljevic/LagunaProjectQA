package tests;

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
     * 1.  Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
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

        try {
            print("1. Navigate to https://www.laguna.rs/ and login with valid creddentials");
            LoginPage loginPage = new LoginPage(driver);
            // 1. Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
            loginPage.loginWithValidCreddentialsWithAsserts();

            print("2. In search field type name of a book (Majstor i Margarita) and click on that book in dropdown menu");
            BasePage basePage = new BasePage(driver);
            basePage.searchBarSendKeys("Majstor i Margarita");
            // 2.1 Assert that dropdown menu is present
            basePage.isSuggestionsMenuFromSearhBarDisplayed();
            basePage.clickOnMajstorIMargarita();
            BooksPage booksPage = new BooksPage(driver);
            // 2.2 Assert that you are on book page
            booksPage.assertThatYouAreOnBookPage();

            print("3. On the page of the book click on button : DODAJ NA LISTU ZELJA (in the right part of the screen)");
            booksPage.clickDodajNaListuZelja();
            // 3.1 Assert that message for succesfull adding to favourites is present
            booksPage.uspesnoDodatoNaListuZeljaMessage();
            // 3.2 Assert that number on favourites icon is 1
            String currentNumberOnFavouritesIcon = basePage.getNumberFromFavouritesIcon();
            assert currentNumberOnFavouritesIcon.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnFavouritesIcon;

            print("4. Now go to favourites page by clicking favourites button in right header");
            basePage.clickOnFavouritesButton();
            // 4.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html
            assertUrl(driver.getCurrentUrl(), Strings.FAVOURITES_PAGE_URL);
            // 4.2 Assert that naslov : Lista zelja is displayed
            FavouritesPage favouritesPage = new FavouritesPage(driver);
            favouritesPage.isListaZeljaNaslovDisplayed();

            print("5. Click on button : U korpu (in the right part of the screen)");
            favouritesPage.clickOnUKorpuButton();
            // 5.1 Assert that button : POCETNA is displayed
            favouritesPage.isPocetnaButtonFavouritesPageDisplayed();
            // 5.2 Assert that number on shopping cart icon is 1
            String currentNumberOnShoppingCartIcon = basePage.getNumberFromShopingIcon();
            assert currentNumberOnShoppingCartIcon.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnShoppingCartIcon;
            // 5.3 Assert that number on favourites icon is 0
            String currentNumberOnFavouritesIconAfterMovingToCart = basePage.getNumberFromFavouritesIcon();
            assert currentNumberOnFavouritesIconAfterMovingToCart.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnFavouritesIconAfterMovingToCart;

            print("6. Now go to shopping page by clicking shopping cart button in right header");
            basePage.clickOnShoppingCartButton();
            // 6.1 Assert that you are on : https://www.laguna.rs/spisak_korpa.html
            assertUrl(driver.getCurrentUrl(), Strings.SHOPPING_PAGE_URL);
            // 6.2 Assert that first part of ordering is displayed (1. Sadrzaj korpe)
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.isSadrzajKorpeDisplayed();

            print("7. Click on button : U zelje (in the right part of the screen)");
            shoppingPage.clickUZeljeButton();
            // 7.1 Assert that naslov : Korpa je prazna is displayed
            shoppingPage.isPocetnaButtonShoppingPageDisplayed();
            // 7.2 Assert that number on shopping cart icon is 0
            String numberOnShoppingIconAfterMovingToFavourites = basePage.getNumberFromShopingIcon();
            assert numberOnShoppingIconAfterMovingToFavourites.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + numberOnShoppingIconAfterMovingToFavourites;
            // 7.3 Assert that number on favourites icon is 1
            String numberOnFavouritesIconAfterMovingFromCart = basePage.getNumberFromFavouritesIcon();
            assert numberOnFavouritesIconAfterMovingFromCart.equals("1") : "Wrong number of items. Expected : 1 . Actual: " + numberOnFavouritesIconAfterMovingFromCart;

            print("8. Now go to favourites page by clicking favourites button in right header");
            basePage.clickOnFavouritesButton();
            // 8.1 Assert that you are on : https://www.laguna.rs/spisak_zelja.html
            assertUrl(driver.getCurrentUrl(), Strings.FAVOURITES_PAGE_URL);
            // 8.2 Assert that Majstor i Margarita book is there
            favouritesPage.isMajstorIMargaritaInFavouritesDisplayed();

            print("9. Delete book by clicking on button : Brisanje , and after that click on Ok button in modal");
            favouritesPage.clickOnBrisanjeButton();
            favouritesPage.clickOnOkBrisanjeButton();
            // 9.1 Assert that button : POCETNA is displayed
            favouritesPage.isPocetnaButtonFavouritesPageDisplayed();
            // 9.2 Assert that number on shopping cart icon is 0
            String numberOnShoppingCartIconInTheEnd = basePage.getNumberFromShopingIcon();
            assert numberOnShoppingCartIconInTheEnd.equals("0") : "Wrong number of items. Expected : 1 . Actual: " + numberOnShoppingCartIconInTheEnd;
            // 9.3 Assert that number on favourites icon is 0
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
     * 1.  Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
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
        try {
            print("1. Navigate to https://www.laguna.rs/ and login with valid creddentials");
            LoginPage loginPage = new LoginPage(driver);
            // 1. Assert that Prijava naslov is displayed on LoginPage and assert that Odjava button is present after you are logged in
            loginPage.loginWithValidCreddentialsWithAsserts();

            print("2. In the search field type : tocak vremena and click on result from dropdown menu");
            BasePage basePage = new BasePage(driver);
            basePage.searchBarSendKeys("tocak vremena");
            // 2.1 Assert that dropdown menu is present
            basePage.isSuggestionsMenuFromSearhBarDisplayed();
            basePage.clickOnTocakVremenaDropdown();
            // 2.2 Assert that Tocak Vremena naslov is displayed
            SearchPage searchPage = new SearchPage(driver);
            searchPage.isTocakVremenaNaslovDisplayed();

            print("3. Add to cart : Gospodar haosa - deo prvi, from first page , and : Veliki lov, from second page");
            searchPage.clickOnGospodarHaosa();
            // 3.1 Assert that you are on first book page
            BooksPage booksPage = new BooksPage(driver);
            booksPage.assertThatYouAreOnBookPage();
            //Add first book
            booksPage.clickDodajUKorpu();
            driver.navigate().back();
            searchPage.clickOnPageTwo();
            //Add second book
            searchPage.clickOnVelikiLov();
            // 3.2 Assert that you are on second book page
            booksPage.assertThatYouAreOnBookPage();
            assertUrl(driver.getCurrentUrl(), Strings.VELIKI_LOV_URL);
            booksPage.clickDodajUKorpu();
            // 3.3 Assert that number on shopping cart icon is 2
            String currentNumberOnShoppingCartIcon = basePage.getNumberFromShopingIcon();
            assert currentNumberOnShoppingCartIcon.equals("2") : "Wrong number of items. Expected : 1 . Actual: " + currentNumberOnShoppingCartIcon;

            print("4. Now go to shopping cart");
            basePage.clickOnShoppingCartButton();
            // 4.1 Assert that you are on shopping page
            assertUrl(driver.getCurrentUrl(), Strings.SHOPPING_PAGE_URL);
            // 4.2 Assert that both books are in the cart
            searchPage.isGospodarHaosaDisplayed();
            searchPage.isVelikiLovDisplayed();

            print("5. Click on : DALJE button");
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.clickDaljeButton();
            // 5.1 Assert that you are on : https://www.laguna.rs/kupovina_unos_podataka.html
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_UNOS_PODATAKA_URL);
            // 5.2 Assert that 2. Licni podaci is visible (in red box)
            shoppingPage.isLicniPodaciDisplayed();

            print("6. Select post number and place of living (18330 Babusnica) from dropdown menu and then click on : DALJE button");
            shoppingPage.clickAndTypePostCode();
            shoppingPage.clickDaljeButton();
            // 6.1 Assert that you are on : https://www.laguna.rs/kupovina_odabir_placanja.html
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_ODABIR_PLACANJA_URL);
            // 6.2 Assert that 3. Nacin placanja is visible (in red box)
            shoppingPage.isNacinPlacanjaDisplayed();

            print("7. Choose way of paying and delivery (first option) and then click on : DALJE button");
            shoppingPage.clickOnPlacanjePouzecemButton();
            shoppingPage.clickDaljeButton();
            // 7.1 Assert that you are on : https://www.laguna.rs/kupovina_potvrda.html
            assertUrl(driver.getCurrentUrl(), Strings.KUPOVINA_POTVRDA_URL);
            // 7.2 Assert that 4. Potvrda kupovine is visible (in red box)
            shoppingPage.isPotvrdaKupovineDisplayed();
            // 7.3 Assert that KUPOVINA button is displayed
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
     * 1. Assert that url is : https://www.laguna.rs/
     * 2. Assert that url is : https://www.laguna.rs/n3073_knjiga_kandze_laguna.html
     * 3. Assert that message : Uspesno dodato u korpu is displayed on top of the page
     * 4. Assert that book "Kandze" is in shopping page
     * 6. Assert that : 3. Nacin placanja is displayed (in red box)
     */

    @Test

    public void fillFormForBecomingAMemberOfLaguna(){
        driver = openChromeDriver();
        try {
            print("1. Navigate to https://www.laguna.rs/ (don't log in)");
            BasePage basePage = new BasePage(driver);
            // 1. Assert that url is : https://www.laguna.rs/
            assertUrl(driver.getCurrentUrl(), Strings.HOME_PAGE_URL);

            print("2. In search bar type name of the book (Kandze),click on search button,and then click on book from search page");
            basePage.searchBarSendKeys("kandze");
            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickOnSearchButton();
            searchPage.clickOnKandzeSearchPage();
            // 2. Assert that url is : https://www.laguna.rs/n3073_knjiga_kandze_laguna.html
            assertUrl(driver.getCurrentUrl(), Strings.KANDZE_KNJIGA_URL);

            print("3. Add book to cart");
            BooksPage booksPage = new BooksPage(driver);
            booksPage.clickDodajUKorpu();
            // 3. Assert that message : Uspesno dodato u korpu is displayed on top of the page
            booksPage.uspesnoDodatoUKorpuMessage();

            print("4. Go to shopping cart and click on DALJE button");
            basePage.clickOnShoppingCartButton();
            ShoppingPage shoppingPage = new ShoppingPage(driver);
            shoppingPage.clickDaljeButton();
            // 4. Assert that book "Kandze" is in shopping page
            shoppingPage.isKandzeUKorpiDisplayed();

            print("5. Check first option (Želim da postanem član kluba čitalaca)");
            shoppingPage.clickOnZelimClan();

            print("6. Fill in forms and click on DALJE button");
            shoppingPage.fillForm();
            shoppingPage.clickAndTypePostCode();
            shoppingPage.selectDayDropdown("7");
            shoppingPage.selectMonthDropdown("Oktobar");
            shoppingPage.selectYearDropdown("1991");
            shoppingPage.clickDaljeButton();
            // 6. Assert that : 3. Nacin placanja is displayed (in red box)
            shoppingPage.isNacinPlacanjaDisplayed();

        }finally {
            driver.quit();
        }
    }


}
