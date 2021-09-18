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
        System.out.println("Selenium Projects!");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/mew.liwrungsub");
    }

}
