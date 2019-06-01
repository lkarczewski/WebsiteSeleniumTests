public class BrowserSelector {
    public static void setBrowserProperty(String browser) {
        if (System.getProperty("os.name").contains("Windows")) {
            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                    break;
                case "Opera":
                    System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
                    break;
            }
        } else {
            switch (browser) {
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                    break;
                case "Firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                    break;
                case "Opera":
                    System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver");
                    break;
            }
        }
    }
}
