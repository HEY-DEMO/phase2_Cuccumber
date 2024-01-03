Feature: Validate the Star Health Buy Now flow

  Background:
    Given User launches the Star Health application with "<URL>"
    And User waits for the Welcome to Star Health pop-up and closes it

  Scenario Outline: User completes the Buy Now flow
    When User validates the Star Health home page title using a JUnit assertion
    And User clicks on the Buy Now button
    And User types Name as "<FullName>"
    And User types Phone as "<PhNo>"
    And User types the PIN as "<PIN>"
    And User stypes Email as "<Email>"
    And User sees the Plan for My Family page
    And User validates that the Email is the same as the previously entered Email using a JUnit assertion
    And User clicks on the Star Health logo
    Then The user should have completed the Buy Now flow successfully

    Examples:
      | URL                     | FullName          | PhNo          | PIN    | Email            |
      | https://starhealth.com  | DEMO vishwak      | 7675909319    | 524004 | 123@gmail.com    |
