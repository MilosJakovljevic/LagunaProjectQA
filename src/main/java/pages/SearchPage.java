package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    WebDriver driver = null;

    @FindBy(xpath = "//div[contains(text(),'Pretraga')]")
    WebElement pretragaNaslovSearchPage;

    @FindBy(xpath = "//a[contains(text(),'Životinjska farma')]")
    WebElement zivotinjskaFarmaSearchPage;

    @FindBy(xpath = "//div[contains(text(),'Točak vremena')]")
    WebElement tocakVremenaSearchPage;

    @FindBy(xpath = "//a[contains(text(),'Gospodar haosa - deo prvi')]")
    WebElement gospodarHaosa;

    @FindBy(xpath = "//a[contains(text(),'2')]")
    WebElement pageTwo;

    @FindBy(xpath = "//a[contains(text(),'Veliki lov')]")
    WebElement velikiLov;

    @FindBy(xpath = "//img[@alt='kandže laguna knjige']")
    WebElement kandzeSearhPage;


    //Constructor

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnZivotinjskaFarmaOnSearchPage(){
        zivotinjskaFarmaSearchPage.click();
    }

    public void clickOnKandzeSearchPage(){
        kandzeSearhPage.click();
    }

    public void isPretragaDisplayedInSearchPage(){
        log.info("Is pretraga naslov displayed in search page : ");
        assert isElementPresent(pretragaNaslovSearchPage) : "ERROR. Element is not present";
    }

    public void isTocakVremenaNaslovDisplayed(){
        log.info("Is Tocak vremena naslov displayed : ");
        isElementPresent(tocakVremenaSearchPage);
    }

    public void clickOnGospodarHaosa(){
        gospodarHaosa.click();
    }

    public void isGospodarHaosaDisplayed(){
        log.info("Is Gospodar haosa displayed : ");
        isElementPresent(gospodarHaosa);
    }

    public void clickOnPageTwo(){
        pageTwo.click();
    }

    public void clickOnVelikiLov(){
        velikiLov.click();
    }

    public void isVelikiLovDisplayed(){
        log.info("Is Veliki lov displayed : ");
        isElementPresent(velikiLov);
    }


}
