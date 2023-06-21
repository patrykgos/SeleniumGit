package testowanieObiektowe.page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class AngelfishPage {

    private Logger logger = LogManager.getLogger(AngelfishPage.class);

    @FindBy(css = "#Catalog table a[href*='workingItemId=EST-2']")
    private WebElement addSmallAngelfishToCardButton;

    public AngelfishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShoppingCartPage clickAtAddSmallAngelfishToCardLink(){
        WaitForElement.waitUntilElementClickable(addSmallAngelfishToCardButton);
        addSmallAngelfishToCardButton.click();
        logger.info("Clicked on angelfish to card link");
        return new ShoppingCartPage();
    }
}
