package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageTest {

    @Test
    public void checkNovaPoshta() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://novaposhta.ua/");
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("a.timetable")).click();
        Thread.sleep(5000);

        WebElement cityFilterinput = driver.findElement(By.xpath("//input[@id='oCityFilter']"));
        cityFilterinput.sendKeys("М Бровари Броварський р-н Київська обл");
        Thread.sleep(5000);

        String actualValue = cityFilterinput.getAttribute("value");

      Assert.assertEquals(actualValue, "М Бровари Броварський р-н Київська обл");

      driver.quit();


    }

}
