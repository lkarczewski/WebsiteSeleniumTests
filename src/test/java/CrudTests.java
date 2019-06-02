import PageObjects.PageObjectCrud;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CrudTests {

    private WebDriver driver;
    private PageObjectCrud pageObjectCrud;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
    }

    @Test
    void crudPageTitleTest() {
        pageObjectCrud = new PageObjectCrud(driver);
        assertTrue(pageObjectCrud.checkTitlePage());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
