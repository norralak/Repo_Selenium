package TicketFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.*;
import java.util.*;

public class TicketFour {
    //TC-1: Verify DarkSky Blog published date is in format MM:DD:YYYY
    @Test
    public void verifyDateFormat() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net"); //Launch DarkSky
        driver.findElement(By.xpath("//a[contains(text(),'Dark Sky API')]")).click(); //Click on Dark Sky API
        driver.findElement(By.linkText("blog post")).click(); //Navigate to the blog post

        List<WebElement> datesPublished = driver.findElements(By.xpath("//time[@itemprop = 'datePublished']")); //Get all published dates and add to a List
        DateFormat format = new SimpleDateFormat("MMMM dd,yyyy", Locale.US);

        for (WebElement date: datesPublished){
            boolean correctFormat = false;
            //Check to see for each date published if it is in the correct format
            try {
                format.parse(date.getText());
                correctFormat = true;
            } catch (Exception e) {
                e.printStackTrace();
            }

            Assert.assertTrue(correctFormat, "Invalid Date Format on one or more elements.");
        }

        driver.quit();
    }

    //TC-2: Verify Guest Count Update
    @Test
    public void verifyGuestCount() {
        //Expected Values
        String expKids = "1", expRooms = "1", expAdults = "3";;
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://hotels.com"); //Launch Hotels
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//span[text() = 'Guests' or text() = 'Travelers']")).click(); //Click to add guest
        //Add the amount of children
        WebElement kids = driver.findElement(By.xpath("//select[contains(@name, 'children')]"));
        kids.click(); //Click the dropdown
        Select kidAmount = new Select(kids);
        kidAmount.selectByVisibleText(expKids); //Select 1
        //Update the child's age
        WebElement kidAge = driver.findElement(By.xpath("//select[contains(@name, 'child-0-age')]"));
        kidAge.click(); //Click the dropdown
        Select kidAgeSelect = new Select(kidAge);
        kidAgeSelect.selectByVisibleText("13"); //Select 13
        //Add the amount of adults
        WebElement adults = driver.findElement(By.xpath("//select[contains(@name, 'adults')]"));
        adults.click(); //Click the dropdown
        Select adultAmount = new Select(adults);
        adultAmount.selectByVisibleText(expAdults); //Select 3

        String[] headCount = driver.findElement(By.xpath("//div[@class = '_1sygyM']")).getText().split("\n"); //Split by next lines
        String guestRooms = headCount[0].split(" Room")[0]; //First line minus "Room" (Even if it is 'Rooms', the first index will still be the amount of rooms and the second will be 's')
        String guestAdults = headCount[1].split(" ")[0]; //Second line first index
        String guestKids = headCount[1].split(" ")[2]; //Second line third index
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Verify via Assert
        Assert.assertEquals(guestKids, expKids, "Unexpected amount of children.");
        Assert.assertEquals(guestAdults, expAdults, "Unexpected amount of adults.");
        Assert.assertEquals(guestRooms, expRooms, "Unexpected amount of rooms.");
        //Click Apply
        driver.findElement(By.xpath("//button[text() = 'Apply']")).click();
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Verify search bar text via Assert
        int totalRooms = Integer.parseInt(guestRooms);
        int totalGuests = Integer.parseInt(guestAdults) + Integer.parseInt(guestKids); //Convert into an integer
        String[] searchBar = driver.findElement(By.xpath("//span[text() = 'Guests']//following-sibling::*")).getText().split(" ");
        int searchRooms = Integer.parseInt(searchBar[0]); //Parse integer number of rooms
        int searchGuests = Integer.parseInt(searchBar[2]); //Now number of guests

        //Verify actual data with expected values from previous Assert
        Assert.assertEquals(totalRooms, searchRooms, "Unexpected room value in search bar.");
        Assert.assertEquals(totalGuests, searchGuests, "Unexpected guest value in search bar.");
        /**
         * You could have skipped parseInt and compared Strings, I just wanted the muscle memory of typing out that particular code
         * It would have also made assertEquals more useful as it compares Strings
         */
        driver.quit(); //Lesson of the Day: Use F8 while in debug mode to freeze webpage and inspect hidden elements in DOM
    }
}
