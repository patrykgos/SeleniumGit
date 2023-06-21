package testowanieObiektowe.page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.waits.WaitForElement;

public class ContentPage {

    private Logger logger = LogManager.getLogger(ContentPage.class);
    public ContentPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(css = "#SidebarContent img[src*='fish']")
    private WebElement fishButton;

    public FishPage clickOnTheFishLink(){
        WaitForElement.waitUntilElementClickable(fishButton);
        fishButton.click();
        logger.info("Clicked on the fish link");
        return new FishPage();
    }
}
