import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TabsManagementTest {
    WebDriver driver;
    WebDriverWait wait;
    @Test(priority = 1)
    public void setUp(){
       driver=  WebDriverManager.firefoxdriver().create();
       wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       driver.get("https://micetribe.com/");
    }
    @Test(priority = 2)
    public void signupisDisplayed(){

        WebElement signupButton =  driver.findElement(By.xpath("//*[@id=\"slider-1-slide-1-layer-7\"]"));
        wait.until(ExpectedConditions.visibilityOf(signupButton));
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        Assert.assertTrue(signupButton.isDisplayed());
        signupButton.click();

    }
    @Test(priority = 3)
    public void signupRedirectToNewTab() {
        Set<String> handlers = driver.getWindowHandles();
        Iterator iterator = handlers.iterator();
        String main = iterator.next().toString();
        String newTab = iterator.next().toString();
        driver.switchTo().window(newTab);
        String xpath = "//*[@id=\"loginSignup\"]/button";
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
        driver.switchTo().window(main);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
