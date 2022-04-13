package StepDefinition;
import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;


public class ChangeCurrency {

    HomePage homeObj;
    SearchPage searchObj;

    @When("^Change Currency to \"(.*)\"$")
    public void Select_Euro_Currency(String currency) {
        homeObj= new HomePage(Hook.driver);
        homeObj.changeCurrency(currency);
    }

    @Then("The currency of products is changes to Euro successfully")
    public void currency_Changed_To_Euro_Successfully () throws InterruptedException {
        searchObj= new SearchPage(Hook.driver);
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (WebElement Price: searchObj.ProductPricesLbl) {
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("€"));
        }
    }


    @Then("The currency of products is changes to dollar successfully")
    public void currency_Changed_To_Dollar_Successfully () throws InterruptedException {
        searchObj= new SearchPage(Hook.driver);
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        for (WebElement Price: searchObj.ProductPricesLbl) {
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("$"));
        }
    }

}
