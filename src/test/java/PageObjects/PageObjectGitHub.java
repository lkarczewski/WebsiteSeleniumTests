package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectGitHub {

    public WebDriver driver;
    private WebDriverWait wait;

    public PageObjectGitHub(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.github.com");
        wait = new WebDriverWait(driver, 15);
    }

    public boolean checkPageTitle() {
        Boolean result = driver.getTitle().contains("GitHub");
        return result;
    }
}
