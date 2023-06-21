package doTematu7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.sql.Driver;

import static org.testng.Assert.assertEquals;

public class SecondAutomatedTest {



    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void muSecondTest() {
        driver.navigate().to("https://selenium.dev/");

        String title = driver.getTitle();

        assertEquals(title, "Selenium");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();

    }


}

