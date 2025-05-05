import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class CheckAllo {

    @Test
    public void testAlloLogoDisplayed() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement logo = driver.findElement(By.xpath("//a[@class='v-logo']//img"));

        Assert.assertTrue(logo.isDisplayed(), "Логотип АЛЛО має бути видимим");

        driver.quit();
    }

    @Test
    public void testAlloSearchForHairDryer() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchInput.isDisplayed(), "Поле пошуку має бути видимим");

        searchInput.sendKeys("фен");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();

        Thread.sleep(5000);

        WebElement firsProduct = driver.findElement(By.xpath("//div[@data-product-id='12798167']//a[contains(@class, 'product-card__title')]"));
        String productTitle = firsProduct.getText().toLowerCase();
        Assert.assertTrue(productTitle.contains("фен"), "Назва першого товару має містити слово 'фен'");

        driver.quit();
    }

    @Test
    public void searchAirPodsAndVerifyProduct() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua/");
        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.xpath("//a[@class='v-logo']//img"));
        Assert.assertTrue(logo.isDisplayed(), "Логотип має бути видимим");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        searchInput.sendKeys("AirPods 3");
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();
        Thread.sleep(3000);

        WebElement firstProductTitle = driver.findElement(By.xpath("//div[@data-product-id='14092905']//a[@class='product-card__title']"));
        String expectedProductText = firstProductTitle.getText();
        Assert.assertTrue(expectedProductText.contains("AirPods 3"), "Назва має містити 'AirPods 3'");

        firstProductTitle.click();

        WebElement productDetailTitle = driver.findElement(By.xpath("//h1[@class='p-view__header-title']"));
        String actualProductText = productDetailTitle.getText();

        Assert.assertEquals(expectedProductText, actualProductText, "Назви товарів на сторінці результатів та деталях не співпадають!");

        driver.quit();

    }
}
