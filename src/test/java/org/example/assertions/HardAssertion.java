package org.example.assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HardAssertion {
    WebDriver driver;
    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
        Thread.sleep(5000);

        String expectedTitle = "Selenium Practice - Register";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement home = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        home.sendKeys("Chaity");
        Thread.sleep(5000);
    }
    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
