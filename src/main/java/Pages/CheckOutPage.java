package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="BillingNewAddress_FirstName")
    WebElement FnameTxtBox;

    @FindBy (id="BillingNewAddress_LastName")
    WebElement LnameTxtBox;

    @FindBy (id="BillingNewAddress_Email")
    WebElement EmailTxtBox;

    @FindBy (id="BillingNewAddress_CountryId")
    WebElement CountryDDL;

    @FindBy (id="BillingNewAddress_City")
    WebElement CityTxtBox;

    @FindBy (id="BillingNewAddress_Address1")
    WebElement Address1TxtBox;

    @FindBy (id="BillingNewAddress_ZipPostalCode")
    WebElement ZipCodeTxtBox;

    @FindBy (id="BillingNewAddress_PhoneNumber")
    WebElement PhoneTxtBox;

    @FindBy (xpath = "//div[@id=\"billing-buttons-container\"]//button[@class=\"button-1 new-address-next-step-button\"]")
    WebElement ContinueBtn;

    @FindBy (id="shippingoption_1")
    WebElement ShippTimeRadio;

    @FindBy (xpath = "//div[@id=\"shipping-method-buttons-container\"]//button[@class=\"button-1 shipping-method-next-step-button\"]")
    WebElement NextToPaymentBtn1;

    @FindBy (xpath = "//div[@id=\"payment-method-buttons-container\"]//button[@class=\"button-1 payment-method-next-step-button\"]")
    WebElement NextToPaymentBtn2;

    @FindBy (xpath = "//div[@id=\"payment-info-buttons-container\"]//button[@class=\"button-1 payment-info-next-step-button\"]")
    WebElement NextToConfirmBtn;

    @FindBy (xpath = "//div[@id=\"confirm-order-buttons-container\"]//button[@class=\"button-1 confirm-order-next-step-button\"]")
    WebElement ConfirmBtn;

    //@FindBy (linkText = "Your order has been successfully processed!")
    @FindBy (css="div.title")
    public WebElement successMessage;

    @FindBy (xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[1]")
    public WebElement OrderNumberTxt;

    @FindBy (linkText = "Click here for order details.")
    WebElement viewOrderDetailsLink;

    @FindBy (xpath = "//div[@class=\"page order-details-page\"]//button[@class=\"button-2 print-order-button\"]")
    WebElement PrintOrderBtn;

    @FindBy (xpath = "//div[@class=\"page order-details-page\"]//button[@class=\"button-2 pdf-invoice-button\"]")
    WebElement PDFinvoiceBtn;


    public void  EnterBillingAddress(String city, String Address, String ZipCode, String Phone) throws InterruptedException {

        select= new Select(CountryDDL);
        clickONButton(CountryDDL);
        select.selectByVisibleText("Egypt");
        InsertDataTextBox(CityTxtBox, city);
        InsertDataTextBox(Address1TxtBox, Address);
        InsertDataTextBox(ZipCodeTxtBox, ZipCode);
        InsertDataTextBox(PhoneTxtBox,Phone);
        clickONButton(ContinueBtn);
        Thread.sleep(2000);
        clickONButton(ShippTimeRadio);
        clickONButton(NextToPaymentBtn1);
        Thread.sleep(2000);
        clickONButton(NextToPaymentBtn2);
        Thread.sleep(1000);
        clickONButton(NextToConfirmBtn);
        Thread.sleep(1000);
        clickONButton(ConfirmBtn);

    }

    public void openOrderDetailsPage()
    {
        clickONButton(viewOrderDetailsLink);
    }

}
