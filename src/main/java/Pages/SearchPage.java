package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="small-searchterms")
    WebElement GeneralSearchTxtBox;

    @FindBy (css="button[class=\"button-1 search-box-button\"]")
    WebElement SearchBtn;

    @FindBy (css="h2[class=\"product-title\"]")
    public List<WebElement> productsTitle;

    @FindBy (css = "span[class=\"price actual-price\"]")
    public List<WebElement> ProductPricesLbl;

    @FindBy (css="button[title=\"Add to wishlist\"]")
    public List<WebElement> WishesListBtns;

    @FindBy (xpath = "//button[@class=\"button-2 product-box-add-to-cart-button\"]")
    public List<WebElement> AddToCartBtn;

    @FindBy (xpath = "//div[@class=\"buttons\"]//button[@class=\"button-2 add-to-compare-list-button\"]")
    public List<WebElement> ComparetBtn;




    public void SearchProduct(String ProductName)
    {
        InsertDataTextBox(GeneralSearchTxtBox, ProductName);
        clickONButton(SearchBtn);

    }

    public void AddProductToWishesListFromSearchResult()
    {
        clickONButton(WishesListBtns.get(0));

    }

    public void AddProductToCompareList()
    {
        clickONButton(ComparetBtn.get(0));

    }

    public void AddProductToCart()
    {
        clickONButton(AddToCartBtn.get(0));
    }

    public void OpenDetailsPageofProduct()
    {
        clickONButton(productsTitle.get(0));
    }

    public String GetTheProductName()
    {
        String ProductName= productsTitle.get(0).getText().toString();
        return ProductName;

    }


}
