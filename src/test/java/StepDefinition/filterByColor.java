package StepDefinition;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SubCategoryListingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class filterByColor {

    HomePage home;
    SubCategoryListingPage subObj;
    ProductDetailsPage detaiLsOBJ;
    boolean colorFlag=false;

    @Given("Open list of Apperal  category and select Shoes sub category")
    public void Open_ApperalCategory_And_Shoes_suBcategory() throws InterruptedException {
        Thread.sleep(1000);
        home= new HomePage(Hook.driver);
        home.openApperalCategoryMenu();
        Thread.sleep(2000);
    }

    @And("page of shoes sub category open successfully")
    public void Open_Page_Shoes_Successfully() throws InterruptedException {
        Assert.assertTrue(Hook.driver.getCurrentUrl().contains("shoes"));
    }

    @When("select a color")
    public  void Select_Color() throws InterruptedException {
        subObj= new SubCategoryListingPage(Hook.driver);
        subObj.FilterByRedColor();
        Thread.sleep(2000);

    }

    @Then("the products are filtered by selected color")
    public void products_are_filtered_By_selected_Color()
    {
        Assert.assertTrue(subObj.RedColorCheckBox.isSelected());

    }

    @And("the selected color appear in details page of products")
    public void Color_Appear_in_DetailsPage_of_Product()
    {

        detaiLsOBJ= new ProductDetailsPage(Hook.driver);
        subObj.OpenDetailsPageOfFirstProduct();
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        int colorCount= detaiLsOBJ.ColorBoxes.size();
        for (int i = 0; i < colorCount; i++) {
            if (detaiLsOBJ.ColorBoxes.get(i).getCssValue("background-color").contains("rgba(102, 48, 48, 1)"))
            {
                colorFlag=true;
                break;
            }
        }
        System.out.println("the available color Of the product = "+detaiLsOBJ.ColorBoxes.get(0).getCssValue("background-color"));
        Assert.assertTrue(colorFlag);
    }

}
