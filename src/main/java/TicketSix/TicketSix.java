package TicketSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class TicketSix {
    //Auto-Suggest
    @Test
    public void autoSuggestion() {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com/");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.name("q-destination")).sendKeys("New");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // #2, 3
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[contains(@class, 'typeahead')]//span[not(@class)]"));


        String selectThis = "Newport Beach";
        // #4
        for (WebElement suggestion : suggestions) {
            String webText = suggestion.getText();
            if (webText.equalsIgnoreCase(selectThis)) {
                suggestion.click();
                break;
            }
        }


        /**
         * 1. Analyze if auto-suggestions are present in dom as text or attribute's value
         * 2. Create a locator that will point to all the auto-suggestion webElements
         * 3. using findElements method to find all auto-suggestion webElements
         * 4. using loop
         *      pick auto-suggestion webElement
         *      get text value (or attribute value) [depends on step#1]
         *      if (above value == what user want to select)
         *          click webElement
         *          and break the loop
         *
         */

    }

    @Test
    public void calendarOnWeb() {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com/");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//span[text()='Check in']")).click();

        try {
            Thread.sleep(1000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // #2, #3
        List<WebElement> dates = driver.findElements(By.xpath("//h2[text()='October 2021']/following-sibling::table//button[not(@disabled)]"));

        // #4
        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase("10")) {
                date.click();
                break;
            }
        }

        driver.findElement(By.xpath("//span[text()='Check out']")).click();

        try {
            Thread.sleep(1000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // #4
        for (WebElement date : dates) {
            if (date.getText().equalsIgnoreCase("17")) {
                date.click();
                break;
            }
        }



        /**
         * 1. Analyse if Date-values are present in dom as text or attribute's value
         * 2. Create a locator that will point to all the date webElements
         * 3. using findElements method to find all date-webElements
         * 4. using loop
         *      pick date-webElement
         *      get text value (or attribute value) [depends on step#1]
         *      if (above value == what user want to select)
         *          click webElement
         *          and break the loop
         *
         */

    }

    @Test
    public void findElementsTest() {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://classroomessentialsonline.com/");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Church Chairs locator
        By churchChairsLocator = By.xpath("(//a[contains(text(), 'Church Chairs')])[1]");
        WebElement churchChairs = driver.findElement(churchChairsLocator);
        Actions act = new Actions(driver);
        act.moveToElement(churchChairs).build().perform();

        try {
            Thread.sleep(1000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        By churchChairsOptionsLocator = By.xpath("(//a[contains(text(), 'Church Chairs')])[1]/following-sibling::div//a");
        List<WebElement> options = driver.findElements(churchChairsOptionsLocator);

        for (WebElement option : options) {
            System.out.println(option.getText());
        }



    }


}