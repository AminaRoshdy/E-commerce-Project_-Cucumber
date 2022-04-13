package StepDefinition;

import Pages.CompareListPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class compareList {

    SearchPage searchObj;
    ProductDetailsPage DetailsPage;
    CompareListPage compareObj;

    @When("Buttons of AddToComapreList appear successfully on searchlist")
    public void Buttons_OfAddToCompareList_Appear(){
        searchObj= new SearchPage(Hook.driver);
        Assert.assertTrue(searchObj.ComparetBtn.size()>0);
        System.out.println(searchObj.ComparetBtn.size());

    }
    @And("click on button AddToComapreList of first product")
    public void AddProductsToCompareList_FromSearchResult() throws InterruptedException {
        searchObj.AddProductToCompareList();

    }

    @Then("selected product is added to compare list successfully")
    public void Product_Added_To_CompareList_Successfully() throws InterruptedException {
        compareObj= new CompareListPage(Hook.driver);
        Thread.sleep(2000);
        Assert.assertTrue(compareObj.compareListMessage.isDisplayed());

    }

    @And("add current product to compare list from details page")
    public void Add_Product_ToCompareList_FromDetailsPgae()
    {
        DetailsPage= new ProductDetailsPage(Hook.driver);
        DetailsPage.AddProductToCompareList();
    }



}
