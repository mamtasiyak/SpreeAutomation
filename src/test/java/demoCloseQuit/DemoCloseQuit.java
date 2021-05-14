package demoCloseQuit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DemoCloseQuit {
    WebDriver driver;
    @Test
    public void differenceBetweenCloseAndQuit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/mamta.siyak/Downloads/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com/");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        driver.get("https://www.amazon.com/");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(3));
        driver.get("https://www.facebook.com/");
        driver.close();
        Thread.sleep(2000);
        driver.quit();
    }
}
