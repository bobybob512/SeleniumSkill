import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainSelenium {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/test/chromedriver-win64.zip");
        //ChromeDriver driver = new ChromeDriver();


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com"); // focusul nu se poate schimba daca navigam manual pe alte taburi !!
        driver.close(); //inchide doar tabul pe care are focusul
        driver.quit(); //inchide tot si termina sesiunea de chromedriver..

        System.out.println("Finish");
    }
}
