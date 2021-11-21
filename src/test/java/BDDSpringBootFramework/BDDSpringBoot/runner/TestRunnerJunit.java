package BDDSpringBootFramework.BDDSpringBoot.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@CucumberOptions(
        features ="src/test/java/BDDSpringBootFramework/BDDSpringBoot/functionaltestfeatures/",
        glue="BDDSpringBootFramework.BDDSpringBoot.stepdefinitions",
        plugin={"pretty","junit:target/cucumber-reports/Cucumber_Results.xml","json:target/cucumber-reports/Cucumber.json"}

)

@RunWith(Cucumber.class)
public class TestRunnerJunit
{
    @BeforeClass
    public static void setup()
    {
        System.out.println("Ran the before..");
    }
    @AfterClass
    public static void tearDown()
    {
        System.out.println("Ran the after..");
    }


}
