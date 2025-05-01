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
    public void testAlloLogoDisplayed(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement logo = driver.findElement(By.xpath("//a[@class='v-logo']//img"));

        Assert.assertTrue(logo.isDisplayed(),"Логотип АЛЛО має бути видимим");

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

        WebElement firsProduct =  driver.findElement(By.xpath("//div[@data-product-id='12798167']//a[contains(@class, 'product-card__title')]"));
        String productTitle = firsProduct.getText().toLowerCase();
        Assert.assertTrue(productTitle.contains("фен"), "Назва першого товару має містити слово 'фен'");

        driver.quit();

    }
}
