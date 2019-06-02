import PageObjects.PageObjectCrud;
import PageObjects.PageObjectCrudAdd;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CrudTests {

    private WebDriver driver;
    private PageObjectCrud pageObjectCrud;
    private PageObjectCrudAdd pageObjectCrudAdd;

    @BeforeEach
    void setUp() {
        driver = BrowserManager.initializeBrowser(driver, "Chrome");
    }

    @Test
    void crudPageTitleTest() {
        pageObjectCrud = new PageObjectCrud(driver);
        assertTrue(pageObjectCrud.checkTitlePage());
    }

    @Test
    void crudAddCorrectPostTest() {
        pageObjectCrudAdd = new PageObjectCrudAdd(driver);
        pageObjectCrudAdd.addCorrectPost();
        String result = pageObjectCrudAdd.getResult();
        assertThat(result).contains("Post dodany pomyślnie");
    }

    @Test
    void crudAddEmptyPostTest() {
        pageObjectCrudAdd = new PageObjectCrudAdd(driver);
        pageObjectCrudAdd.addEmptyPost();
        String result = pageObjectCrudAdd.getResult();
        assertThat(result).contains("Wystąpiły błędy");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
