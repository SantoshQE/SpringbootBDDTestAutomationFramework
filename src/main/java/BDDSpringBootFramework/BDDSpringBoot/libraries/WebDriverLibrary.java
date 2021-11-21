package BDDSpringBootFramework.BDDSpringBoot.libraries;

import com.microsoft.edge.seleniumtools.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.logging.Level;

@Configuration
public class WebDriverLibrary
{
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
    private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

    @Value("${ChromedriverPath}")
    public String getChromeDriverPath;
    @Value("${IEdriverPath}")
    public String getIEDriverPath;
    @Value("${EdgedriverPath}")
    public String getEdgeDriverPath;
   /* @Value("${ChromeBinaryDriverPath}")
    public String getChromeBinaryDriverPath;*/

    @Bean
    @ConditionalOnProperty(name="browser" , havingValue = "chrome")
    public WebDriver getChromeDriver() throws IOException
    {
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver_v92.exe");
        WebDriver driver;
        System.setProperty(CHROME_DRIVER_PROPERTY,getChromeDriverPath);
        String folder = "user-data-dir=" + System.getenv("APPDATA") +"\\Chrome\\Datadir";
        ChromeOptions options = new ChromeOptions();
        options.addArguments();  // add folder if u are running in virtual machine
        LoggingPreferences logPrefs =  new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        return new ChromeDriver(options);
    }
    @Bean
    @ConditionalOnProperty(name="browser" , havingValue = "chrome-incognito")
    public WebDriver getChromeDriverIncognito() throws IOException
    {
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver_v92.exe");
        WebDriver driver;
        System.setProperty(CHROME_DRIVER_PROPERTY,getChromeDriverPath);
        String folder = "user-data-dir=" + System.getenv("APPDATA") +"\\Chrome\\Datadir";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(folder);
        LoggingPreferences logPrefs =  new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
    @Bean
    @ConditionalOnProperty(name="browser" , havingValue = "headless-chrome")
    public WebDriver getHeadlessChromeDriver() throws IOException
    {
        Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver_v92.exe");
        WebDriver driver;
        System.setProperty(CHROME_DRIVER_PROPERTY,getChromeDriverPath);
        String folder = "user-data-dir=" + System.getenv("APPDATA") +"\\Chrome\\Datadir";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(folder);
        LoggingPreferences logPrefs =  new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
    @Bean
    @ConditionalOnProperty(name="browser" , havingValue = "ie")
    public WebDriver getIEDriver() throws IOException
    {
        Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
        WebDriver driver;
        System.setProperty(IE_DRIVER_PROPERTY,getIEDriverPath);
        InternetExplorerOptions IEOption = new InternetExplorerOptions();
        IEOption.destructivelyEnsureCleanSession();
        IEOption.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
        IEOption.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, "true");
        IEOption.setCapability(InternetExplorerDriver.NATIVE_EVENTS, "false");
        IEOption.setCapability("requireWindowFocus", "true");
        return new InternetExplorerDriver(IEOption);
    }
    @Bean
    @ConditionalOnProperty(name="browser" , havingValue = "edge")
    public WebDriver getEdgeDriver() throws IOException
    {
        Runtime.getRuntime().exec("taskkill /F /IM msedge.exe");
        WebDriver driver;
        System.setProperty(EDGE_DRIVER_PROPERTY, getEdgeDriverPath);
        String folder = "user-data-dir=" + System.getenv("APPDATA") +"\\EdgeChromium\\Datadir";
        EdgeOptions edgeOptions = new EdgeOptions();
        return new EdgeDriver(edgeOptions);
    }
}
