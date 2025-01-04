package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CrossBrowserHeadLess {
    String url = "https://chaldal.com/";
    String browser = System.getProperty("browser", "");
    WebDriver driver;
    @BeforeSuite
    public void startBrowser(){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        else{
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");

            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
        }
    }
    @Test
    public void openUrl() throws InterruptedException {
        driver.get(url);
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }
}
