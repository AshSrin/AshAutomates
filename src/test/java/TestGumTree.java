import Base.BaseClass;
import PageClass.AdContentPageClass;
import PageClass.HomePageClass;
import PageClass.SearchHeaderClass;
import PageClass.SearchResultsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestGumTree extends BaseClass {


    SearchHeaderClass SearchHeaderClassObj;
    HomePageClass HomePageClassObj;
    SearchResultsClass SearchResultsClassObj;
    AdContentPageClass AdContentPageClassObj;


    @BeforeMethod(alwaysRun = true)
    public void beforeEachTest(Method method) throws InterruptedException {
        String dir=System.getProperty("user.dir");
        System.out.println(dir);
        System.setProperty("webdriver.chrome.driver", dir+"/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://gumtree.com.au");
        SearchHeaderClassObj = new SearchHeaderClass(driver);
        SearchResultsClassObj = new SearchResultsClass(driver);
        AdContentPageClassObj = new AdContentPageClass(driver);
         HomePageClassObj= new HomePageClass(driver);

    }

    @Test
    public void TestSearch() throws InterruptedException {

        if (driver.findElement(By.className(HomePageClassObj.overLayDialogClose)).isDisplayed()) {
            driver.findElement(By.className(HomePageClassObj.overLayDialogClose)).click();
        }
        Assert.assertTrue(SearchHeaderClassObj.SetSearchHeaderValues());
        String[] linkClicked = SearchResultsClassObj.SearchResultsClick().split("\\n");
        String linkInContentPage = AdContentPageClassObj.ContentPageVerification();
        //verify if content page redirects to link clicked on search results
        Assert.assertEquals(linkInContentPage, linkClicked[0], "The ad displayed is different to the ad clicked in search results page");
        //verify if ad id is displayed in the content page
        Assert.assertTrue(AdContentPageClassObj.adIdVerification(), "Ad id breadcrumb is missing");
        //verify if similar ad section has items in it content page
        Assert.assertTrue(AdContentPageClassObj.similarAdVerification(), "Similar ad section is empty");
    }


    @AfterMethod
    public void completedTest() {
       driver.close();
       driver.quit();
    }
}
