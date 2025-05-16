package pages;

import bassesClass.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAndPaymentPage extends BasePage {

    public DeliveryAndPaymentPage(WebDriver driver) {
        super(driver);
    }

    private final String PAGE_TITLE_ELEMENT = "//h2[@class='sp-page-title sp-h2 page-header']";
    private final String HOW_TO_PLACE_AN_ORDER_HEDER = "//div[@id='Buy']//h3[@class='sub-block-header']";

    public WebElement getDeliveryPaymentTitle(){
        return visibilityOfElementByXpatch(PAGE_TITLE_ELEMENT);
    }
    public WebElement howToPlaceAnOrderHeader(){

        return visibilityOfElementByXpatch(HOW_TO_PLACE_AN_ORDER_HEDER);
    }
}
