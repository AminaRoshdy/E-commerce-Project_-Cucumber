package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="OldPassword")
    WebElement OldPassTxt;

    @FindBy (id="NewPassword")
    WebElement NewPassTxt;

    @FindBy (id="ConfirmNewPassword")
    WebElement ConfirmPassTxt;

    @FindBy (css = "button[class=\"button-1 change-password-button\"]")
    WebElement ChangePassBtn;

    @FindBy (css = "p[class=\"content\"]")
    public WebElement SuccessMessage;

    @FindBy(css = "a[href=\"/customer/changepassword\"]")
     public WebElement ChangePasswordLink;

    public void OpenChangePasswordForm()
    {
        clickONButton(ChangePasswordLink);
    }


    public void ChangePassword(String oldPass , String newPass, String confirmPass)
    {
        InsertDataTextBox(OldPassTxt, oldPass);
        InsertDataTextBox(NewPassTxt, newPass);
        InsertDataTextBox(ConfirmPassTxt, confirmPass);
        clickONButton(ChangePassBtn);
    }
}
