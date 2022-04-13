package StepDefinition;

import Pages.SubCategoryListingPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class selectTags {
    SubCategoryListingPage subObj;

    @When("the list of tags appears successfully")
    public void Tags_Appear_Successfully ()
    {
        subObj=new SubCategoryListingPage(Hook.driver);
        int tagCount= subObj.tagsList.size();
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (int i = 0; i < tagCount; i++) {
            Assert.assertTrue(subObj.tagsList.get(i).isDisplayed());

        }
    }

    @Then("select a tag")
    public void select_Tag_Awesome_Successfully ()
    {
        subObj.OpenTagLink();
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(Hook.driver.getCurrentUrl().contains("awesome"), "the URL not contain the tage name !!");
        Assert.assertTrue(subObj.tagPageTitle.getText().contains("Products tagged with 'awesome'"), "The Title not Contain the tag Name!!");
    }

    @And("the products are filtered by selected tag")
    public void Products_Are_Filtered_By_tag_Successfully ()
    {
        Assert.assertTrue(Hook.driver.getCurrentUrl().contains("awesome"), "the URL not contain the tage name !!");
        Assert.assertTrue(subObj.tagPageTitle.getText().contains("Products tagged with 'awesome'"), "The Title not Contain the tag Name!!");
    }

}
