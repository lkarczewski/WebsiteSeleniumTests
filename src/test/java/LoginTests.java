import PageObjects.PageObjectGitHub;
import PageObjects.PageObjectGitHubLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class LoginTests {

    private WebDriver driver;
    private PageObjectGitHub pageObjectGitHub;
    private PageObjectGitHubLogin pageObjectGitHubLogin;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
    }

    @Test
    void titlePageContainsGitHubTest() {
        pageObjectGitHub = new PageObjectGitHub(driver);
        assertTrue(pageObjectGitHub.checkPageTitle());
    }

    @Test
    void gitHubCorrectLoginTest() {
        pageObjectGitHubLogin = new PageObjectGitHubLogin(driver);
        pageObjectGitHubLogin.logInToExistingAccount();
        assertThat(pageObjectGitHubLogin.getLoggedUrl()).endsWith("github.com/");
    }

    @Test
    void gitHubIncorrectLoginTest() {
        pageObjectGitHubLogin = new PageObjectGitHubLogin(driver);
        pageObjectGitHubLogin.loginToNonExistingAccount();
        String result = pageObjectGitHubLogin.getErrorMessage();
        assertThat(result.contains("Incorrect username of password"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}