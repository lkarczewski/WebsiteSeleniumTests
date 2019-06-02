package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCrudEdit {

    public WebDriver driver;
    private WebDriverWait wait;

    public PageObjectCrudEdit(WebDriver driver) {
        this.driver = driver;
        driver.get("https://crud-post.herokuapp.com/posts/");
        wait = new WebDriverWait(driver, 15);
    }

    public void editPost() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//tr[td[2]//text()[contains(., 'Post testowy')]]/td[6]//a[@class='btn btn-primary btn-xs']"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.id("post_title")).clear();
        driver.findElement(By.id("post_title")).sendKeys("Nowy post testowy");
        driver.findElement(By.name("commit")).click();
    }

    public void editPostIncorrect() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//tr[td[2]//text()[contains(., 'Post testowy')]]/td[6]//a[@class='btn btn-primary btn-xs']"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.id("post_title")).clear();
        driver.findElement(By.name("commit")).click();
    }

    public String getResult() {
        String result = driver.findElement(By.className("container")).getText();
        return result;
    }
}
