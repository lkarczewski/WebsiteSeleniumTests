import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirefoxSearchTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Firefox");
        driver.get("https://www.google.com");
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    void googleSearchExistingSite() {
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("YouTube");
        webElement.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleContains("YouTube"));
        driver.findElement(By.className("LC20lb")).click();
        wait.until(ExpectedConditions.titleIs("YouTube"));

        assertEquals("YouTube", driver.getTitle());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
