package org.example.assignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment1 {
    String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
    String browser = System.getProperty("browser", "chrome");
    WebDriver driver;
    @BeforeSuite
    public void startBrowser(){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
    }
    @Test
    public void openUrl() throws InterruptedException {
        driver.get(url);
        Thread.sleep(5000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }
}
