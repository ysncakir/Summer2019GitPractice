package practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Wait {

    private WebDriver driver;

   @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test
    public void waitPractice(){
       driver.findElement(By.linkText("Dynamic Loading")).click();
       driver.findElement(By.partialLinkText("Example 1")).click();
       driver.findElement(By.tagName("button")).click();

       WebElement usernameBox = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(usernameBox));

        usernameBox.sendKeys("ysncakir");

        WebElement passwordBox = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordBox));

        passwordBox.sendKeys("1234");

        driver.findElement(By.cssSelector("[type='submit']")).click();



    }


    @AfterMethod
    public void teardown(){
       driver.quit();


    }




}
