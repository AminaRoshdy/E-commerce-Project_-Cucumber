package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class loginSteps{
    HomePage homeObj;
    RegisterationPage registerObj;
    LoginPage loginObj;

    @Given("Click on Login Link")
    public void UserLogin() throws InterruptedException {
        loginObj= new LoginPage(Hook.driver);
        homeObj= new HomePage(Hook.driver);
        Thread.sleep(1000);
        homeObj.loginLink().click();

    }

    @When("^user enter \"(.*)\" and \"(.*)\", and click login button$")
    public void EnterLoginData(String email, String pass) throws InterruptedException {

        loginObj.userLogin(email, pass);
        Thread.sleep(1000);
    }

    @Then("User LOgin Successfully")
    public void userLoginSuccessfully()
    {
        registerObj= new RegisterationPage(Hook.driver);
        Assert.assertTrue(registerObj.logoutLink.isDisplayed());
    }


}
