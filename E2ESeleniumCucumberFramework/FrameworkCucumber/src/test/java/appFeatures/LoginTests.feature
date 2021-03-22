Feature: As a QA Academy user
i want to login
To see the information of my courses and the platform

Scenario Outline: Login with incorrect credentials
Given I am in the login page
When i enter username <username>
And i enter password <password>
And click the login button
Then an error message shows

Examples:
|username           | password |
|abc@gmail.com      | 1234     |
|aaaa@gmail.com     | 2222     |


Scenario: Login without username
Given I am in the login page
When i enter my password "123456"
And click the login button
Then an error message shows

Scenario: Login without password
Given I am in the login page
When i enter my username "aaaa@gmail.com"
And click the login button
Then an error message shows