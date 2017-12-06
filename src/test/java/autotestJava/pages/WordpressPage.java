package autotestJava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressPage {
    protected WebDriver driver;
    public WordpressPage(WebDriver driver) {
        this.driver=driver;
    }

    public void open() {
        driver.get("https://autotestjava.wordpress.com/");
    }

    public WordpressAddNotePage addNoteAction() {

        WebElement leaveComment=driver.findElement(By.xpath("//article[1]//h1[@class='entry-title']/a"));
        leaveComment.click();
        return new WordpressAddNotePage(driver);
    }

    protected void waitUntilElementIsClickableBy(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected  void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
