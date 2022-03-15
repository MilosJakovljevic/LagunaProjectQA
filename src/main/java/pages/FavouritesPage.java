package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavouritesPage extends BasePage {

    WebDriver driver = null;

    @FindBy(xpath = "//h1[@class='naslov-font2']")
    WebElement listaZeljaNaslov;

    @FindBy(xpath = "//a[@class='dugme dugme-prebaci']")
    WebElement uKorpuButton;

    @FindBy(xpath = "//a[contains(text(),'Početna')]")
    WebElement pocetnaButtonFavouritesPage;

    @FindBy(xpath = "//a[contains(text(),'Brisanje')]")
    WebElement brisanjeButton;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement oKBrisanjeButton;

    @FindBy(id = "korpa-zelje")
    WebElement listaZeljaSpisak;

    @FindBy(xpath = "//div[contains(text(),'Lista želja je prazna.')]")
    WebElement listaZeljaJePraznaNaslov;

    @FindBy(xpath = "//a[@class='naslov']")
    WebElement majstorIMargaritaInFavourites;


    public FavouritesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isMajstorIMargaritaInFavouritesDisplayed(){
        log.info("Is Majstor i Margarita displayed : ");
        isElementPresent(majstorIMargaritaInFavourites);
    }

    public void clickOnOkBrisanjeButton(){
            oKBrisanjeButton.click();
    }


    public void isListaZeljaNaslovDisplayed(){
        log.info("Is lista zelja naslov displayed : ");
        isElementPresent(listaZeljaNaslov);
    }

    public void clickOnBrisanjeButton(){
        sleep();
        brisanjeButton.click();
    }

    public void clickOnUKorpuButton(){
        uKorpuButton.click();
    }

    public void isPocetnaButtonFavouritesPageDisplayed(){
        sleep();
        log.info("Is Pocetna button displayed : ");
        isElementPresent(pocetnaButtonFavouritesPage);
    }



}
