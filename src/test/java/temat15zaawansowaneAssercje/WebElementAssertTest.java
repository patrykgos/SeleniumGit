package temat15zaawansowaneAssercje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.*;

public class WebElementAssertTest {

    @Test
    public void testCustomAssertions() {
        WebDriver driver = new ChromeDriver();
        WebElement webElement = driver.findElement(By.id("element-id"));

        WebElementAssert.assertThat(webElement)
                .hasText("JavaStart")
                .hasAttribute("class", "heading");
    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        WebElement element = driver.findElement(By.cssSelector("some_css_locator"));

        WebElementAssert.assertThat(element).isDisplayed().isEnabled().isLink();
    }
}
