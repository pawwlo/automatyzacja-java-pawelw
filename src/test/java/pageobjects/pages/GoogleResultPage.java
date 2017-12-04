package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class GoogleResultPage extends GooglePage{
    private static final By LOCATOR_SINGLE_RESULT = By.cssSelector(".rc > .r > a");
    public static final By LOCAOR_NEXT_PAGE = By.id("pnnext");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public int countResultWithUrl(String pageUrl) {
        return (int) driver.findElements(LOCATOR_SINGLE_RESULT)
                .stream()
                .filter(result -> result.getAttribute("href").equals(pageUrl)).count();
    }

    public GoogleResultPage displayNextPage(){
        driver.findElement(LOCAOR_NEXT_PAGE).click();
        return new GoogleResultPage(driver);
    }

    public int countResultWithUrlMatching(String pageUrl){
        return (int) driver.findElements(LOCATOR_SINGLE_RESULT)
                .stream()
                .filter(result -> result.getAttribute("href").startsWith(pageUrl)).count();
    }
}
