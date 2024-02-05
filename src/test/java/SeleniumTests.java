import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SeleniumTests {

    ChromeDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebdriverManager.getChromeDriverByManager();
        throw new RuntimeException("Eroare din beforeMethod");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if(driver != null){
            driver.quit();
        }
    }
@Test
    public void assertTest(){
        driver.get("https://demoqa.com/");
    driver.findElement(By.cssSelector("button[aria-label=\"Consent\"] p")).click();
        List<WebElement> cards = driver.findElements(By.className("card"));
        assertEquals(cards.size(), 6, "Wrong card size");
    }

    @Test
    public void primulTest() {
        driver.get("https://demoqa.com/browser-windows");
        driver.quit();
        throw new RuntimeException("Custom made exception");
    }

    @Test
    public void doubleClick(){
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.cssSelector("button[aria-label=\"Consent\"] p")).click();
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();

        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(message.getText(), "You have done a double click", "Double click was unsuccessful");
    }

    @Test
    public void rightClick(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.cssSelector("button[aria-label=\"Consent\"] p")).click();
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));

        softAssert.assertFalse(rightClickButton.isDisplayed(), "Right click button is not displayed");
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).build().perform();


        WebElement message = driver.findElement(By.id("rightClickMessage"));
        softAssert.assertEquals(message.getText(), "You have done a right clickkkk", "Right click was unsuccessful");
        //softAssert.assertAll();

        softAssert.assertAll();

    }

}
