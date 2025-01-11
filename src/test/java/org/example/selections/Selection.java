package org.example.selections;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Selection {
    WebDriver driver;
    @BeforeSuite
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openUrl() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.id("inputGroupSelect03"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }
}
