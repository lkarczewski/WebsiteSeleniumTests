package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectCrudDelete {

    public WebDriver driver;
    private WebDriverWait wait;

    public PageObjectCrudDelete(WebDriver driver) {
        this.driver = driver;
        driver.get("https://crud-post.herokuapp.com/posts/");
        wait = new WebDriverWait(driver, 15);
    }

    public void deletePost() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//tr[td[2]//text()[contains(., 'Nowy post testowy')]]/td[6]//a[@class='btn btn-danger btn-xs']"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Tak")).click();
    }

    public void doNotDeletePost() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//tr[td[2]//text()[contains(., 'Nowy post testowy')]]/td[6]//a[@class='btn btn-danger btn-xs']"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Nie")).click();
    }

    public String getResult() {
        String result = driver.findElement(By.className("container")).getText();
        return result;
    }
}
