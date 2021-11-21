package BDDSpringBootFramework.BDDSpringBoot.stepdefinitions;

import BDDSpringBootFramework.BDDSpringBoot.pages.Testhomepage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class Teststeps
{
    @Autowired
    private WebDriver driver;

    @Autowired
    public Testhomepage testhomepage;


    @Given("User is on google page in {string} environment")
    public void userIsOngooglePage(String environment)
    {
        System.out.println("inside userIsOngooglePage");
        if(environment.equalsIgnoreCase("ST"))
        {
            System.out.println("Running on ST...");
            testhomepage.navigateToTestHomePage("ST");
        }
        else if(environment.equalsIgnoreCase("ET"))
        {
            System.out.println("Running on ET...");
            testhomepage.navigateToTestHomePage("ET");
        }
    }
    @Then("enter searchtext as {string}")
    public void enterSerchText(String searchText)
    {
        System.out.println("search text is : "+searchText);
        testhomepage.searchText(searchText);
    }
}
