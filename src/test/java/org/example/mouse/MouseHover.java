package org.example.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MouseHover {
    WebDriver driver;
    @BeforeSuite
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openUrl() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.linkText("Casual Dresses"));
        element1.click();
        Thread.sleep(3000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
