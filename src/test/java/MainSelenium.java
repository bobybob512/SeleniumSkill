import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainSelenium {

    @DataProvider(name = "myFirstDataProvider")
    public static Object[][] myFirstDataProvider(){
        return new Object[][] {
                {"/elements"},
                {"/forms"},
                {"/alertsWindows"},
                {"/widgets"},
                {"/interaction"},
                {"/books"}
        };

    }

    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/test/chromedriver-win64.zip");
        //ChromeDriver driver = new ChromeDriver();


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com"); // focusul nu se poate schimba daca navigam manual pe alte taburi !!

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println(driver.findElement(By.id("smapleHeading")).getText());
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("windowButton")).click();
        Set<String> windowHandles2 = driver.getWindowHandles();

        for (String window : windowHandles2) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.close();

//        WebElement element1 = driver.findElement(By.xpath("//div[@class='home-banner']/a"));
//        WebElement element2 = driver.findElement(By.cssSelector("div.home-banner a"));
//        element2.click();

        //By.TagName
//        WebElement header = driver.findElement(By.tagName("header"));
//        header.click();

        //By.id
//        driver.get("https://demoqa.com/webtables");
//        WebElement button = driver.findElement(By.id("addNewRecordButton"));
//        button.click();

        //By.LinkText
//    driver.get("https://demoqa.com/links");
//    WebElement link = driver.findElement(By.linkText("Home"));
//    link.click();


        //By.Name
//        driver.get("https://demoqa.com");
//        WebElement meta = driver.findElement(By.name("viewport"));
//        System.out.println(meta.getAttribute("content"));


        // driver.close(); //inchide doar tabul pe care are focusul
        driver.quit(); //inchide tot si termina sesiunea de chromedriver..

        System.out.println("Finish");
    }
}

