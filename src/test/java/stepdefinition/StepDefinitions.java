package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.CreateModal;
import pages.LoginPage;
import utils.WebDriverFactory;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


public class StepDefinitions {

    @Before
    public void beforeCucumberScenario(Scenario scenario) {
        WebDriverFactory.createInstance("Chrome");
    }

    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.getDriver().close();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot_" + java.time.LocalTime.now() + ".png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }

    @Then("^I navigate to Jira Login Page$")
    public void navigateToLoginPage() {
        new LoginPage().navigateTo();
    }

    @Then("^I enter username - \"(.*?)\"$")
    public void enterUserName(String userName) {
        new LoginPage().enterUserName(userName);
    }

    @Then("^I enter password - \"(.*?)\"$")
    public void enterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("^I click on the login button$")
    public void clickLoginButton() {
        new LoginPage().clickLogin();
    }

    @When("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @When("^I see error message$")
    public void errorPresence() {
        assert new HomePage().errorLogin();
    }

    @When("^I debug$")
    public void debug() {
        int a = 0;
    }

    @Then("^I enter user name ([^\"]*)$")
    public void enterLogin(String username) {
        new LoginPage().enterUserName(username);
    }

    @Then("^I enter pass ([^\"]*)$")
    public void enterPass(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("^I click Create button")
    public void clickOnCreateButton() {
        assertTrue(new CreateModal().isTicketPannelPresent());
        new CreateModal().clickOnCreateButton();
    }

    @Then("^I set project field")
    public void setProject() {
        new CreateModal().setProjectField();
    }

    @Then("^I set issue type")
    public void setIssue() {
        new CreateModal().setIssueType();
    }

    @Then("^I set summary - \"(.*?)\"$")
    public void setSummary(String summary) {
        new CreateModal().setSummary(summary);

    }

    @Then("^I set reporter")
    public void setReporter() {
        new CreateModal().setReporter();
    }

    @Then("^I click on Submit button")
    public void clickSubmit() {
    }

    @Then("^Ticket is created and popup appeared")
    public void ticketCreated() {
        assert new CreateModal().isSuccessfulCreatedPopUp();
        assert new CreateModal().ticketHasWebinar();
    }

}
