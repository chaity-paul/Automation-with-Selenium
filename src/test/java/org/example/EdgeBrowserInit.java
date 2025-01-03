package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EdgeBrowserInit {
    WebDriver driver;
    @BeforeSuite
    public void openEdgeBrowser(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void OpenURL() throws InterruptedException {
        driver.get("https://chaldal.com/");
        Thread.sleep(5000);
    }
    @AfterSuite
    public void closeEdgeBrowser(){
        driver.close();
    }
}
