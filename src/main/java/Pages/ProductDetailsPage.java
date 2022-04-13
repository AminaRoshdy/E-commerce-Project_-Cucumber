package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="price-value-17")
    WebElement ProductPrice;

    @FindBy (css="div[class=\"product-name\"]")
    public WebElement ProductName;

    @FindBy (xpath = "//div[@class=\"add-to-wishlist\"]//button [@class=\"button-2 add-to-wishlist-button\"]")
    public WebElement AddWishBtn;

    @FindBy (xpath = "//div[@class=\"add-to-cart-panel\"]//button [@class=\"button-1 add-to-cart-button\"]")
    public WebElement AddToCartBtn;

    @FindBy (xpath = "//div[@class=\"compare-products\"]//button[@class=\"button-2 add-to-compare-list-button\"]")
    WebElement ComapreBtn;

    @FindBy (xpath = "//dd[@id=\"product_attribute_input_10\"]//span[@class=\"attribute-square\"]")
    public List<WebElement> ColorBoxes;

    public void AddToWishListFromProductDetails()
    {
        clickONButton(AddWishBtn);
    }

    public void AddProductToShoppingCart()
    {
        clickONButton(AddToCartBtn);
    }

    public void AddProductToCompareList()
    {
        clickONButton(ComapreBtn);
    }
}
