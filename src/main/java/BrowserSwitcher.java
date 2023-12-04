import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSwitcher {
    public static WebDriver get(String browserName) {
        WebDriver webDriver;
        switch (browserName) {
            case "chrome":
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        return webDriver;
    }
}
