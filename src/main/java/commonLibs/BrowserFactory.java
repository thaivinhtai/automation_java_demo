package commonLibs;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;


public class BrowserFactory {

    private static final Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = drivers.get("Firefox");
                if (driver == null) {
                    driver = new FirefoxDriver();
                    drivers.put("Firefox", driver);
                }
                break;
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = drivers.get("Chrome");
                if (driver == null) {
                    driver = new ChromeDriver();
                    drivers.put("Chrome", driver);
                }
                break;
        }
        return driver;
    }
}
