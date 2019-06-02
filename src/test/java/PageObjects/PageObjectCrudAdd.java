package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCrudAdd {

    public WebDriver driver;
    private WebDriverWait wait;

    public PageObjectCrudAdd(WebDriver driver) {
        this.driver = driver;
        driver.get("https://crud-post.herokuapp.com/posts/new");
        wait = new WebDriverWait(driver, 15);
    }

    public void addCorrectPost() {
        String title = "Post testowy (min. 2 znaki)";
        String author = "Autor testowy (min. 2 znaki)";
        String content = "Testowa treść (min. 10 znaków)";

        driver.findElement(By.id("post_title")).sendKeys(title);
        driver.findElement(By.id("post_author")).sendKeys(author);
        driver.findElement(By.id("post_body")).sendKeys(content);
        driver.findElement(By.name("commit")).click();
    }

    public void addEmptyPost() {
        driver.findElement(By.name("commit")).click();
    }

    public String getResult() {
        String result = driver.findElement(By.className("container")).getText();
        return result;
    }
}
