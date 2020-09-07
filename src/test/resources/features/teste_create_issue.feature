Feature: Create Issue in Jira

  Background: Authorization in Jira
    Given I navigate to Jira Login Page
    And I enter username - "webinar5"
    And I enter password - "webinar5"
    When I click on the login button
    Then I am on the Home Page

    @Regression
    Scenario: Create Task issue for WEBINAR project
      Given I click Create button
      When I set project field
      And I set issue type
      And I set summary - "ticket by autotest"
      And I set reporter
      And I click on Submit button
      Then Ticket is created and popup appeared


