package po.temacie7.czekacze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;


public class Zadania {

    private WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    private void zad1(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement remove = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        remove.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(), "It's gone!");
    }

    @Test
    private void zad2(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement remove = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        remove.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement message = driver.findElement(By.id("message"));
        assertEquals(message.getText(), "It's gone!");

        remove.click();
        checkbox = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkbox")));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());
    }

    @Test
    public void zad3(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
        WebElement message = driver.findElement(By.id("finish"));
        assertFalse(message.isDisplayed());

        WebElement start = driver.findElement(By.xpath("//*[@id='start']/button"));

        start.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(message));
        assertTrue(message.isDisplayed());
    }

    @Test
    public void zad4(){
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
        WebElement start = driver.findElement(By.xpath("//*[@id='start']/button"));
        start.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        WebElement message = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        assertTrue(message.isDisplayed());
    }



    @AfterMethod
    public void beforeMethod(){
        driver.close();
        driver.quit();
    }





}
