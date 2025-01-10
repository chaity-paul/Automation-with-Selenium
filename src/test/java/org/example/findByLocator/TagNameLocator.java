package org.example.findByLocator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class TagNameLocator {
    WebDriver driver;
    @BeforeSuite
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openUrl() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
        //Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
        for(WebElement x : elements){
            System.out.println(x.getText());
        }
        //Thread.sleep(5000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
