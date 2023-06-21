package testowanieObiektowe.page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class LandingPage extends BasePage {

    @FindBy(css = "#Content a")
    private WebElement enterToStore;

    @Step("Click on Enter Store link")
    public TopMenuPage clickOnEnterStoreLink(){
        WaitForElement.waitUntilElementClickable(enterToStore);
        enterToStore.click();
        log().info("Clicked on enter store link");
        return new TopMenuPage();
    }
}
