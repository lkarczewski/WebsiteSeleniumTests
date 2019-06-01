import PageObjects.PageObjectGitHub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class GitHubLoginTests {

    private WebDriver driver;
    private PageObjectGitHub pageObjectGitHub;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
