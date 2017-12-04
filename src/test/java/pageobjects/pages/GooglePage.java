package pageobjects.pages;

import org.openqa.selenium.WebDriver;

public class GooglePage {
    protected static final String HTTP_WWW_GOOGLE_COM = "http://www.google.com";
    protected WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver=driver;
    }
}
