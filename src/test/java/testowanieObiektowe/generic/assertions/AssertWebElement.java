package testowanieObiektowe.generic.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private Logger logger = LogManager.getLogger(AssertWebElement.class);

    protected AssertWebElement(WebElement element) {
        super(element, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement) {
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed(){
        logger.info("check if element is displayed");
        isNotNull();

        if(!actual.isDisplayed()) {
            failWithMessage("Element was not displayed");
        }
        logger.info("WebElement was not displayed");
        return this;
    }

    public AssertWebElement hasText(String expectedTextValue){
        logger.info("check if element has text: " + expectedTextValue);
        isNotNull();
        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)) {
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        logger.info("WebElement expected text!");
        return this;
    }
}
