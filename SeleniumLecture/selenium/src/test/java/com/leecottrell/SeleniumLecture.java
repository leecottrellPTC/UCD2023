package com.leecottrell;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import java.net.URI;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chro

//C:\!Selenium\chromedriver
/**
 * Unit test for simple App.
 */
public class SeleniumLecture 
{

    public static WebDriver driver;
    @BeforeClass
    public static void setupDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       //System.setProperty("webdriver.chrome.driver", 
       //     "C:\\!Selenium\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }

    @Test
    public void testGoogleSearchInTitleBar(){
       
        driver.get("https://www.google.com");
        WebElement q = driver.findElement(By.name("q"));

        q.sendKeys("pepsi");
        q.sendKeys(Keys.RETURN);

        String actual = driver.getTitle();
        assertTrue(actual.contains("milk"));

    }

}
