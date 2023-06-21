package testowanieObiektowe.page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement singInButton;

    @Step("Click on Sing In Link")
    public LoginPage clickOnTheSignLink(){
        WaitForElement.waitUntilElementClickable(singInButton);
        singInButton.click();
        log().info("Clicked at the sign link");
        return new LoginPage();
    }
}
