package TicketTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.Selector;

public class TicketTwo {

    //TC-1: Verify Gender Error Message Is Present When None Is Selected Upon Registration
    @Test
    public void verifyGenderErrMsg() {
        String expectedMsg = "Please choose a gender. You can change who can see this later.";
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com"); //Launch FB
        driver.findElement(By.partialLinkText("Create")).click(); //Click Create Account
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Fill out the form
        driver.findElement(By.name("firstname")).sendKeys("Kalarron");
        driver.findElement(By.name("lastname")).sendKeys("Marakus");
        driver.findElement(By.name("reg_email__")).sendKeys("6466437765");
        driver.findElement(By.name("reg_passwd__")).sendKeys("thirteen");
        //DOB Dropdown 8/13/1998
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));
        Select year = new Select(driver.findElement(By.id("year")));
        month.selectByVisibleText("Aug");
        day.selectByIndex(12);
        year.selectByValue("1998");
        //Sign Up!
        driver.findElement(By.name("websubmit")).click();
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Verify the message
        WebElement genderMsg = driver.findElement(By.id("js_1e")); //Store WebElement
        Assert.assertTrue(genderMsg.isDisplayed()); //Check If Message Displays
        String genderError = genderMsg.getText(); //Store WebElement Text
        Assert.assertEquals(genderError, expectedMsg,"Unexpected or Null Message"); //Assert Compare With Expected Value
        driver.quit();
    }

    //TC-2: Verify No Radio Button On Gender Is Selected By Default
    @Test
    public void verifyNoGenderRadio() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com"); //Launch FB
        driver.findElement(By.partialLinkText("Create")).click(); //Click Create Account
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement[] genderRadio = new WebElement[3];
        genderRadio[0] = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '1']"));
        genderRadio[1] = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '2']"));
        genderRadio[2] = driver.findElement(By.xpath("//input[@type = 'radio' and @value = '-1']"));
        //Check if each radio button is selected
        for (WebElement option : genderRadio){
            Assert.assertFalse(option.isSelected());
        }
        driver.quit();
    }

    //TC-3: Verify Feels-Like Temp Is Between Low Temp & High Temp
    @Test
    public void verifyFLT() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net"); //Launch DarkSky
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        textBox.clear(); //Delete Default Entry
        textBox.sendKeys("11370"); //Enter Zip Code
        driver.findElement(By.xpath("//a[@class='searchButton']")).click();
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String maxTemp = driver.findElement(By.xpath("//*[@class='high-temp-text']")).getText();
        int highTemp = Integer.parseInt(maxTemp.substring(0, maxTemp.length() - 1)); //Parse integer from String value with degree character removed
        String minTemp = driver.findElement(By.xpath("//*[@class='low-temp-text']")).getText();
        int lowTemp = Integer.parseInt(minTemp.substring(0, minTemp.length() - 1)); //Parse integer from String value with degree character removed
        String tempFeels = driver.findElement(By.xpath("//*[@class='feels-like-text']")).getText();
        int feelsTemp = Integer.parseInt(tempFeels.substring(0, tempFeels.length() - 1)); //Parse integer from String value with degree character removed

        Assert.assertTrue(feelsTemp <= highTemp && feelsTemp >= lowTemp, "Feels Like Temperature Invalid"); //Check condition

        driver.quit();
    }

    //TC-4: Verify Fahrenheit to Celsius Conversion
    @Test
    public void verifyFtoC() {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://darksky.net");
        WebElement tempUnitSelect = driver.findElement(By.xpath("//div[@class='selectric'][1]"));
        tempUnitSelect.click(); //Click the dropdown
        tempUnitSelect.findElement(By.xpath("//li[contains(text(), 'F')]")).click(); //Click on Fahrenheit
        try {                               //Pause for a bit
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentTemp = driver.findElement(By.xpath("//span[@class='summary swap']")).getText(); //Get current temperature in Fahrenheit
        currentTemp = currentTemp.split(" ")[0]; //Remove text
        int fTemp = Integer.parseInt(currentTemp.substring(0, currentTemp.length() - 1)); //Parse integer from String value remove degrees

        double cTempDub = Math.round((fTemp-32)/1.8); //Expected conversion rounded to the nearest integer
        int expectedCelsius = (int) cTempDub; //Cast as integer datatype

        tempUnitSelect.click();
        tempUnitSelect.findElement(By.xpath("//li[contains(text(), 'km/h')]")).click(); //Change it to Celsius
        try {
            Thread.sleep(2600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        currentTemp = driver.findElement(By.xpath("//span[@class='summary swap']")).getText(); //Get current temperature in Celsius
        currentTemp = currentTemp.split(" ")[0]; //Remove text
        int cTemp = Integer.parseInt(currentTemp.substring(0, currentTemp.length() - 1)); //Parse integer from String value remove degrees
        Assert.assertEquals(cTemp, expectedCelsius, "Fahrenheit to Celsius conversion is not valid.");

        driver.quit();
    }

}
