package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends PageBase{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "tr")
    public List<WebElement> NumberofProductsonCart;

    @FindBy (xpath = "//button[@class=\"remove-btn\"]")
    List<WebElement> RemoveProductIcons;

    @FindBy (id="checkout")
    WebElement CheckoutBtn;

    @FindBy (xpath = "//div[@class=\"no-data\"]")
    public WebElement NoDataMessage;

    @FindBy (id="termsofservice")
    WebElement termsOfServiveCheckBox;

    @FindBy (linkText = "shopping cart")
    public WebElement ShoppingCartSuccessMessage;


    public void SelectTermsofservice()
    {
        clickONButton(termsOfServiveCheckBox);
    }

    public void openCheckOutPage()
    {
        clickONButton(CheckoutBtn);
    }

    public void RemoveProductFromShoppingCART()
    {
        for( WebElement icon: RemoveProductIcons)
        {
            clickONButton(RemoveProductIcons.get(0));
        }
    }




}
