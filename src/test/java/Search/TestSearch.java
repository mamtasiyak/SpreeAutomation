package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestSearch {
    WebDriver driver;
    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @Test
    public void searchItemAndAddToCart() throws InterruptedException {
        //one test case for search for element and add it to cart
        System.setProperty("webdriver.chrome.driver", "/Users/mamta.siyak/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.id("link-to-login"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        driver.findElement(By.id("spree_user_email")).sendKeys("mamta.siyak@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("mamtasiyak1@");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.id("keywords")).sendKeys("shirt");
        driver.findElement(By.xpath("//*[@id=\"product_5\"]/div/div[1]/a/span")).click();

        WebElement cart=driver.findElement(By.id("add-to-cart-button"));
        cart.click();
        WebDriverWait wait1=new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement logout=driver.findElement(By.linkText("Logout"));
        logout.click();
        WebDriverWait wait2=new WebDriverWait(driver,10);
        wait2.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));

    }
}
