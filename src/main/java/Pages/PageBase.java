package Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    WebDriver driver;
    public JavascriptExecutor JavaEx;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    protected static void clickONButton(WebElement btn)
    {
        btn.click();
    }

    protected static void InsertDataTextBox(WebElement txbox , String text)
    {
        txbox.sendKeys(text);
    }
}
