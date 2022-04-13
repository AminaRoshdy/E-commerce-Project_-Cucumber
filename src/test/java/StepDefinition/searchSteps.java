package StepDefinition;

import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class searchSteps {

    SearchPage searchObj;

    @Given("^Search by \"(.*)\"$")
    public void SearchByProductSuccessfully(String ProdName){
        searchObj= new SearchPage(Hook.driver);
        searchObj.SearchProduct(ProdName);
       Hook.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @When("Search result appear successfully")
    public void searchResultAppearSuccessfully()
    {
        Assert.assertTrue(searchObj.productsTitle.size()>0);
    }

    @Then("^The products of Title \"(.*)\" appear on search result$")
    public void SearchResultAppearCorrectely(String ProductName )
    {
        for (WebElement product: searchObj.productsTitle) {
            System.out.println(product.getText());
            Assert.assertTrue(product.getText().contains(ProductName));

        }
    }

}
