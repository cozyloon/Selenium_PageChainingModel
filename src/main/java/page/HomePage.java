package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By logoTxt = By.className("app_logo");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkLogoIsDisplayed() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(logoTxt));
        return element.getText();
    }
}
