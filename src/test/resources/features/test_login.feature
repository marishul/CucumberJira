Feature: Login To Jira

  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    When I enter user name - "webinar5"
    And I enter password - "webinar5"
    And I click on the login button
    Then I am on the Home Page

  @Regression @wip
  Scenario: Failed Login to Jira
    Given I navigate to Jira Login Page
    When I enter user name - "webinar5"
    And I enter password - "wrongPassword"
    And I click on the login button
    And I debug
    Then I see error message