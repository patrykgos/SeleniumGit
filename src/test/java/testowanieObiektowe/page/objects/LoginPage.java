package testowanieObiektowe.page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.generic.assertions.AssertWebElement;
import testowanieObiektowe.waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name= "signon")
    private WebElement loginButton;

    @FindBy(css = "#Content [class='messages']")
    private WebElement messageLabel;

    @Step("Type info Username Field {username}")
    public LoginPage typeIntoUsernameField(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
        log().info("Typed into username field {}", username);
        return this;
    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed info password field{}", password);
        return this;
    }

    @Step("Click on Login Button")
    public FooterPage clickLoginButton(){
        WaitForElement.waitUntilElementClickable(loginButton);
        loginButton.click();
        log().info("Clicked at login link");
        return new FooterPage();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage){
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }
}
