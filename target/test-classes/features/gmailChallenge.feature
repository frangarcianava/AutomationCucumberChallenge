@Challenge
Feature: Access Gmail and send an email to qa@interpricetech.com

  Background:
    Given user is on login page
    And user enters user and password and press enter

  @LoginSuccessful
  Scenario: Verify the user is logged correctly
    Then user is logged and is on inbox page

  @EmailSent
  Scenario: Verify the mail was sent correctly and properly labeled
    When user creates a new email
    And user sends the email
    And user marks the received email as starred
    Then open email and verify the subject and message body
