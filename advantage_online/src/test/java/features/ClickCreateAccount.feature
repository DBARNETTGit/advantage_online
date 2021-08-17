Feature: Click Create Account

  Scenario:
    Given that I am on the Homepage
    And I click the User button
    And I click the Create New User button
    And I land on the Registration page
    And I enter the registration details
    And I register the User
    And I select the Speakers button
    And I select a speaker
    And I add the speaker to the basket
    And I select the basket
    And I enter MasterCredit Details
    When I click Pay Now
    Then I land on the Order Payment completion page

