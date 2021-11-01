package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SearchHeaderClass {
    private WebDriver driver;

    public SearchHeaderClass(WebDriver dr) {
        this.driver = dr;
    }

    public static String searchField = "search-query";
    public static String categoryDropDown = "//div[@id='categoryId-wrp']";
    public static String categoryItem = "//div[contains(text(),'Electronics & Computer') and contains(@id,'categoryId-wrp-option')]";
    public static String searchArea = "//input[@id='search-area']";
    public static String searchRadiusDropDown = "//span[@id='srch-radius-input']";
    public static String searchRadius = "//div[contains(text(),'20km') and contains(@id,'srch-radius-wrp-option')]";
    public static String submitButton = "//button[@type='submit']";

    public boolean SetSearchHeaderValues() {

        driver.findElement(By.id(searchField)).sendKeys("Sennheiser Headphones");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(categoryDropDown)).click();
        driver.findElement(By.xpath(categoryItem)).click();
        driver.findElement(By.xpath(searchArea)).sendKeys("Sydney Region, NSW");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(searchRadiusDropDown)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(searchRadius)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(submitButton)).click();
        return true;
    }


}
