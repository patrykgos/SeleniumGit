package testowanieObiektowe.page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class FishPage {

    private Logger logger = LogManager.getLogger(FishPage.class);

    @FindBy(css = "#Catalog table a[href*='productId=FI-SW-01']")
    private WebElement angelFish;

    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelfishPage clickOnAngelFishLink(){
        WaitForElement.waitUntilElementClickable(angelFish);
        angelFish.click();
        logger.info("Clicked on the angelfish");
        return new AngelfishPage();
    }
}
