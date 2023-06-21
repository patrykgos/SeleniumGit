package testowanieObiektowe.dirver;

import org.openqa.selenium.WebDriver;
import testowanieObiektowe.dirver.listeners.WebDriverEventListenerRegistrar;

import static testowanieObiektowe.configuration.TestRunProperties.getBrowserToRun;
import static testowanieObiektowe.configuration.TestRunProperties.getIsRemoteRun;
import static testowanieObiektowe.dirver.BrowserType.FIREFOX;

//public class DriverManager {
//
//    private static WebDriver driver;
//
//    private DriverManager() {
//    }
//
//    public static void setWebDriver(BrowserType browserType) {
//        WebDriver browser = null;
//        if (browserType == null) {
//            browserType = getBrowserToRun();
//            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
//        } else {
//            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
//        }
//        driver = browser;
//    }
//
//    public static WebDriver getWebDriver(){
//        if (driver == null) {
//            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
//        }
//        return driver;
//    }
//
//    public static void disposeDriver(){
//        driver.close();
//        if(!getBrowserToRun().equals(FIREFOX)) {
//            driver.quit();
//        }
//        driver = null;
//    }
//}


// TAK BYLO PRZEZ ZMIANAMI DOTYCZACYMI PARAMETRZACJI PRZEKLADARKI
//
//public class DriverManager {
//
//    private static WebDriver driver;
//
//    private DriverManager() {
//    }
//
//    public static WebDriver getWebDriver(){
//        if (driver == null) {
//            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
//        }
//        return driver;
//    }
//
//    public static void disposeDriver(){
//        driver.close();
//        if(!getBrowserToRun().equals(FIREFOX)) {
//            driver.quit();
//        }
//        driver = null;
//    }
//}


//JEZELI CHCEMY WIELOWATKOWO

public class DriverManager {


    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;
        if (browserType == null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver(){
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver(){
        webDriverThreadLocal.get().close();
        if(!browserTypeThreadLocal.get().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}