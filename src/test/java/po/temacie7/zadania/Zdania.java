package po.temacie7.zadania;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Zdania {

    private WebDriver drive;

    private void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void init(){
        System.setProperty("driver", "C:/drivers/chromedriver.exe");
        drive = new ChromeDriver();
    }

    @Test
    public void zad1(){
        drive.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
        WebElement checkBox1 = drive.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = drive.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        assertFalse(checkBox1.isSelected());
        assertTrue(checkBox2.isSelected());

        checkBox1.click();
        checkBox2.click();

        assertTrue(checkBox1.isSelected());
        assertFalse(checkBox2.isSelected());
    }

    @Test
    public void zad2(){
        drive.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
        WebElement dropdownList = drive.findElement(By.id("dropdown"));
        Select select = new Select(dropdownList);
        assertEquals(select.getFirstSelectedOption().getText(), "Please select an option");
        select.selectByValue("1");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        select.selectByValue("2");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test
    public void zad3(){
        drive.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
        WebElement fileUploader = drive.findElement(By.id("file-upload"));
        String fileName = "testfile.txt";
        fileUploader.sendKeys("C:\\Users\\Patrol\\Desktop\\" + fileName);
        WebElement upload = drive.findElement(By.id("file-submit"));
        upload.click();
        WebElement uploadedFile = drive.findElement(By.id("uploaded-files"));
        assertEquals(fileName, uploadedFile.getText());
    }

    @Test
    public void zad4(){
        drive.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
        WebElement person1 = drive.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        WebElement person2 = drive.findElement(By.xpath("//*[@id='content']/div/div[2]"));
        WebElement person3 = drive.findElement(By.xpath("//*[@id='content']/div/div[3]"));
        Actions actions = new Actions(drive);
        actions.moveToElement(person1).perform();

        WebElement firstUserName = drive.findElement(By.xpath("//div[1]/div/h5"));
        WebElement secondUserName = drive.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdUserName = drive.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(firstUserName.getText(), "name: user1");
        assertEquals(secondUserName.getText(), "");
        assertEquals(thirdUserName.getText(), "");

        actions.moveToElement(person2).perform();
        assertEquals(firstUserName.getText(), "");
        assertEquals(secondUserName.getText(), "name: user2");
        assertEquals(thirdUserName.getText(), "");

        actions.moveToElement(person3).perform();
        assertEquals(firstUserName.getText(), "");
        assertEquals(secondUserName.getText(), "");
        assertEquals(thirdUserName.getText(), "name: user3");
    }



    @AfterMethod
    public void beforeTest(){
        drive.close();
        drive.quit();
    }
}
