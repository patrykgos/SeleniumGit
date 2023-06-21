package testowanieObiektowe.page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class ShoppingCartPage {

    private Logger logger = LogManager.getLogger(ShoppingCartPage.class);

    @FindBy(css = "#Cart > a[href*='Order.action']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage clickProceedToCheckOutLink(){
        WaitForElement.waitUntilElementClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked at proceed to checkout link");
        return new LoginPage();
    }
}
