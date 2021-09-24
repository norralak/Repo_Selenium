// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
package Intro;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
/**
 *
 * @author Norralak
 */
public class SeleniumIntro {
    
    public static void main(String[] args){
        /**
         * Maven is a build tool used for documentation and project management.
         * We do not have to download and configure Selenium, instead, we just put it into our pom.xml file
         * Then, Maven will import, download and configure those external dependencies for us
         */

        /**
         * Selenium is a tool that is used for automation. Little demo below.
         * We can use it to navigate browsers, check test cases etc.
         */
        System.out.println("Selenium Projects!");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.github.com/norralak");
        //Another way to navigate
        driver.navigate().to("https://www.instagram.com/nor.ralak");
        driver.navigate().back();
        System.out.println("YOU ARE NOW HERE: "+driver.getTitle());
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/watch?v=jt9LlHXGckg");
        System.out.println(driver.getTitle());
    }

}
