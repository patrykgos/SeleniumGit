package doTematu7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogowanieTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod () {
        System.setProperty("driver", "C:\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void logowanieTest () {
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Account.action?newAccountForm=");

        webDriver.findElement(By.name("username"));

        webDriver.findElement(By.name("password"));

        webDriver.findElement(By.name("repeatedPassword"));

        webDriver.findElement(By.name("account.languagePreference"));

        webDriver.findElement(By.name("account.favouriteCategoryId"));

        webDriver.findElement(By.name("account.listOption"));

        webDriver.findElement(By.name("account.bannerOption"));
    }



    @AfterMethod
    public void afterMethod () {
        webDriver.close();
        webDriver.quit();
    }
}
