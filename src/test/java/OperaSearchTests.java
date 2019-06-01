import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OperaSearchTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Opera");
        driver.get("https://www.google.com");
        wait = new WebDriverWait(driver, 15);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
