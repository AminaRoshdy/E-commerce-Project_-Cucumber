package StepDefinition;
import Pages.CheckOutPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;


public class CheckoutProcess {

    ShoppingCartPage shopObj;
    CheckOutPage checkObj;

   @And("Approve the service terms and Click on checkout")
    public void Approve_ServiecTerms_AndOpenCheckoutPage()
   {
       shopObj= new ShoppingCartPage(Hook.driver);
       shopObj.SelectTermsofservice();
       shopObj.openCheckOutPage();

   }

   @And("^Enter the shipping details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void CheckOut_Product_Successfully(String city, String address, String code, String phone) throws InterruptedException {
       checkObj= new CheckOutPage(Hook.driver);
       checkObj.EnterBillingAddress(city,address,code,phone);

   }

   @Then("checkout complete successfully")
    public void Check_Is_Completed_Successfully()
   {
       Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       Assert.assertTrue(checkObj.successMessage.isDisplayed(),"issue of success message");
       Assert.assertTrue(checkObj.OrderNumberTxt.isDisplayed(),"issue of Order Number");
   }
}
