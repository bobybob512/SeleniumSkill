import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainSelenium {
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

    @Test
    public void assertTest(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(), 6, "Wrong card size");

        driver.quit();
    }

    @Test
    public void primulTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.quit();
        throw new RuntimeException("Custom made exception");
    }
@Test
    public static void doubleClick(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.cssSelector("button[aria-label=\"Consent\"] p")).click();
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();

        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(message.getText(), "You have done a double click", "Double click was unsuccessful");
        driver.quit();
    }

    @Test
    public static void rightClick(){
        WebDriverManager.chromedriver().setup();
        SoftAssert softAssert = new SoftAssert();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.cssSelector("button[aria-label=\"Consent\"] p")).click();
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

        softAssert.assertFalse(rightClickButton.isDisplayed(), "Right click button is not displayed");
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).build().perform();


        WebElement message = driver.findElement(By.id("rightClickMessage"));
        softAssert.assertEquals(message.getText(), "You have done a right clickkkk", "Right click was unsuccessful");
        //softAssert.assertAll();

        driver.quit();
        softAssert.assertAll();

    }
}

