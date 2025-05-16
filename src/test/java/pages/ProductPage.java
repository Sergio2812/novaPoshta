package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final String PRODUCT_TITLE = "//h1[@class='p-view__header-title']";

    public WebElement productTitle(){
        return visibilityOfElementByXpatch(PRODUCT_TITLE);
    }

    public String getNameProductTitle(){
        return productTitle().getText();
    }
}
