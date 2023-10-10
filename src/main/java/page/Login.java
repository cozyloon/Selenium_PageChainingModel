package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private WebDriver driver;
    private By txtUsername = By.id("user-name");
    private By txtPassword = By.id("password");
    private By btnLogin = By.id("login-button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Home loginToApp(String username, String password) {
        WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(txtUsername));
        element1.sendKeys(username);
        WebElement element2 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(txtPassword));
        element2.sendKeys(password);
        WebElement element3 = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(btnLogin));
        element3.click();
        return new Home(driver);
    }

}
