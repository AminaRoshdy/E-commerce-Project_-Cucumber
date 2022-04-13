package StepDefinition;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;

public class selectCategory {

    HomePage home;

    @Given("Open list of main category and select sub category")
    public void Select_Category_And_suBcategory_Successfully () throws InterruptedException {
        Thread.sleep(1000);
        home= new HomePage(Hook.driver);
        home.openCategoryMenu();
        Thread.sleep(2000);
    }

    @Then("page of selected sub category open successfully")
    public void Open_suBcategory_Successfully () throws InterruptedException {
        Assert.assertTrue(Hook.driver.getCurrentUrl().contains("desktops"));
    }

}
