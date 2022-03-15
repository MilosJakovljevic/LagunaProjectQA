package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {

    WebDriver driver = null;

    @FindBy(xpath = "//div[@class='korica']")
    WebElement bookCover;

    @FindBy(xpath = "//div[@class='modal-body']")
    WebElement enlargedCover;

    @FindBy(className = "close")
    WebElement xButtonOnEnlargedCover;

    @FindBy(id = "podaci-korica")
    WebElement bookData;

    @FindBy(id = "odlomak")
    WebElement odlomakButton;

    @FindBy(id = "dugme-korpa")
    WebElement dodajUKorpuButton;

    @FindBy(id = "dugme-zelje")
    WebElement dodajNaListuZeljaButton;

    @FindBy(id = "uspesan_login")
    WebElement uspesnoDodatoNaListuZelja;

    @FindBy(id = "uspesan_login")
    WebElement uspesnoDodatoUKorpu;

    @FindBy(id = "dugme-kako-da-kupim")
    WebElement kakoDaKupimKnjiguButton;


    //Constructor

    public BooksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDodajNaListuZelja(){
        dodajNaListuZeljaButton.click();
    }

    public void clickDodajUKorpu(){
        dodajUKorpuButton.click();
    }

    public void uspesnoDodatoNaListuZeljaMessage(){
        log.info("Is uspesno dodato na listu zelja displayed : ");
        sleep();
        isElementPresent(uspesnoDodatoNaListuZelja);
    }

    public void uspesnoDodatoUKorpuMessage(){
        log.info("Is uspesno dodato u korpu displayed : ");
        sleep();
        isElementPresent(uspesnoDodatoUKorpu);
    }

    public void clickOnCoverOfTheBookToSeeLargerCover(){
        bookCover.click();
        isElementPresent(enlargedCover);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",xButtonOnEnlargedCover);
    }

    public void assertThatYouAreOnBookPage(){
        log.info("Assert that you are on book page : ");
        log.info("Is book cover displayed : ");
        isElementPresent(bookCover);
        log.info("Is dodaj u korpu button displayed : ");
        isElementPresent(dodajUKorpuButton);
        log.info("Is kako da kupim knjigu button displayed : ");
        isElementPresent(kakoDaKupimKnjiguButton);
        log.info("Is dodaj na listu zelja button displayed : ");
        isElementPresent(dodajNaListuZeljaButton);
    }

    public void isBookDataDisplayed(){
        log.info("Is book data displayed : ");
        isElementPresent(bookData);
    }

    public void clickOnOdlomakButton(){
        odlomakButton.click();
        List<String> tabs=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }


}
