package tests;



import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.Strings;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {


    WebDriver driver = null;

    public static Logger log = LogManager.getLogger();

    //Base browser opener with home page

    public WebDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Strings.HOME_PAGE_URL);
        return driver;

    }

    //Method for easy printing:

    public void print (String text){
        System.out.println(text);
    }

    //Method for asserting url

    public void assertUrl(String actualUrl, String expectedUrl) {
        log.info("assertUrl (" + actualUrl + " , " + expectedUrl + " )");
       assert actualUrl.equals(expectedUrl) : "Wrong URL. Expected: " + expectedUrl + " . Actual: " + actualUrl;
    }

    //Method for failure screenshot

    @AfterMethod
    public void testFailureScreenshot(ITestResult result) throws IOException {
        DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        if(ITestResult.FAILURE==result.getStatus()){
            String path = "C:\\Users\\Malac\\Desktop\\LagunaProjectQA\\screenshots\\" +currentTime.format(now)+ ".png";
            TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);

            File SrcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(path);
            FileUtils.copyFile(SrcFile, DestFile);
        }
        driver.quit();
    }



}
