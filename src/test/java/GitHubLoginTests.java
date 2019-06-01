import PageObjects.PageObjectGitHub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class GitHubLoginTests {

    private WebDriver driver;
    private PageObjectGitHub pageObjectGitHub;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
    }

    @Test
    void titlePageContainsGitHubTest() {
        pageObjectGitHub = new PageObjectGitHub(driver);
        assertTrue(pageObjectGitHub.checkPageTitle());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}