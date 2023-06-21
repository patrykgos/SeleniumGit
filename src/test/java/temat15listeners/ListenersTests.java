package temat15listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(TestListenerProba.class)
public class ListenersTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.pl");
    }

    @Test
    public void  successGoogleTest(){
        assertTrue("Page title does not equals expected title", driver.getTitle().equals("Google"));
    }

    @Test
    public void skippedGoogleTest() {
        throw new SkipException("This test is skipped");
    }

    @Test
    public void failGoogleTest() {
        assertTrue("Page title does not equals expected title", driver.getTitle().equals("BadGoogle"));
    }




    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
