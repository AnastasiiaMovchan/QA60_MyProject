package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private WebDriver driver;
    public void init() {
        driver = new ChromeDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
