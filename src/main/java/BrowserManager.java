import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class BrowserManager {

    public static WebDriver initializeBrowser(WebDriver driver, String browser) {

        BrowserSelector.setBrowserProperty(browser);

        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Opera":
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary("usr/bin/opera");
                driver = new OperaDriver(operaOptions);
                break;
        }

        return driver;
    }
}
