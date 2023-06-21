package testowanieObiektowe.tests;

import io.qameta.allure.Step;
import org.testng.annotations.*;
import testowanieObiektowe.configuration.ConfigurationProperties;
import testowanieObiektowe.configuration.PropertiesLoader;
import testowanieObiektowe.dirver.BrowserType;
import testowanieObiektowe.dirver.DriverManager;
import testowanieObiektowe.dirver.DriverUtils;

import java.util.Properties;

import static testowanieObiektowe.navigation.ApplicationURLs.APPLICATION_URL;
public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser to: {browserType} and navigating to Home Page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterMethod(){
        DriverManager.disposeDriver();
    }
}
