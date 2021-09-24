import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.Test;

public class TaskOne {
    //TC: Verify Page Title

    //Test One
    @Test
    public void verifyPageTitle() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com/norralak");
        String actTitle = driver.getTitle();
        driver.close();
        String expTitle = "Norralak (Norralak Sukaram) · GitHub";
        Assert.assertEquals(actTitle, expTitle, "This Message Prints Upon Failure");
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
        driver.close();
        Assert.assertEquals(actURL, expURL, "Invalid URL");
    }
}
