package com.leecottrell.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.netty.handler.codec.http.multipart.FileUpload;

import org.apache.commons.io.FileUtils;

public class AppTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                "C:\\!Selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void closeBrowser() {
        // driver.close();
        // driver.quit();
    }

    @Test
    public void testCDCOverweightIsPurple() {
        driver.get(
                "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches = driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.id("pounds"));
        WebElement calc = driver.findElement(By.id("calc"));

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("200");

        calc.click();
        WebElement table = driver.findElement(By.id("bmi_table"));
      //  WebElement row3 = table.findElement(By.xpath("//tr[4]"));
      //  System.out.println(row3.getCssValue("background-color"));
      //rgba(197, 190, 225, 1)
        String expected = "rgba(197, 190, 225, 1)";
        String actual ="";

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement aRow: rows){
            List<WebElement>cols = aRow.findElements(By.tagName("td"));
            for(WebElement aCol: cols){
                System.out.println(aCol.getDomProperty("textContent"));//proof of scraping
                if(aCol.getDomProperty("textContent").contains("Overweight")){
                    actual = aRow.getCssValue("background-color");
                }
            }
        }//end row
        assertEquals(expected, actual);

    }

    @Ignore
    public void testCDC_BMI_CalcIsCorrect() throws IOException {
        driver.get(
                "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html");
        WebElement feet = driver.findElement(By.id("feet"));
        WebElement inches = driver.findElement(By.id("inches"));
        WebElement pounds = driver.findElement(By.id("pounds"));
        WebElement calc = driver.findElement(By.id("calc"));

        feet.sendKeys("5");
        inches.sendKeys("10");
        pounds.sendKeys("200");

        // cheesy pause
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        calc.click();
        driver.manage().window().fullscreen();

        // better, non cheesy pause
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bmi_table")));

        // take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\!Selenium\\screenshots\\cdcbmi.png"));
        String expected = "21.5";
        WebElement bmiNum = driver.findElement(By.xpath(
                "/html/body/div[3]/main/div[3]/div/div[4]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/p[4]/strong[1]"));
        String actual = bmiNum.getText();
        assertEquals(expected, actual);

    }

    /*
     * @ParameterizedTest
     * 
     * @CsvSource({"5,10,200, 28.7",
     * "6,10,300,90"})
     * public void testOverweightPurple() throws Exception{
     * driver.get(
     * "https://www.cdc.gov/healthyweight/assessing/bmi/adult_bmi/english_bmi_calculator/bmi_calculator.html"
     * );
     * //feet, inches, pounds, calc
     * WebElement feet = driver.findElement(By.id("feet"));
     * WebElement inches = driver.findElement(By.id("inches"));
     * WebElement pounds = driver.findElement(By.id("pounds"));
     * WebElement button = driver.findElement(By.id("calc"));
     * 
     * feet.sendKeys("5");
     * inches.sendKeys("10");
     * pounds.sendKeys("190");
     * button.click();
     * 
     * //explicit wait
     * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bmi_table")));
     * 
     * 
     * //check that overweight box is purple
     * WebElement bmiTable = driver.findElement(By.id("bmi_table"));
     * WebElement row3 = bmiTable.findElement(By.xpath("//tr[4]"));
     * //System.out.println(row3.getCssValue("background-color"));
     * //rgba(197, 190, 225, 1)
     * String actual = "";// = row3.getCssValue("background-color");
     * String expected = "rgba(197, 190, 225, 1)";
     * List<WebElement> rows = bmiTable.findElements(By.tagName("tr"));
     * for(WebElement row : rows){
     * List<WebElement> cols = row.findElements(By.tagName("td"));
     * for(WebElement col : cols){
     * if(col.getDomProperty("textContent").contains("dead")){
     * actual = row.getCssValue("background-color");
     * }
     * }
     * }//end of the for
     * // Thread.sleep(5000);//try catch or a method that throws exceptions
     * 
     * driver.manage().window().fullscreen();
     * //take the screenshot
     * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     * FileUtils.copyFile(scrFile, new
     * File("c:\\!selenium\\screenshots\\cdcpurple.png"));
     * assertEquals("Overweight is not purple", actual, expected);
     * 
     * }
     */
    @Ignore
    public void testRadioButton() {
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        // radio2.click();

        // get all elements on a page
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            input.click();
        }
        // ensure radio2 isnot selected
        assertFalse(radio2.isSelected());

        WebElement dd = driver.findElement(By.partialLinkText("employee"));

    }

    @Ignore
    public void milkDoesABodyGood() {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        // String strongLink =
        // "/html/body/div[1]/div/div[2]/div[3]/div/div[1]/section[2]/div[2]/div/div/div/div/div/div/div/div/p[3]/span/a/strong";
        searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("milk");
        searchBox.sendKeys(Keys.RETURN);

        String title = driver.getTitle();
        assertTrue("Milk is not in the title", title.contains("milk"));

    }

    @Ignore
    public void scrapeTest() {
        driver.get("https://ptcollege.edu/ptc-employment/");
        // WebElement bottom =
        // driver.findElement(By.xpath("/html/body/div[2]/footer/div[3]/div[2]/p/a"));

        WebElement box = driver.findElement(By.id("nav-logo"));
        int deltaY = 3000;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
        WebElement newton = driver.findElement(By.id("gnewtonKeyword"));
        List<WebElement> faculty = driver.findElements(By.tagName("a"));
        // assertEquals(11, faculty.size());
        for (WebElement link : faculty) {
            System.out.println(link.getAttribute("innerText"));
        }

    }
}
