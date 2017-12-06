package autotestJava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
