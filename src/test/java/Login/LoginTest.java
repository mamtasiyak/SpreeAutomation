package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class LoginTest {
    WebDriver driver;

    @AfterClass
    public void teardown(){
        driver.quit();
    }
    @Test(priority = -1)
    public void testLoginIntoSpree() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/mamta.siyak/Downloads/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Thread.sleep(2000);
        WebElement login=driver.findElement(By.id("link-to-login"));
        login.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        //do login logout
        driver.findElement(By.id("spree_user_email")).sendKeys("mamta.siyak@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("mamtasiyak1@");
        //Thread.sleep(2000);
        //login
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testSuccessfulMessageOnValidLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/mamta.siyak/Downloads/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //assert login successful mssg
        WebElement login=driver.findElement(By.id("link-to-login"));
        login.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        driver.findElement(By.id("spree_user_email")).sendKeys("mamta.siyak@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("mamtasiyak1@");
        driver.findElement(By.name("commit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText(),"Logged in successfully");
    }

    @Test
    public void testErrorMessageOnInvalidLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/mamta.siyak/Downloads/chromedriver");
        driver= new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // assert incorrect username password mssg
        WebElement login=driver.findElement(By.id("link-to-login"));
        login.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-to-login")));
        //do login logout
        driver.findElement(By.id("spree_user_email")).sendKeys("mamta.siyak@thoughtworks.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("mamtasiyak");
        driver.findElement(By.name("commit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]")).getText(),"Invalid email or password.");
        driver.close();
    }
}
