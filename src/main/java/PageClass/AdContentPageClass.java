package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AdContentPageClass {
    private WebDriver driver;

    public AdContentPageClass(WebDriver dr) {
        this.driver = dr;
    }

    public static String AdvertisementTitle = "vip-ad-title__header";
    public static String AdIdBreadCrumb = "//span[@class='breadcrumbs__summary']";
    public static String SimilarAdItems = "//div[contains(@class,'similar-ads__slider-container')]//li";

    public String ContentPageVerification() {
        String pageTitle = driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String AdTitle = driver.findElement(By.className(AdvertisementTitle)).getText();
        return AdTitle;

    }

    public boolean adIdVerification() {

        String ids = driver.findElement(By.xpath(AdIdBreadCrumb)).getText();
        if (ids.isEmpty()) {
            return false;
        }
        return true;

    }

    public boolean similarAdVerification() {
        return driver.findElement(By.xpath(SimilarAdItems)).isDisplayed();
    }

}
