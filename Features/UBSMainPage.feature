Feature: MainPage
  Scenario: Main page to Wealth Management
    Given Start chrome browser
    When Open home page
    Then Verify main page loaded
    When Go To Wealth Management
    Then Verify Wealth Management page loaded
    And Close
  Scenario: Main page to Contact Us
      Given Start chrome browser
      When Open home page
      Then Verify main page loaded
      When Go To Contact Us
      Then Verify Contact Us page loaded
      And Close