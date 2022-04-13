package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        JavaEx= (JavascriptExecutor)driver;
        action= new Actions(driver);
    }

    @FindBy (linkText= "Register")
    public WebElement RegisterLink;

    @FindBy (xpath = "//a[@class=\"ico-login\"]")
    public WebElement LoginLink;

    public WebElement loginLink()
    {
        return driver.findElement(By.xpath("//a[@class=\"ico-login\"]"));
    }

    @FindBy (css = "img[alt=\"nopCommerce demo store\"]")
    public WebElement HomeLink;

    @FindBy (xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement ComputerCategory;

    @FindBy (xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    WebElement DesktopsubCategory;

    @FindBy (xpath = "//ul[@class=\"top-menu notmobile\"]//a[@href=\"/apparel\"]")
    WebElement ApparelCategorLink;

    @FindBy (xpath = "/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a")
    WebElement ShoesSubCategoryLink;

    @FindBy (id="customerCurrency")
    WebElement CurrenceDDL;

    @FindBy (css="span[class=\"wishlist-qty\"]")
    public WebElement WishListCount;

    @FindBy (xpath="//a[@href=\"/wishlist\"]")
    WebElement WishesListLink;

    @FindBy (css="span[class=\"cart-qty\"]")
    public WebElement ShoppingCartCount;

    @FindBy (xpath="//a[@href=\"/cart\"]")
    WebElement ShoppingCartLink;

    @FindBy (linkText = "wishlist")
    public WebElement AddtoWishesList_Message;

    public void OpenRegisterationForm()
    {
        clickONButton(RegisterLink);
    }

    public void OpenLoginPage()
    {
        clickONButton(LoginLink);
    }

    public void openHomePage()
    {
        clickONButton(HomeLink);
    }

    public void openCategoryMenu()
    {
       action.moveToElement(ComputerCategory)
               .moveToElement(DesktopsubCategory)
               .click().build().perform();

    }

    public void openApperalCategoryMenu()
    {
        action.moveToElement(ApparelCategorLink)
                .moveToElement(ShoesSubCategoryLink)
                .click().build().perform();

    }

    public void OpenWishesList()
    {
        clickONButton(WishesListLink);
    }
    public void OpenShoppingCart()
    {
        clickONButton(ShoppingCartLink);
    }

    public void changeCurrency(String CurencyValue)
    {
        select=new Select(CurrenceDDL);
        clickONButton(CurrenceDDL);
        select.selectByVisibleText(CurencyValue);
    }


}
