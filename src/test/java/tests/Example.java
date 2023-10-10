package tests;

import org.testng.annotations.Test;
import page.HomePage;
import page.Login;
import page.LoginPage;
import util.BaseTest;

public class Example extends BaseTest {

    @Test
    public void loginToTheApplication() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage =new HomePage(driver);
        String logoIsDisplayed = homePage.checkLogoIsDisplayed();
        softAssert.assertEquals("Swag Lab", logoIsDisplayed);
        softAssert.assertAll();
    }

    @Test
    public void loginToTheApplicationWithChaining() {
        Login login = new Login(driver);
        String logoIsDisplayed = login.loginToApp("performance_glitch_user", "secret_sauce")
                .checkLogoIsDisplayed();
        softAssert.assertEquals("Swag Lab", logoIsDisplayed);
        softAssert.assertAll();
    }
}
