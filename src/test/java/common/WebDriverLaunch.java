package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverLaunch{
    public static WebDriver driver;
    public static Logger log = Logger.getLogger(WebDriverLaunch.class);
    private static final String BROWSER = System.getProperty("BROWSER", "chrome");

    @BeforeClass
    public void setupWebDriver() {
        DOMConfigurator.configure("log4j.xml");
        setupLocalDriver();
        driver.manage().window().maximize();
        driver.get("https://llevvia.aaps.deloitte.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void setupLocalDriver() {
        switch (BROWSER) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("FIREFOX BROWSER IS LAUNCHING.");
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("CHROME BROWSER IS LAUNCHING.");
                break;
            case "internetExplorer":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                log.info("INTERNET EXPLORER BROWSER IS LAUNCHING.");
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                log.info("MICROSOFT EDGE BROWSER IS LAUNCHING.");
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                log.info("OPERA BROWSER IS LAUNCHING.");
                break;
            case "safari":
                WebDriverManager.operadriver().setup();
                driver = new SafariDriver();
                log.info("SAFARI BROWSER IS LAUNCHING.");
                break;
            default:
                throw new RuntimeException("Browser type unsupported.");
        }
    }

    @AfterClass
    public void TearDown() {
        log.info("Quit driver / browser.");
        driver.quit();
    }
}
