package autotestJava.test;

import autotestJava.pages.WordpressAddNotePage;
import autotestJava.pages.WordpressAdminPage;
import autotestJava.pages.WordpressLoginPage;
import autotestJava.pages.WordpressPage;
import autotestJava.utils.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class WordpressTests extends BaseTest{
    @Test
    public void checkLogin(){
        WordpressLoginPage loginPage=new WordpressLoginPage(driver);
        WordpressAdminPage adminPage = loginPage.logIn("autotestjava@gmail.com","P@ssw0rd1");
        Assert.assertTrue("Userl logged in",adminPage.isOpen());
    }

    @Test
    @Ignore
     public void checkIfNoteAdd(){
        //wejdz na bloga
        WordpressPage wordpressMainPage=new WordpressPage(driver);
        wordpressMainPage.open();
        //otworz pierwsza notke
        WordpressAddNotePage wordpressAddNotePage=wordpressMainPage.addNoteAction();
        //dodaj komentarz
        User user = new User();
        WordpressAddNotePage refreshedNotePage = wordpressAddNotePage.addNote(user);
        //sprawdz ze dodal
        Assert.assertTrue("Check if note add",refreshedNotePage.checkIfAddNoteFor(user)==1);
    }

    @Test
    @Ignore
    public void checkIfNoteAddToNote(){
        //wejdz na bloga
        WordpressPage wordpressMainPage=new WordpressPage(driver);
        wordpressMainPage.open();
        //otworz pierwsza notke
        WordpressAddNotePage wordpressAddNotePage=wordpressMainPage.addNoteAction();
        //dodaj komentarz
        User user = new User();
        WordpressAddNotePage refreshedNotePage = wordpressAddNotePage.addNote(user);
        WordpressAddNotePage refreshedNoteToNotePage=refreshedNotePage.addNoteToNote(user);
        //sprawdz ze dodal
        //Assert.assertTrue("Check if note add",refreshedNotePage.checkIfAddNoteFor(user)==1);
    }
}
