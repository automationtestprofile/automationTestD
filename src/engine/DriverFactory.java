package engine;

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
                    System.setProperty("webdriver.chrome.driver", "src//resources//chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
                case IE:
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
