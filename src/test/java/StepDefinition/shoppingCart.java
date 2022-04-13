package StepDefinition;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class shoppingCart {

     SearchPage searchObj;
     ShoppingCartPage shopObj;
     HomePage homeObj;
     ProductDetailsPage productObj;

    @And("Buttons of add to shopping cart appear successfully on search list")
    public void ButtonsOf_AddToShoppingCart_Appear()
    {
         searchObj = new SearchPage(Hook.driver);
         int count= searchObj.AddToCartBtn.size();
         Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (int i = 0; i < count; i++) {
            Assert.assertTrue(searchObj.AddToCartBtn.get(i).isDisplayed());

        }
    }

    @And("Add first product to Shopping cart")
    public void Add_Product_To_ShoppingCart()
    {
         searchObj.AddProductToCart();

    }

    @Then("selected product is added to shopping cart successfully")
    public void Product_Added_To_ShoppingCart_Successfully()
    {
        shopObj= new ShoppingCartPage(Hook.driver);
        homeObj= new HomePage(Hook.driver);
        Hook.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(shopObj.ShoppingCartSuccessMessage.isDisplayed());
        Assert.assertTrue(homeObj.ShoppingCartCount.getText().contains("(1)"), "issue of Number of products on shopping cart");

    }

    @And("Button of Add shopping cart is displayed and enabled")
    public void Button_Of_AddtoShoppingCart_Appear()
    {
        productObj= new ProductDetailsPage(Hook.driver);
        Assert.assertTrue(productObj.AddToCartBtn.isDisplayed());
    }

    @And("Add Current Product to shopping cart")
    public void Add_Current_Product_AddtoShoppingCart()
    {
       productObj.AddProductToShoppingCart();
    }

    @And("Open shopping cart")
    public void Open_ShoppingCart_Successfully()
    {
       homeObj= new HomePage(Hook.driver);
       shopObj= new ShoppingCartPage(Hook.driver);
       homeObj.OpenShoppingCart();
    }

    @And("Remove all products from shopping cart")
    public void Remove_Products_From_ShoppingCart_successflly ()
    {
        Hook.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        shopObj.RemoveProductFromShoppingCART();
    }

    @And("The products are removed from shopping cart successfully")
    public void RemoveProductFromShoppingCart()
    {
        Hook.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(shopObj.NoDataMessage.getText().contains("Your Shopping Cart is empty!"));
        Assert.assertTrue(homeObj.ShoppingCartCount.getText().contains("(0)"));

    }
}
