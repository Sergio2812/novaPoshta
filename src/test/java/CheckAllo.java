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
    public void testAlloSearchForHairDryer(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://allo.ua/");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search-form__input']"));
        Assert.assertTrue(searchInput.isDisplayed(), "Поле пошуку має бути видимим");

        searchInput.sendKeys("фен");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-form__submit-button']"));
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firsProduct =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Фен Philips BHD342/10 серії 3000 ']")));

        String productTitle = firsProduct.getText().toLowerCase();
        Assert.assertTrue(productTitle.contains("фен"), "Назва першого товару має містити слово 'фен'");

        driver.quit();



    }
}
