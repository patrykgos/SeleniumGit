package po.temacie7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class WebElementsTests {

    private WebDriver driver;

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void init(){
        System.setProperty("driver", "C:/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep(); //nie powinno sie tak robic tylko dla przykladu zeby zobaczyc jak dziala
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();

        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
    public void filePickingTest(){
        sleep();
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\test.png");
        sleep();
    }

    @Test
    public void typingAndClearingValueInsideWebElementTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        sleep();
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        sleep();

        assertEquals(typeUserNameValue, "Selenium Start");

        userNameField.clear();
        sleep();

        String emptyUserNameValue = userNameField.getAttribute("value");
        assertEquals(emptyUserNameValue, "");
    }

    @Test
    public void checkRadioButtonTest(){
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        sleep();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void  checkboxButtonTest(){
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckBox = driver.findElement(By.cssSelector("input[value='spaghetti'"));
        WebElement hamburgerCheckBox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(spaghettiCheckBox.isSelected());
        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(hamburgerCheckBox.isSelected());
        sleep();

        pizzaCheckbox.click();
        spaghettiCheckBox.click();
        hamburgerCheckBox.click();
        sleep();

        assertTrue(spaghettiCheckBox.isSelected());
        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(hamburgerCheckBox.isSelected());
    }

    @Test
    public void dropDownListingTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<>();
        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = List.of("Germany", "Poland", "UK");
        assertEquals(expectedNamesOfOptions, namesOfOptions);
    }

    @Test
    public void selectingOptionsFromDropDownTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        sleep();
        countryDropDown.selectByIndex(1);
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

        countryDropDown.selectByValue("de_DE");
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

        countryDropDown.selectByVisibleText("UK");
        sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
    }

    @Test
    public void checkElementOnPageTest(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed: " + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + usernameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }

    @Test
    public void hoverOverAndClickAndHoldTest(){
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
        WebElement smileyIcon = driver.findElement(By.id("smiley"));
        Actions action = new Actions(driver);
        action.moveToElement(smileyIcon).click().build().perform();
        sleep();
        Actions secondAction = new Actions(driver);
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));
        action.moveToElement(smileyIcon2).click().build().perform();
        sleep();
    }




    @AfterMethod
    public void beforeMethod(){
        driver.close();
        driver.quit();
    }



}
