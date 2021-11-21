package BDDSpringBootFramework.BDDSpringBoot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class Basepage
{
    @Autowired
    public WebDriver driver;

    @PostConstruct
    public void initPage()
    {
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @PreDestroy
    public void preDestroy()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    public void navigatePage(String url)
    {
        driver.navigate().to(url);
    }
    public void closeBrowser()
    {
        driver.close();
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}
