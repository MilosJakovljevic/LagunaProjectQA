package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WritersPage extends BasePage {

    WebDriver driver = null;

    @FindBy(id = "autor-foto")
    WebElement authorPhoto;

    @FindBy(xpath = "//div[@style='text-align: justify;']")
    WebElement authorBiography;

    @FindBy(id = "spisak-knjiga-knjige")
    WebElement listOfAuthorBooks;




    //Constructor

    public WritersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isAuthorPhotoDisplayed(){
        BasePage basePage = new BasePage();
        log.info("Is author photo displayed : ");
        assert isElementPresent(authorPhoto) : "ERROR. Element is not present";
    }

    public void isAuthorBiographyDisplayed(){
        BasePage basePage = new BasePage();
        log.info("Is author biography displayed : ");
        assert isElementPresent(authorBiography) : "ERROR. Element is not present";
    }

    public void isListOfAuthorBooksDisplayed(){
        BasePage basePage = new BasePage();
        log.info("Is list of author books displayed : ");
        assert isElementPresent(listOfAuthorBooks) : "ERROR. Element is not present";
    }


}
