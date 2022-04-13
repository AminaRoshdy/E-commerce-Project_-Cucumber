package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishesListPage extends PageBase{
    public WishesListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css="table[class=\"cart\"]")
    public WebElement ProductTable;

     @FindBy (tagName = "tr")
     public List <WebElement> tabelRows;

     @FindBy (xpath = "//button[@class=\"remove-btn\"]")
     List<WebElement> RemoveProductIcons;

     @FindBy (xpath = "//div[@class=\"no-data\"]")
     public WebElement NoDataMessage;

     public void removeProsudtFromWishesList()
     {

         for( WebElement icon: RemoveProductIcons)
         {
             clickONButton(RemoveProductIcons.get(0));
         }
     }
}
