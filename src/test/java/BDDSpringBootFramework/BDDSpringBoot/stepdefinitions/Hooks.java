package BDDSpringBootFramework.BDDSpringBoot.stepdefinitions;

import BDDSpringBootFramework.BDDSpringBoot.utils.Commonutils;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.lang.UnhandledException;
import org.junit.After;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;

import java.io.IOException;

public class Hooks {

    @Autowired
    private WebDriver driver;

    @Autowired
    private Commonutils commonutils;

    @After
    public void TearDownTest(Scenario scenario) throws IOException
    {
        if(!scenario.isFailed())
        {

        }else
        {

        }
    }

    @AfterStep
    public void TakeScreenshot(Scenario scenario) throws IOException
    {
        try{
            byte[] screenshot = this.commonutils.takeScreenshotAsBYTES();
            scenario.attach(screenshot,"image/png", "Screenshot");
        }catch(UnhandledAlertException alertException)
        {

        }
    }

}
