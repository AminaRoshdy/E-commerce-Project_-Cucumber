package StepDefinition;
import Pages.MyAccountPage;
import Pages.RegisterationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class myAccount {

    MyAccountPage myAccountObj;
    RegisterationPage registerObj;

    @When("Open My Account Page")
    public void Open_MyAccount_Page_Successfully () throws InterruptedException
    {
        Thread.sleep(2000);
        registerObj= new RegisterationPage(Hook.driver);
        registerObj.OpenMyAccountPage();
       // Assert.assertTrue(Hook.driver.getCurrentUrl().contains("info"));

    }

    @And("Open change password page")
    public void Open_ChangePassword_form_Successfully ()
    {
        myAccountObj= new MyAccountPage(Hook.driver);
        Hook.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        myAccountObj.OpenChangePasswordForm();
        Assert.assertTrue(Hook.driver.getCurrentUrl().contains("changepassword"));
    }

    @And("^Enter new and confirm password \"(.*)\",\"(.*)\",\"(.*)\" and click change password$")
    public void ChangePassword(String oldPass,String newPass,String confirmPass) throws InterruptedException
    {
        myAccountObj.ChangePassword(oldPass, newPass, confirmPass);
        Thread.sleep(2000);

    }

    @Then("the password is changed successfully")
    public void ChangePassword_Successfully()
    {
        Assert.assertTrue(myAccountObj.SuccessMessage.getText().contains("Password was changed"));
    }

}
