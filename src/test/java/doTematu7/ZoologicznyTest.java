package doTematu7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZoologicznyTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod () {
        System.setProperty("driver", "C:\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void myTest () {
        webDriver.navigate().to("http://przyklady.javastart.pl/jpetstore/actions/Catalog.action");

        webDriver.findElement(By.id("LogoContent"));

        webDriver.findElement(By.name("img_cart"));

        webDriver.findElement(By.linkText("Sign In"));

        webDriver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[3]"));

        webDriver.findElement(By.name("keyword"));

        webDriver.findElement(By.name("searchProducts"));

        webDriver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[1]"));
        webDriver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[2]"));
        webDriver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[3]"));
        webDriver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[4]"));
        webDriver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[5]"));

        webDriver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]"));
        webDriver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[2]"));
        webDriver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[3]"));
        webDriver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]"));
        webDriver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[5]"));

        webDriver.findElement(By.id("Main"));

        webDriver.findElement(By.linkText("www.mybatis.org"));
    }

    @AfterMethod
    public void afterMethod () {
        webDriver.close();
        webDriver.quit();
    }
}
//    Przykładowe rozwiązanie
//    Zoptymalizowane lokatory XPath dla każdego z elementów:

//div[@id='Logo']//img
//img[@name='img_cart']
//div[@id='MenuContent']/a[2]
//div[@id='MenuContent']/a[3]
//input[@name='keyword']
//input[@name='searchProducts']
//div[@id="QuickLinks"]/a[1]/img
//div[@id="QuickLinks"]/a[2]/img
//div[@id="QuickLinks"]/a[3]/img
//div[@id="QuickLinks"]/a[4]/img
//div[@id="QuickLinks"]/a[5]/img
//div[@id="SidebarContent"]/a[1]/img
//div[@id="SidebarContent"]/a[2]/img
//div[@id="SidebarContent"]/a[4]/img
//div[@id="SidebarContent"]/a[3]/img
//div[@id="SidebarContent"]/a[5]/img
//div[@id="MainImageContent"]/img
//div[@id="PoweredBy"]/a


//    Zoptymalizowane lokatory CSS dla każdego z elementów:
//
//        #Logo img
//        img[name='img_cart']
//        a[href*='signonForm']
//        a[href*='help']
//        input[name='keyword']
//        input[name='searchProducts']
//        #QuickLinks img[src*='fish']
//        #QuickLinks img[src*='dogs']
//        #QuickLinks img[src*='reptiles']
//        #QuickLinks img[src*='cats']
//        #QuickLinks img[src*='birds']
//        #SidebarContent img[src*='fish']
//        #SidebarContent img[src*='dogs']
//        #SidebarContent img[src*='reptiles']
//        #SidebarContent img[src*='cats']
//        #SidebarContent img[src*='birds']
//        #MainImageContent img
//        #PoweredBy > a