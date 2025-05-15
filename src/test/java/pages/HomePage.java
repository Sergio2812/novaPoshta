package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final String ALLO_LOGO = "//a[@class='v-logo']//img";
    private final String CATALOG_BUTTON = "//div[@class='mh-catalog-btn']";
    private final String SEARCH_FIELD = "//input[@id='search-form__input']";
    private final String SEARCH_BUTTON = "//button[@class='search-form__submit-button']";
    private final String CUSTOMERS_BUTTON = "//a[@class='mh-button mh-button--open']";
    private final String DROP_DOWN_MENU = "//div[@class='mh-button__dropdown']";
    private final String DELIVERY_OPTION = "//div[contains(@class, 'mh-button__dropdown')]//a[contains(@href, 'shipment_payment')]";

    public WebElement allologo() {
        return visibilityOfElementByXpatch(ALLO_LOGO);
    }

    public WebElement searchField(){

        return visibilityOfElementByXpatch(SEARCH_FIELD);
    }

    public WebElement catalogButton(){
        return visibilityOfElementByXpatch(CATALOG_BUTTON);
    }

    public WebElement searchButton(){
        return visibilityOfElementByXpatch(SEARCH_BUTTON);
    }

    public void allologoDisplayed(){
        allologo().isDisplayed();
    }

    public void enterValueInSearchField(String value){
        searchField().sendKeys(value);
    }

    public void clickSearchButton(){
        searchButton().click();
    }

    public WebElement customersButton(){
      return visibilityOfElementByXpatch(CUSTOMERS_BUTTON);
    }

    public void clickCustomersButton(){
        customersButton().click();
    }

    public WebElement openDropDownMenu(){
        return visibilityOfElementByXpatch(DROP_DOWN_MENU);
    }

    public WebElement buttonDeliveryOptionsDisplayed(){
        return visibilityOfElementByXpatch(DELIVERY_OPTION);
    }
}