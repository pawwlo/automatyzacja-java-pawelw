package selenium;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private static final String HTTP_GOOGLE_COM = "http://google.com";
    private static final String CODE_SPRINTERS = "code sprinters";
//    private static final String CODE_SPRINTERS_XPATH = "//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a";
    private static final String CODE_SPRINTERS_XPATH = "//*[@class='rc']//*[@class='r']//a[@href='http://agileszkolenia.pl/']";
    private WebDriver driver;
    @Before
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void firstSeleniumTest(){
        driver.get(HTTP_GOOGLE_COM);

        WebElement searchbox=driver.findElement(By.id("lst-ib"));
        searchbox.click();
        searchbox.clear();
        searchbox.sendKeys(CODE_SPRINTERS);
        searchbox.submit();


        Assert.assertTrue(driver.findElements(By.xpath(CODE_SPRINTERS_XPATH)).size() > 0);
    }

    @After
    public void closeBrowser(){
        if(driver!=null) {
            driver.quit();
        }
    }
}