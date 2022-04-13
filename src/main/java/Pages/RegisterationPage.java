package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterationPage extends PageBase{

    public RegisterationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "gender-male")
    WebElement MaleRadioBtn;

    @FindBy (id="gender-female")
    WebElement FemaleRadioBtn;

    @FindBy (id="FirstName")
    WebElement FirstNameTxtBox;

    @FindBy (id="LastName")
    WebElement LastNameTxtBox;

    @FindBy (xpath = "//select[@name=\"DateOfBirthDay\"]")
    WebElement DayBirth;

    @FindBy (xpath = "//select[@name=\"DateOfBirthMonth\"]")
    WebElement MonthBirth;

    @FindBy (xpath ="//select[name=\"DateOfBirthYear\"]")
    WebElement YearBirth;

    @FindBy (id="Email")
    WebElement EmailTxtBox;

    @FindBy (id = "Password")
    WebElement PassTxtBox;

    @FindBy(id="ConfirmPassword")
    WebElement ConfirmPassTxtBox;

    @FindBy (id="register-button")
    public WebElement RegisterBtn;

    @FindBy (xpath = "//div[@class=\"result\"]")
    public WebElement successMeg;

    @FindBy (css="a[href=\"/logout\"]")
    public WebElement logoutLink;

    @FindBy (linkText = "My account")
    WebElement MyAccountLink;


    // Fill the Form of Registeration and then Register
    public void Regiseration(String Fname, String Lname, String Email, String passWord)
   {
        clickONButton(MaleRadioBtn);
        InsertDataTextBox(FirstNameTxtBox, Fname);
        InsertDataTextBox(LastNameTxtBox,Lname);
        InsertDataTextBox(EmailTxtBox,Email);
        InsertDataTextBox(PassTxtBox,passWord);
        InsertDataTextBox(ConfirmPassTxtBox,passWord);
       // clickONButton(RegisterBtn);

    }

    public void userLogout()
    {
        clickONButton(logoutLink);
    }

    public void OpenMyAccountPage()
    {
        clickONButton(MyAccountLink);
    }

}
