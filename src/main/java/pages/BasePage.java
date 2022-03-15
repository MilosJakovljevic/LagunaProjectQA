package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    WebDriver driver = null;

    public static Logger log = LogManager.getLogger();

    //Web elements:

    @FindBy(xpath = "//a[contains(text(),'SLAŽEM SE')]")
    WebElement acceptCookies;

    @FindBy(xpath = "//img[contains(@src,'logo-laguna-2019.png')]")
    WebElement homePageLogoButton;

    @FindBy(id = "pretraga_rec")
    WebElement searchBarInputText;

    @FindBy(id = "pretraga_submit")
    WebElement searchBarSubmit;

    @FindBy(xpath = "//a[contains(text(),'Prijava')]")
    WebElement prijavaButtonMainPage;

    @FindBy(xpath = "//a[contains(text(),'Pomoć')]")
    WebElement pomocButton;

    @FindBy(id = "zelje_broj")
    WebElement favouritesButton;

    @FindBy(id = "korpa_broj")
    WebElement cartButton;

    @FindBy(xpath = "//li[@class='no-mobile']//a[contains(text(),'Naslovna')]")
    WebElement naslovnaButton;

    @FindBy(xpath = "//li[@class='mobile']//a[contains(text(),'Knjige')]")
    WebElement knjigeButton;

    @FindBy(xpath = "//li[@class='mobile']//a[contains(text(),'U pripremi')]")
    WebElement uPripremiButton;

    @FindBy(xpath = "//li[@class='no-mobile']//a[contains(text(),'Top-liste')]")
    WebElement topListeButton;

    @FindBy(xpath = "//li[@class='no-mobile']//a[contains(text(),'Mala Laguna')]")
    WebElement malaLagunaButton;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/laguna.knjige']")
    WebElement facebookButton;

    @FindBy(xpath = "//a[@href='http://twitter.com/IPLaguna']")
    WebElement twitterButton;

    @FindBy(xpath = "//a[@href='https://www.instagram.com/laguna_knjige/']")
    WebElement instagramButton;

    @FindBy(xpath = "//a[@href='https://www.youtube.com/user/lagunaknjige']")
    WebElement youTubeButton;

    @FindBy(xpath = "//span[contains(text(),'Minimalan broj slova za pretragu je 2.')]")
    WebElement errorSearchMessage;

    @FindBy(id = "suggestions")
    WebElement suggestionsMenu;

    @FindBy(xpath = "//h2[@class='lista_podaci_naslov']")
    WebElement dropdownMenuWriter;

    @FindBy(xpath = "//img[@title='Majstor i Margarita']")
    WebElement majstorIMargaritaBook;

    @FindBy(xpath = "//a[@title='Točak vremena']")
    WebElement tocakVremenaDropdown;


    //Constructor

    public BasePage(){}

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        clickOnAcceptCookiesButton();
    }

    // Method for clearing cookies on the browser

    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    //Method for accepting cookies :

    public void clickOnAcceptCookiesButton(){
        waitForElement(acceptCookies);
        acceptCookies.click();
    }

    public void searchBarSendKeys(String text){
        searchBarInputText.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchBarSubmit.click();
    }

    public void clickOnFavouritesButton(){
        favouritesButton.click();
    }

    //Method for click on prijava button

    public void clickOnPrijavaButtonMainPage(){
        prijavaButtonMainPage.click();
    }

    //Method is element present

    public boolean isElementPresent (WebElement element){
        try {
            log.info("Element is present");
            boolean isPresent = element.isDisplayed();
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            log.warn("Element is not present");
            return false;
        }
    }

    //Method for switching on new tab

    public void switchOnNewTab(){
        List <String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void clickOnFacebookIcon(){
        facebookButton.click();
        switchOnNewTab();
    }

    public void clickOnTwitterIcon(){
        twitterButton.click();
        switchOnNewTab();
    }


    public void clickOnInstagramIcon(){
        instagramButton.click();
        switchOnNewTab();
    }

    public void clickOnYoutubeIcon(){
        youTubeButton.click();
        switchOnNewTab();
    }

    public void isErrorMessageForSearchDisplayed(){
        log.info("Is error message for search displayed : ");
        assert isElementPresent(errorSearchMessage) : "ERROR. Element is not present";
    }

    public void isSuggestionsMenuFromSearhBarDisplayed(){
        waitForElement(suggestionsMenu);
        log.info("Is suggestions menu displayed : ");
        assert isElementPresent(suggestionsMenu) : "ERROR. Element is not present";
    }

    public void clickOnWriter(){
        sleep();
        dropdownMenuWriter.click();
    }

    public void clickOnTocakVremenaDropdown(){
        sleep();
        tocakVremenaDropdown.click();
    }

    public void clickOnMajstorIMargarita(){
        sleep();
        majstorIMargaritaBook.click();
    }

    //Method for grabbing number from favourites icon

    public String getNumberFromFavouritesIcon(){
        String number = favouritesButton.getText();
        return number;
    }

    //Method for grabbing number from shopping cart

    public String getNumberFromShopingIcon(){
        String number = cartButton.getText();
        return number;
    }

    public void clickOnShoppingCartButton(){
        cartButton.click();
    }

    //Method for deleting everything from cart

    public void atTheEndOfTestDeleteAllFromCartWhileLoop() {
        clickOnShoppingCartButton();
        try {
            while (true) {
                FavouritesPage favouritesPage = new FavouritesPage(driver);
                favouritesPage.clickOnBrisanjeButton();
                favouritesPage.clickOnOkBrisanjeButton();
            }
        } catch (NoSuchElementException exception) {
            driver.quit();
        }

    }

    //Method for easy printing:

    public void print (String text){
        System.out.println(text);
    }

    //Method for explicit wait:

    public void waitForElement (WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForNewUrl (String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    //Method for Thread.sleep:

    public void sleep(){
        try {
            Thread.sleep(1300);
        }
        catch (Exception e){
            print(e.getMessage());
        }
    }


}
