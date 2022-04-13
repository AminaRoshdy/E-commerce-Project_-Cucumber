package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id="Email")
    WebElement emailTXT;

    @FindBy (id="Password")
    WebElement passTxt;

    @FindBy (xpath = "//button[@class=\"button-1 login-button\"]")
    WebElement LoginBtn;

    @FindBy (css= "div[class=\"message-error validation-summary-errors\"]")
    public WebElement LoginErrorMgs;


    public void userLogin( String email, String pass)
    {
        InsertDataTextBox(emailTXT, email);
        InsertDataTextBox(passTxt,pass);
        clickONButton(LoginBtn);
    }
}
