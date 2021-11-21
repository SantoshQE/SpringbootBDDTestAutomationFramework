package BDDSpringBootFramework.BDDSpringBoot.utils;

import BDDSpringBootFramework.BDDSpringBoot.pages.Basepage;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

@Component
public class Commonutils extends Basepage
{
    private static final Logger logger = LoggerFactory.getLogger(Commonutils.class);
    public static String child_window;

    @Autowired
    private WebDriver driver;
    static JavascriptExecutor js;

    public void switchToBrowserwindowByName(String browserName)
    {
        String windowHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            boolean windowFound = false;
            driver.switchTo().window(winHandle);
            String wintitle = driver.getTitle();
            try{
                if(wintitle.contains(browserName))
                {
                    driver.switchTo().window(winHandle);
                    break;
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void closeBrowserbyName(String browserName)
    {
        Set<String> s1=  driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while(i1.hasNext())
        {
            child_window = i1.next();
            String browserTitle = driver.switchTo().window(child_window).getTitle();
            if(browserTitle.contains(browserName))
            {
                driver.switchTo().window(child_window);
                driver.close();
                break;
            }
        }
    }
    public byte[] takeScreenshotAsBYTES() throws IOException
    {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }


}
