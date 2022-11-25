# InterpriceAutomationChallenge

I've just created this repo in order to show you what i automated about the task, that's why it has only one commit.
______________________________________________________

Part 1: Set up an automation framework from scratch.
● Utilizing Selenium, Java, Cucumber, and your IDE of choice

Part 2: Set up an automation script to access Gmail and send an email to qa@interpricetech.com
using the framework from Part 1.
● Login to Gmail and create an email with the “Social” label
● The email should have the subject line “QA Automation Test” and a message body that states
“InterPrice QA Automation Test Complete”
● Send the email to your personal account and CC qa@interpricetech.com
● Mark the received email as “Starred”
● Open and verify that the email is properly labeled
● Verify the subject and message body

NOTE: I realized that the GmailPage failed too much, so i used the approach of creating a "listener" class to retry when tests fail.
