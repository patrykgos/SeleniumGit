package testowanieObiektowe.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import testowanieObiektowe.dirver.DriverUtils;
import testowanieObiektowe.page.objects.LoginPage;
import testowanieObiektowe.utils.tesnng.listeners.RetryAnalyzer;

import static testowanieObiektowe.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.*;

public class FailedLoginTest extends TestBase {

//   w ten sposob mozemy samemu ustalic jaka przegladarke chcemy
//    @BeforeMethod
//    public void beforeTest(@Optional BrowserType browserType) {
//        super.beforeTest(BrowserType.IE);
//    }


    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test//(retryAnalyzer = RetryAnalyzer.class) RetryAnalyzer zadziała tylko dla tego test w tym przypadku, ja ustawiam to w pliku testng.xml
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void tryToLogInWithWrongUsernameAndPassword(){
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("wrong username")
                .typeIntoPasswordField("wrong password")
                .clickLoginButton();
        loginPage.assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }
}
