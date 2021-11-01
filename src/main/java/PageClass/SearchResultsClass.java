package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SearchResultsClass {
    private WebDriver driver;

    public SearchResultsClass(WebDriver dr) {
        this.driver = dr;
    }

    public static String searchResults = "//a[contains(@id,'user-ad-')]";

    public String SearchResultsClick() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> allElements = driver.findElements(By.xpath(searchResults));
        System.out.println(allElements.size());
        int r = getRand(allElements);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String linkClicked = allElements.get(r).getText();
        allElements.get(r).click();
        return linkClicked;
    }

    public int getRand(List<WebElement> allElements) {
        int range = allElements.size() - 1;
        int r = (int) (Math.random() * range);
        System.out.println("r is" + r);
        return r;
    }

}
