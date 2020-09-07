package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateModal {

    private By createLink = By.id("create_link");
    private By ticketPanel = By.xpath("//*[contains(text(), 'WEBINAR')]");
    private By projectField = By.id("project-field");
    private By issueField = By.id("issuetype-field");
    private By ticketName = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By submitButton = By.id("create-issue-submit");
    private By popUpCreation = By.cssSelector("div[class='aui-message closeable aui-message-success aui-will-close'] a[class='issue-created-key issue-link']");

    public boolean isTicketPannelPresent() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(ticketPanel)).isDisplayed();
    }

    public void clickOnCreateButton() {
        WebDriverFactory.getDriver().findElement(createLink).click();
    }


    public void setProjectField() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        wait.until(elementToBeClickable(projectField)).isEnabled();
        WebDriverFactory.getDriver().findElement(projectField).click();
        WebDriverFactory.getDriver().findElement(projectField).sendKeys("Webinar (WEBINAR)");
        WebDriverFactory.getDriver().findElement(projectField).sendKeys(Keys.TAB);
    }


    public void setIssueType() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        wait.until(elementToBeClickable(projectField)).isEnabled();
        WebDriverFactory.getDriver().findElement(issueField).click();
        WebDriverFactory.getDriver().findElement(issueField).sendKeys("Task");
        WebDriverFactory.getDriver().findElement(issueField).sendKeys(Keys.ENTER);
    }


    public void setSummary(String summary) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        wait.until(elementToBeClickable(issueField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketName).sendKeys(summary);
    }

    public void setReporter() {
        WebDriverFactory.getDriver().findElement(reporterField).click();
        WebDriverFactory.getDriver().findElement(reporterField).sendKeys("webinar5");
    }

    public void clickSubmit() {
        WebDriverFactory.getDriver().findElement(submitButton).click();
    }

    public boolean isSuccessfulCreatedPopUp() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(popUpCreation)).isDisplayed();
    }

    public String getTicketName() {
        WebElement popUp = WebDriverFactory.getDriver().findElement(popUpCreation);
        String ticketName = popUp.getAttribute("data-issue-key");
        return ticketName;
    }

    public boolean ticketHasWebinar() {
        return getTicketName().contains("WEBINAR");
    }

}
