Feature: Login To Jira

 Background: Open Jira Login Page
   Given I navigate to Jira Login Page

  @Regression
  Scenario: Login to Jira
    Given I enter username - "webinar5"
    And I enter password - "webinar5"
    When I click on the login button
    Then I am on the Home Page

  @Regression
  Scenario Outline: Failed Login to Jira
    Given I enter user name <username>
    And I enter pass <password>
    When I click on the login button
    And I debug
    Then I see error message

    Examples:
    |username  |password |
    |name    |pass   |
    |webinar5|wrong  |
    |user    |webinar5|

