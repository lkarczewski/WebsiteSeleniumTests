package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCrud {

    public WebDriver driver;
    private WebDriverWait wait;

    public PageObjectCrud(WebDriver driver) {
        this.driver = driver;
        driver.get("https://crud-post.herokuapp.com/");
        wait = new WebDriverWait(driver, 15);
    }

    public boolean checkTitlePage() {
        Boolean result = driver.getTitle().contains("Crud");
        return result;
    }
}
