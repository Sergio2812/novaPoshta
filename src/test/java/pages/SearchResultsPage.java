package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_PRODUCT = "//div[@data-product-id='12798167']//a[contains(@class, 'product-card__title')]";
    private final String FIRST_PRODUCT_AIR_PODS = "//div[@data-product-id='14092905']//a[@class='product-card__title']";

    public WebElement firstProduct(){
        return visibilityOfElementByXpatch(FIRST_PRODUCT);
    }

    private WebElement firstProductAirPods(){
        return visibilityOfElementByXpatch(FIRST_PRODUCT_AIR_PODS);
    }



    public String getNameFirstAirPods(){
        return firstProductAirPods().getText();
    }

    public void clickFirstAirPods(){
        firstProductAirPods().click();
    }
}