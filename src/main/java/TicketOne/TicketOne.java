package TicketOne;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.Test;

public class TicketOne {
    //TC: Verify Page Title

    //Test One
    @Test
    public void verifyPageTitle() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/norralak");
        String actTitle = driver.getTitle();
        String expTitle = "Norralak (Norralak Sukaram) · GitHub";
        Assert.assertEquals(actTitle, expTitle, "This Message Prints Upon Failure"); //If assertion fails, the next lines of code will not run
        driver.quit(); //close() only closes the driver while quit() closes all web windows opened through automation (i.e popups etc) ONLY within the scope of given WebDriver
        /**
         * Results will be
         * java.lang.AssertionError: This Message Prints Upon Failure
         * Expected :Norralak (Norralak Sukaram) · GitHub
         * Actual   :norralak (Norralak Sukaram) · GitHub
         */
    }
    //Test Two
    @Test
    public void verifyURL() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String expURL = "https://github.com/norralak";
        driver.get(expURL);
        String actURL = driver.getCurrentUrl();
        Assert.assertEquals(actURL, expURL, "Invalid URL"); //Assertion passes so the next line runs
        driver.quit(); //Will not close the previous test case webpage
    }
    //Test Three
    @Test
    public void verifyBackForwardFunctionality() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String prevURL = "https://github.com/norralak";
        String nextURL = "https://github.com/norralak/Repo_Selenium/tree/main/src/main";
        driver.get(prevURL);
        try {
            Thread.sleep(13000); //Used to pause parameter is milliseconds paused for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(nextURL);
        try {
            Thread.sleep(13000); //Used to pause parameter is milliseconds paused for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back(); //Go backwards
        try {
            Thread.sleep(13000); //Used to pause parameter is milliseconds paused for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().forward(); //Go forward
        try {
            Thread.sleep(13000); //Used to pause parameter is milliseconds paused for
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
