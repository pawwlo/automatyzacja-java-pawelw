package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage extends GooglePage{

    private static final By LOCATOR_SEARCH_BOX = By.id("lst-ib");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(HTTP_WWW_GOOGLE_COM);
    }

    public GoogleResultPage searchFor(String pageName) {
        WebElement searchbox = driver.findElement(LOCATOR_SEARCH_BOX);
        searchbox.click();
        searchbox.clear();
        searchbox.sendKeys(pageName);
        searchbox.submit();

        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(LOCATOR_SEARCH_BOX));

        return new GoogleResultPage(driver);
    }
}
