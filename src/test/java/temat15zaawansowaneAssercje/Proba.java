package temat15zaawansowaneAssercje;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class Proba {
    public static void main(String[] args) {

        int actualNumber = 42;
        assertThat(actualNumber).isEqualTo(42);

        String actualString = "Hello, World!";
        assertThat(actualString).startsWith("Hello");

        List<String> actualList = Arrays.asList("apple", "banana", "orange");
        assertThat(actualList).contains("banana");

        //_________________________

        boolean actualValue = true;
        assertThat(actualValue).isTrue();

        boolean anotherValue = false;
        assertThat(anotherValue).isFalse();

        int actualNumber2 = 42;
        assertThat(actualNumber2).isNotEqualTo(0);

        //___________________________

        Throwable thrown = catchThrowable(() -> {
            throw new IllegalArgumentException("Invalid argument");
        });

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid argument");

        //______________________________

        List<String> actualList2 = Arrays.asList("apple", "banana", "orange");
        assertThat(actualList2).hasSize(3);

        assertThat(actualList2).allMatch(element -> Character.isLowerCase(element.charAt(0)));

        assertThat(actualList2).containsOnlyOnce("banana", "orange");

        //______________________

        WebDriver driver = new ChromeDriver();

        WebElement element = driver.findElement(By.id("element_id"));
        assertThat(element.getText()).isEqualTo("JavaStart");

    }
}
