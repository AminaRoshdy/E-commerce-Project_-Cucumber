package StepDefinition;

import Pages.HomePage;
import Pages.RegisterationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.Assert;




public class registerationSteps{
    HomePage homeObj;
    RegisterationPage registerObj;


     @Given("user Click on Rigster Link")
     public void ClickRegisterLink() {

         registerObj= new RegisterationPage(Hook.driver);
         homeObj= new HomePage(Hook.driver);
         homeObj.RegisterLink.click();
     }

     @And("^user enter regiseration data \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
     public void EnterRegisterData(String name, String Lname, String Emial, String pass)
     {
         homeObj.OpenRegisterationForm();
         registerObj.Regiseration(name, Lname, Emial, pass);
         registerObj.RegisterBtn.click();
     }

     @Then("user Register Successfully")
     public void RegisterSuccessfully() throws InterruptedException {
         Assert.assertTrue(registerObj.successMeg.getText().contains("Your registration completed"));
         Thread.sleep(2000);
     }

    @And("user can Logout successfully")
    public void userLogout()
    {
        registerObj= new RegisterationPage(Hook.driver);
        registerObj.userLogout();
        Assert.assertTrue(homeObj.LoginLink.isDisplayed());
    }



    @And("open My Account Page")
    public void openMyAccountPage() throws InterruptedException {
        registerObj= new RegisterationPage(Hook.driver);
        registerObj.OpenMyAccountPage();
        Thread.sleep(2000);
    }




}
