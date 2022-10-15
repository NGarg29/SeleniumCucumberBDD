Feature: Compose email functionality on gmail application 

Scenario: Compose an email 

Given Launch Gmail Application

And Enter username and password		

When Send an email with subject ''

Then Verify the email in sent folder