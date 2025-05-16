package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final String FIRST_PRODUCT = "//div[@data-product-id='12798167']//a[contains(@class, 'product-card__title')]";
    private final String FIRST_PRODUCT_AIR_PODS = "//div[@data-product-id='14092905']//a[@class='product-card__title']";
    private final String VIEW_MODE_BUTTON = "//button[@class='view-mode__button' and @title='Таблиця']";
    private final String NUMBERS_COMMENTS_PRODUCT = "//a[@rel='noreferrer' and @class='review-button__link']//span[@class='review-button__text review-button__text--count']";

    public WebElement firstProduct(){
        return visibilityOfElementByXpatch(FIRST_PRODUCT);
    }

    private WebElement firstProductAirPods(){
        return visibilityOfElementByXpatch(FIRST_PRODUCT_AIR_PODS);
    }

    public WebElement viewModeButton(){
        return visibilityOfElementByXpatch(VIEW_MODE_BUTTON);
    }

    public void viewModeButtonDispleyed(){
        viewModeButton().isDisplayed();
    }

    public String getNameFirstAirPods(){
        return firstProductAirPods().getText();
    }

    public void clickFirstAirPods(){
        firstProductAirPods().click();
    }

    public List<WebElement> numbersCommentsProduct(){
        return visibilityOfElementsLocatorByXpatch(NUMBERS_COMMENTS_PRODUCT);
    }

}