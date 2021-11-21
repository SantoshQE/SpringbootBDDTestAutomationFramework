package BDDSpringBootFramework.BDDSpringBoot.pages;

import BDDSpringBootFramework.BDDSpringBoot.objectrepository.Test_OR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Component
public class Testhomepage extends Basepage
{
    @FindBy(name= Test_OR.searchtextBox)
    public WebElement searchtextBox;

    @Autowired
    private WebDriver driver;

    @Autowired
    private Test_OR test_or;

    @PostConstruct
    public void initTestHomePage()   // because bean needs to be instantiated first in the page classses
    {
        PageFactory.initElements(driver, this);
    }

    @Value("${TestUrl}")
    public String TestUrl;

    public void navigateToTestHomePage(String env)
    {
        if(env.equalsIgnoreCase("ST"))
        {
            navigatePage(TestUrl);
            System.out.println("Application url launched in env : " +env + " application url launched is : "+TestUrl);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        else if(env.equalsIgnoreCase("ET"))
        {
            navigatePage(TestUrl);
            System.out.println("Application url launched in env : " +env + " application url launched is : "+TestUrl);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }
    public void searchText(String searchText)
    {
        searchtextBox.sendKeys(searchText);
    }
}
