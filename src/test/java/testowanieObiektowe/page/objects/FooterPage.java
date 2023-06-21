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

public class FooterPage extends BasePage {

    @FindBy (css = "#Banner img")
    private WebElement dogBanner;


    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        log().info("checking if dog banner is displayed");
        WaitForElement.waitUntilElementsVisible(dogBanner);
        AssertWebElement.assertThat(dogBanner).isDisplayed();
        return this;
    }
}
