package org.example.browserNavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OpenAnotherURL {
    WebDriver driver;
    @BeforeSuite
    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://chaldal.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/register.php");
        Thread.sleep(3000);
    }
    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
