import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainSelenium {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "src/test/chromedriver-win64.zip");
        //ChromeDriver driver = new ChromeDriver();


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
    }
}
