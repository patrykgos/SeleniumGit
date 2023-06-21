package testowanieObiektowe.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testowanieObiektowe.dirver.DriverManager;

public class ScreenShotMaker {

    @Attachment(value="Page screenshot test failure", type = "image/png")
    public static byte[] makeScreenShot(){
        byte[] screenshotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }
}
