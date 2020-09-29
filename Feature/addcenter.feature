Feature: Add Center Test

@valid
Scenario: Successful added center with valid credentials
Given I am on the add center page
When I enter valid centerId and name and address and contactnumber
Then message displayed center added successfully 

@invalid
Scenario: Test add center when provided already exists id
Given I am on add center page
When I enter existed centerId and name and address and contactnumber
Then I should see an error message


