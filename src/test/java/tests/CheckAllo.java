package tests;

import bassesClass.TestInit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeliveryAndPaymentPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class CheckAllo extends TestInit {

    public String alloUrl = "https://allo.ua/";

    @Test
    public void testAlloLogoDisplayed() {

        HomePage homePage = new HomePage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.allologo().isDisplayed());

    }

    @Test
    public void testAlloSearchForHairDryer() {

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultPage = new SearchResultsPage(driver);

        openUrl(alloUrl);

        Assert.assertTrue(homePage.searchField().isDisplayed());

        homePage.searchField().sendKeys("Фен");
        homePage.searchButton().click();

        Assert.assertTrue(searchResultPage.firstProduct().getText().contains("Фен"));

    }

    @Test
    public void searchAirPodsAndVerifyProduct() {

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultPage = new SearchResultsPage(driver);
        ProductPage productPage = new ProductPage(driver);

        String AirPods = "AirPods 3";

        openUrl(alloUrl);

        homePage.allologoDisplayed();
        homePage.enterValueInSearchField(AirPods);
        homePage.clickSearchButton();

        String expectedNameFirstAirPods = searchResultPage.getNameFirstAirPods();
        Assert.assertTrue(expectedNameFirstAirPods.contains("AirPods 3"));

        searchResultPage.clickFirstAirPods();

        String actualNameAirPods = productPage.getNameProductTitle();

        Assert.assertEquals(actualNameAirPods, expectedNameFirstAirPods);

    }

    @Test
    public void customersMenuDeliveryAndPaymentFlow() {
        HomePage homePage = new HomePage(driver);
        DeliveryAndPaymentPage deliveryAndPaymentPage = new DeliveryAndPaymentPage(driver);

        openUrl(alloUrl);

        homePage.customersButton().isDisplayed();
        Assert.assertTrue(homePage.customersButton().isDisplayed());

        homePage.clickCustomersButton();

        homePage.openDropDownMenu().isDisplayed();
        Assert.assertTrue(homePage.openDropDownMenu().isDisplayed());

        homePage.buttonDeliveryOptionsDisplayed().isDisplayed();
        Assert.assertTrue(homePage.buttonDeliveryOptionsDisplayed().isDisplayed());

        homePage.buttonDeliveryOptionsDisplayed().click();

        String deliveryTytle = deliveryAndPaymentPage.getDeliveryPaymentTitle().getText();
        Assert.assertTrue(deliveryTytle.contains("Доставка і оплата"));

        deliveryAndPaymentPage.howToPlaceAnOrderHeader().isDisplayed();
        Assert.assertTrue(deliveryAndPaymentPage.howToPlaceAnOrderHeader().isDisplayed());

        String howToOrder = deliveryAndPaymentPage.howToPlaceAnOrderHeader().getText();

        Assert.assertEquals(howToOrder, "Як оформити замовлення?");

    }
}