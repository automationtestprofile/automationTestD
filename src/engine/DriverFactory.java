package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import engine.enums.Browsers;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public final class DriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        try {
            Browsers browser = Browsers.valueOf(browserName.toUpperCase());
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("Browser is missing.");
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Browser is not supported");
        }
        return driver;
    }
}
