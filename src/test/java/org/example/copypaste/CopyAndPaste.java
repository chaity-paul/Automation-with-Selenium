package org.example.copypaste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CopyAndPaste {
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
        WebElement element = driver.findElement(By.id("firstname"));
        element.sendKeys("Chaity");
        Thread.sleep(3000);
        Actions action = new Actions(driver);
        //select
        action.keyDown(Keys.CONTROL);
        action.sendKeys("a");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        //copy
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();

        //tab
        action.sendKeys(Keys.TAB);
        action.build().perform();

        //paste
        action.keyDown(Keys.CONTROL);
        action.sendKeys("v");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        Thread.sleep(3000);

    }
    @AfterSuite
    public void closeChromeBrowser(){
        driver.close();
    }
}
