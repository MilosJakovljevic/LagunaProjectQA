package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver = null;

    @FindBy(id = "broj-f")
    WebElement eMailField;

    @FindBy(id = "lozinka-f")
    WebElement passwordField;

    @FindBy(id = "form-prijava-s")
    WebElement prijavaButtonLoginPage;

    @FindBy(xpath = "//a[contains(text(),'zaboravljena lozinka?')]")
    WebElement zaboravljenaLozinkaButton;

    @FindBy(xpath = "//h1[contains(text(),'Prijava')]")
    WebElement prijavaNaslov;

    @FindBy(xpath = "//a[contains(text(),'Odjava')]")
    WebElement odjavaButton;

    @FindBy(xpath = "//a[@href='profil_clana.html']")
    WebElement profileName;

    @FindBy(xpath = "//span[contains(text(),'Pogrešni podaci za prijavu, Molimo Vas pokušajte ponovo!')]")
    WebElement errorLoginMessage;

    @FindBy (xpath = "//li[contains(text(),'Polje je obavezno')]")
    WebElement poljeJeObaveznoError;







    //Method for entering valid email and valid password

    public void validEmailAndValidPassword(){
        eMailField.sendKeys(Strings.VALID_EMAIL);
        passwordField.sendKeys(Strings.VALID_PASSWORD);
    }

    //Method for entering valid email and invalid password

    public void validEmailAndinvalidPassword(){
        eMailField.sendKeys(Strings.VALID_EMAIL);
        passwordField.sendKeys(Strings.INVALID_PASSWORD);
    }

    public void typeValidMail(){
        eMailField.sendKeys(Strings.VALID_EMAIL);
    }



    public void clickOnPrijavaButtonLoginPage(){
        prijavaButtonLoginPage.click();
    }

    public void loginWithValidCreddentialsWithAsserts(){
        clickOnPrijavaButtonMainPage();
        log.info("Is Prijava naslov displayed : ");
        isElementPresent(prijavaNaslov);
        validEmailAndValidPassword();
        clickOnPrijavaButtonLoginPage();
        log.info("Is Odjava button displayed : ");
        isElementPresent(odjavaButton);
    }


    public void isOdjavaButtonDisplayed() {
        log.info("Is odjava button displayed : ");
        assert isElementPresent(odjavaButton) : "ERROR. Element is not present";
    }


    public void isProfileNameDisplayed() {
        log.info("Is profile name displayed : ");
        assert isElementPresent(profileName) : "ERROR. Element is not present";
    }

    public void isErrorMessageForBadLoginDisplayed() {
        log.info("Is error message for bad login displayed : ");
        assert isElementPresent(errorLoginMessage) : "ERROR. Element is not present";
    }

    public void isErrorMessageForNoPasswordDisplayed() {
        log.info("Is error message for no password displayed : ");
        assert isElementPresent(poljeJeObaveznoError) : "ERROR. Element is not present";
    }




    public LoginPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }



}
