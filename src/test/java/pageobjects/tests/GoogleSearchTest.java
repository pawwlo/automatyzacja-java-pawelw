package pageobjects.tests;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.domain.CodeSprinters;
import pageobjects.pages.GoogleMainPage;
import pageobjects.pages.GoogleResultPage;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void verifyGoogleFindsCodeSprintersPage() {
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        //assert
        Assert.assertTrue(CodeSprinters.PAGE_NAME+" page found", resultPage.countResultWithUrl(CodeSprinters.PAGE_URL)>0);
    }

    @Test
    public void verifyGoogleShowsNoCodeSprintersOnSecondPage() throws InterruptedException {
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        GoogleResultPage secondResultPage = resultPage.displayNextPage();
        Thread.sleep(200);
        Assert.assertTrue("Pages "+CodeSprinters.PAGE_URL+" not found", secondResultPage.countResultWithUrlMatching(CodeSprinters.PAGE_URL)==0);
    }

    private GoogleResultPage searchOnGoogle(String pageName) {
        GoogleMainPage mainPage=new GoogleMainPage(driver);
        mainPage.open();
        return mainPage.searchFor(pageName);
    }
}
