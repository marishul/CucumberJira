package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class HomePage {

    public boolean onPage(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(), 'WEBINAR')]"))).isDisplayed();
    }

    public boolean errorLogin(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(By.id("usernameerror"))).isDisplayed();
    }
}