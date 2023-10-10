package tests;

import org.testng.annotations.Test;
import page.*;
import util.BaseTest;

public class Example extends BaseTest {

    @Test
    public void loginToTheApplication() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        String logoIsDisplayed = homePage.checkLogoIsDisplayed();
        softAssert.assertEquals("Swag Labs", logoIsDisplayed);
        softAssert.assertAll();
    }

    @Test
    public void loginToTheApplicationWithChaining() {
        Login login = new Login(driver);
        String logoIsDisplayed = login.loginToApp("performance_glitch_user", "secret_sauce")
                .checkLogoIsDisplayed();
        softAssert.assertEquals("Swag Labs", logoIsDisplayed);
        softAssert.assertAll();
    }

    @Test
    public void loginToTheApplicationWithSingletonPattern() {
//        String logoIsDisplayed = LoginSingleton.getInstance(driver)
//                .loginToApp("performance_glitch_user", "secret_sauce")
//                .checkLogoIsDisplayed();  or below you can use

        LoginSingleton.getInstance(driver)
                .loginToApp("performance_glitch_user", "secret_sauce");

        String logoIsDisplayed = HomeSingleton.getInstance(driver)
                .checkLogoIsDisplayed();
        softAssert.assertEquals("Swag Labs", logoIsDisplayed);
        softAssert.assertAll();
    }
}
