package autotestJava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressLoginPage extends WordpressPage{

    private @FindBy(id="usernameOrEmail") WebElement userNameInputBox;
    private @FindBy(id="password") WebElement pass;


    public WordpressLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public WordpressAdminPage logIn(String userName, String password){
        driver.get("https://autotestjava.wordpress.com/wp-login.php");

       // WebElement userNameInputBox = driver.findElement(By.id("usernameOrEmail"));
        writeToElement(userNameInputBox, userName);
        userNameInputBox.submit();
        waitUntilElementIsClickable(pass);
       // WebElement pass = driver.findElement(By.id("password"));
        writeToElement(pass,password);
        pass.submit();

        return new WordpressAdminPage(driver);
    }
    public void writeToElement(WebElement webElement, String text){
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }
}
