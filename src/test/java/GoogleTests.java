import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
        driver.get("https://www.google.com");
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void googleSearchExistingSite() {
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("YouTube");
        webElement.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.titleContains("YouTube"));
        driver.findElement(By.className("LC20lb")).click();
        wait.until(ExpectedConditions.titleIs("YouTube"));

        assertEquals("YouTube", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
