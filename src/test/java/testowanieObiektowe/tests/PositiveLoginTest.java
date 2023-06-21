package testowanieObiektowe.tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import testowanieObiektowe.dirver.DriverUtils;
import testowanieObiektowe.page.objects.LoginPage;

import static testowanieObiektowe.navigation.ApplicationURLs.LOGIN_URL;

import static org.testng.Assert.assertEquals;

public class PositiveLoginTest extends TestBase {

    @Issue("DEFECT-2")
    @TmsLink("ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and chack if Dog Banner is displayed after")
    public void tryToLogInWithCorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUsernameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickLoginButton()
                .assertThatDogBannerIsDisplayed();
    }
}
