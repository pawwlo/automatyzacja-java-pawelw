package autotestJava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import autotestJava.utils.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordpressAddNotePage extends WordpressPage{

    public static final By COMMENTS_LOCATOR = By.className("comment-body");
    public static final By COMMENT_TEXTAREA_SELECTOR = By.id("comment");
    public static final By EMAIL_WEBELEMENT_SELECTOR_INV = By.xpath("//label[@for='email']");
    public static final By EMAIL_WEBELEMENT_SELECTOR = By.id("email");
    public static final By NAME_WEBELEMENT_SELECTOR_INV = By.xpath("//label[@for='author']");
    public static final By NAME_WEBELEMENT_SELECTOR = By.id("author");
    public static final By BUBMIT_WEBELEMENT_SELECTOR = By.id("comment-submit");
    public static final By COMMENTS_LOCATOR_USERNAME = By.tagName("cite");
    public static final By COMMENTS_LOCATOR_USERNOTE = By.cssSelector(".comment-content > p");

    public WordpressAddNotePage(WebDriver driver) {
        super(driver);
    }

    public WordpressAddNotePage addNote(User user) {
        WebElement commentTextArea = driver.findElement(COMMENT_TEXTAREA_SELECTOR);
        commentTextArea.click();
        commentTextArea.sendKeys(user.getUserNote());

        WebElement email = driver.findElement(EMAIL_WEBELEMENT_SELECTOR_INV);
        email.click();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOf(email));
        email = driver.findElement(EMAIL_WEBELEMENT_SELECTOR);
        email.click();
        email.sendKeys(user.getUserMail());

        WebElement name = driver.findElement(NAME_WEBELEMENT_SELECTOR_INV);
        name.click();
        wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.invisibilityOf(name));
        name = driver.findElement(NAME_WEBELEMENT_SELECTOR);
        name.click();
        name.sendKeys(user.getUserName());

        WebElement submit = driver.findElement(BUBMIT_WEBELEMENT_SELECTOR);
        submit.click();
        return new WordpressAddNotePage(driver);
    }

    public int checkIfAddNoteFor(User user) {
        return (int) getCommentFor(user).count();
    }

    private Stream<WebElement> getCommentFor(User user) {
        return driver.findElements(COMMENTS_LOCATOR).stream()
                .filter(comment -> comment.findElement(COMMENTS_LOCATOR_USERNAME).getText().equals(user.getUserName()))
                .filter(comment -> comment.findElement(COMMENTS_LOCATOR_USERNOTE).getText().equals(user.getUserNote()));
    }

    public WordpressAddNotePage addNoteToNote(User user) {
        WebElement we = getCommentFor(user).findFirst().get();
        we.findElement(By.cssSelector("a.comment-reply-link")).click();
        User user2=new User();

        WebElement commentTextArea = driver.findElement(COMMENT_TEXTAREA_SELECTOR);
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(commentTextArea));
        commentTextArea.click();
        commentTextArea.sendKeys(user2.getUserNote());

        WebElement email = driver.findElement(EMAIL_WEBELEMENT_SELECTOR);
        email.click();
        email.clear();
        email.sendKeys(user2.getUserMail());

        WebElement name = driver.findElement(NAME_WEBELEMENT_SELECTOR);
        name.click();
        name.clear();
        name.sendKeys(user2.getUserName());

        WebElement submit = driver.findElement(BUBMIT_WEBELEMENT_SELECTOR);
        submit.click();

        return new WordpressAddNotePage(driver);
    }
}
