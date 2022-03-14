package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.Strings;

public class SocialNetworkTest extends BaseTest {

    //1.

    /**
     *Test for opening facebook page of laguna in other tab
     *
     * Test steps:
     *
     * 1.Navigate to : https://www.laguna.rs/
     * 2.In right corner in header click on facebook icon
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on https://www.facebook.com/LagunaKnjige/
     */

    @Test

    public void redirectToFacebook(){
        driver = openChromeDriver();
        print("Test for opening facebook page of laguna in other tab");
        try {
            print("1.Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2.In right corner in header click on facebook icon");
            basePage.clickOnFacebookIcon();

            basePage.waitForNewUrl(Strings.FACEBOOK_PAGE);
            //assert 2.1 Confirm that you are on https://www.facebook.com/LagunaKnjige/
            assertUrl(driver.getCurrentUrl(), Strings.FACEBOOK_PAGE);

        }finally {
            driver.quit();
        }
    }


    //2.

    /**
     *Test for opening twitter page of laguna in other tab
     *
     * Test steps:
     *
     * 1.Navigate to : https://www.laguna.rs/
     * 2.In right corner in header click on twitter icon
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on https://twitter.com/IPLaguna
     */

    @Test

    public void redirectToTwitter(){
        driver = openChromeDriver();
        print("Test for opening twitter page of laguna in other tab");
        try {
            print("1.Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2.In right corner in header click on twitter icon");
            basePage.clickOnTwitterIcon();

            basePage.waitForNewUrl(Strings.TWITTER_PAGE);
            //assert 2.1 Confirm that you are on https://twitter.com/IPLaguna
            assertUrl(driver.getCurrentUrl(), Strings.TWITTER_PAGE);

        }finally {
            driver.quit();
        }
    }

    //3.

    /**
     *Test for opening instagram page of laguna in other tab
     *
     * Test steps:
     *
     * 1.Navigate to : https://www.laguna.rs/
     * 2.In right corner in header click on instagram icon
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on https://www.instagram.com/laguna_knjige/
     */

    @Test

    public void redirectToInstagram(){
        driver = openChromeDriver();
        print("Test for opening instagram page of laguna in other tab");
        try {
            print("1.Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2.In right corner in header click on instagram icon");
            basePage.clickOnInstagramIcon();

            basePage.waitForNewUrl(Strings.INSTAGRAM_PAGE);
            //assert 2.1 Confirm that you are on https://www.instagram.com/laguna_knjige/
            assertUrl(driver.getCurrentUrl(), Strings.INSTAGRAM_PAGE);

        }finally {
            driver.quit();
        }
    }

    //4.

    /**
     *Test for opening youtube page of laguna in other tab
     *
     * Test steps:
     *
     * 1.Navigate to : https://www.laguna.rs/
     * 2.In right corner in header click on youtube icon
     *
     * Expected results:
     *
     * 2.1 Confirm that you are on https://www.youtube.com/user/lagunaknjige";
     */

    @Test

    public void redirectToYoutube(){
        driver = openChromeDriver();
        print("Test for opening youtube page of laguna in other tab");
        try {
            print("1.Navigate to : https://www.laguna.rs/");
            BasePage basePage = new BasePage(driver);

            print("2.In right corner in header click on youtube icon");
            basePage.clickOnYoutubeIcon();

            basePage.waitForNewUrl(Strings.YOUTUBE_PAGE);
            //assert 2.1 Confirm that you are on https://www.youtube.com/user/lagunaknjige";
            assertUrl(driver.getCurrentUrl(), Strings.FACEBOOK_PAGE);


        }finally {
            //driver.quit();
        }
    }

}
