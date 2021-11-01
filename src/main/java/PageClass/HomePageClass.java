package PageClass;

import org.openqa.selenium.WebDriver;

public class HomePageClass {
    public static WebDriver driver;
    public HomePageClass(WebDriver dr) {
        this.driver=dr;
    }

    public static String overLayDialogClose = "svg-close-overlay";
}
