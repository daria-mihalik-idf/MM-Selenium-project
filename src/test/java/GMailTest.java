import core.TestBase;
import org.testng.annotations.Test;
import pages.GMailPage;
import pages.GoogleHomePage;
import pages.LoginPage;

class GMailTest extends TestBase {

    @Test
    public void loginTest() {
        GoogleHomePage.clickSignInButton();
        LoginPage.shouldAppear();
        LoginPage.login();
        GoogleHomePage.shouldAppear();
        GoogleHomePage.goToGmail();
        GMailPage.shouldAppear();
        GMailPage.assertNumberOfEmailsIs(3);
    }
}
