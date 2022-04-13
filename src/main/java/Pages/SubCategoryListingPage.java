package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubCategoryListingPage extends PageBase{
    public SubCategoryListingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="attribute-option-15")
    public WebElement RedColorCheckBox;

    @FindBy (xpath = "//div[@class=\"tags\"]//a[@href=\"/awesome\"]")
    WebElement TagsLink;

    @FindBy (css = "div[class=\"page-title\"]")
    public WebElement tagPageTitle;

    @FindBy(css = "a[style=\"font-size:85%\"]")
    public List<WebElement> tagsList;

    @FindBy (css="h2[class=\"product-title\"]")
    public List<WebElement> productsTitle;

    public void OpenTagLink()
    {
            clickONButton(TagsLink);
    }

    public void FilterByRedColor()
    {
        clickONButton(RedColorCheckBox);
    }

    public void OpenDetailsPageOfFirstProduct()
    {
        clickONButton(productsTitle.get(0));
    }
}
