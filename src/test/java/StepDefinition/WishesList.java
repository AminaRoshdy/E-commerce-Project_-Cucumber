package StepDefinition;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishesListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class WishesList {
    WishesListPage wishesObj;
    SearchPage searchObj;
    HomePage homeObj;
    ProductDetailsPage productObj;

    @When("Buttons of AddToWishesList appear successfully on searchlist")
    public void Buttons_ofWishesList_Appear_Successfully()
    {
        wishesObj= new WishesListPage(Hook.driver);
        searchObj= new SearchPage(Hook.driver);
        Assert.assertTrue(searchObj.WishesListBtns.size()>0);
        System.out.println("Number of Products on search result: "+searchObj.WishesListBtns.size());
    }

    @And("click on button AddToWishesList of first product")
    public void Add_Product_To_WishesList() throws InterruptedException {

        searchObj.AddProductToWishesListFromSearchResult();

    }

    @Then("selected product is added to wishes list successfully")
    public void Product_Is_AddedTo_WishesList_Successfully() throws InterruptedException {
        homeObj= new HomePage(Hook.driver);
        Assert.assertTrue(homeObj.AddtoWishesList_Message.isDisplayed());
        Thread.sleep(2000);
        Assert.assertTrue(homeObj.WishListCount.getText().contains("(1)"));
    }

    @And("open details page of a product")
    public void OpenDetailsPageOfProduct() throws InterruptedException {
        searchObj=new SearchPage(Hook.driver);
        searchObj.OpenDetailsPageofProduct();
        Thread.sleep(2000);

    }

    @And("add current product to wishes list")
    public void Add_product_toWishesList_from_DetailsPage() {
        productObj= new ProductDetailsPage(Hook.driver);
        Assert.assertTrue(productObj.AddWishBtn.isDisplayed());
        productObj.AddToWishListFromProductDetails();

    }

    @And("Open Wishes List")
    public void Open_WishesList_Page() throws InterruptedException {
        homeObj= new HomePage(Hook.driver);
        homeObj.OpenWishesList();
        Thread.sleep(1000);
        wishesObj.removeProsudtFromWishesList();
        Assert.assertTrue(wishesObj.NoDataMessage.getText().contains("The wishlist is empty!"));

    }

    @And("Remove the product from wishes list")
    public void Remove_Product_From_WishesList()  {
        wishesObj.removeProsudtFromWishesList();
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Then("the product is removed successfully from wishes wishes list")
    public void Product_IsRemoved_From_WishesList_Successfully()  {
        Assert.assertTrue(wishesObj.NoDataMessage.getText().contains("The wishlist is empty!"));

    }
}
