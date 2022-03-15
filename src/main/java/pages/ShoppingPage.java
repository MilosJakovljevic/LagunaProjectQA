package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingPage extends BasePage {

    WebDriver driver = null;

    @FindBy(xpath = "//a[contains(text(),'1. Sadržaj korpe')]")
    WebElement sadrzajKorpe;

    @FindBy(xpath = "//a[contains(text(),'U ŽELJE')]")
    WebElement uZeljeButton;

    @FindBy(xpath = "//a[@class='dugme']")
    WebElement pocetnaButtonShoppingPage;

    @FindBy(xpath = "//a[contains(text(),'Dalje')]")
    WebElement daljeButton;

    @FindBy(xpath = "//a[contains(text(),'2. Lični podaci')]")
    WebElement licniPodaciShoppingPage;

    @FindBy(id = "mesto-k-select-selectized")
    WebElement postCodeAndPlaceOfLiving;

    @FindBy(xpath = "//a[contains(text(),'3. Način plaćanja')]")
    WebElement nacinPlacanjaShoppingPage;

    @FindBy(xpath = "//div[@class='item'][contains(text(),'18330 Babušnica')]")
    WebElement babusnicaSelected;

    @FindBy(xpath = "//div[contains(text(),'na kućnu adresu')]")
    WebElement placanjePouzecemButton;

    @FindBy(xpath = "//a[contains(text(),'4. Potvrda kupovine')]")
    WebElement potvrdaKupovineShoppingPage;

    @FindBy(xpath = "//a[@class='dugme dugme-crveno']")
    WebElement kupovinaButton;

    @FindBy(xpath = "//a[contains(text(),'Kandže')]")
    WebElement kandzeUKorpi;

    @FindBy(xpath = "//label[@for='zeliclan']")
    WebElement zelimClan;

    @FindBy(id = "ime-k")
    WebElement imeIprezimeFillForm;

    @FindBy(id = "telefon-k")
    WebElement telefonFillForm;

    @FindBy(id = "email-k")
    WebElement eMailFillForm;

    @FindBy(id = "ulica-pomoc")
    WebElement ulicaFillForm;

    @FindBy(id = "broj-k")
    WebElement brojUliceFillForm;

    @FindBy(id = "broj-stana-k")
    WebElement brojStanaFillForm;

    @FindBy(xpath = "//select[@class='day']")
    WebElement selectDay;

    @FindBy(xpath = "//select[@class='month']")
    WebElement selectMonth;

    @FindBy(xpath = "//select[@class='year']")
    WebElement selectYear;


    //Method for static dropdown

    public void selectDateDropdown(String whichDay,String whichMonth,String whichYear){
        Select day = new Select(selectDay);
        day.selectByVisibleText(whichDay);

        Select month = new Select(selectMonth);
        month.selectByVisibleText(whichMonth);

        Select year = new Select(selectYear);
        year.selectByVisibleText(whichYear);
    }

    public void fillForm(){
        imeIprezimeFillForm.sendKeys("Slavko Stimac");
        telefonFillForm.sendKeys("333444");
        eMailFillForm.sendKeys("slavkostimac@mail.com");
        ulicaFillForm.sendKeys("Brestova");
        brojUliceFillForm.sendKeys("666");
        brojStanaFillForm.sendKeys("357");
    }


    public void isKupovinaButtonDisplayed(){
        log.info("Is kupovina button displayed : ");
        isElementPresent(kupovinaButton);
    }

    public void isKandzeUKorpiDisplayed(){
        log.info("Is Kandze u korpi displayed :");
        isElementPresent(kandzeUKorpi);
    }

    public void clickOnZelimClan(){
        zelimClan.click();
    }

    public void isPotvrdaKupovineDisplayed(){
        log.info("Is potvrda kupovine displayed : ");
        isElementPresent(potvrdaKupovineShoppingPage);
    }

    public void clickOnPlacanjePouzecemButton(){
        placanjePouzecemButton.click();
    }

    public void isNacinPlacanjaDisplayed(){
        log.info("Is nacin placanja displayed : ");
        isElementPresent(nacinPlacanjaShoppingPage);
    }

    public void clickAndTypePostCode(){
        postCodeAndPlaceOfLiving.click();
        postCodeAndPlaceOfLiving.sendKeys("18330");
        postCodeAndPlaceOfLiving.sendKeys(Keys.RETURN);
        log.info("Selected post code is : ");
        log.info(babusnicaSelected.getText());
    }

    public void isLicniPodaciDisplayed(){
        log.info("Is licni podaci displayed : ");
        isElementPresent(licniPodaciShoppingPage);
    }

    public void clickDaljeButton(){
        daljeButton.click();
    }

    public void isSadrzajKorpeDisplayed(){
        log.info("Is sadrzaj korpe displayed : ");
        isElementPresent(sadrzajKorpe);
    }

    public void isPocetnaButtonShoppingPageDisplayed(){
        sleep();
        log.info("Is Pocetna button displayed : ");
        isElementPresent(pocetnaButtonShoppingPage);
    }

    public void clickUZeljeButton(){
        uZeljeButton.click();
    }

    public ShoppingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
