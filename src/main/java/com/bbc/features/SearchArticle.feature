#Author: Lakshmi
#Keywords Summary : Additional Test Cases feature/Manual

@manual
Feature: Search BBC News Article feature
Background: User navigates to BBC Site
Given :  User is navigated to BBC News Articles Comments Page
When : User clicks Sign In on BBC News Articles Comments Page
Then : User doing the Sign in process with Valid Email Id
                     | Username | Password |
                  | softwaretesting1286@gmail.com | Igateseetha@0 |
	
@manual
Scenario: Searching BBC news Article in the Home Page 
    
	  Given : User is  searching for a news article 
	                | searchKeyword | 
	                |  Asia |
    Then : User Validates whether ASIA news is being displayed and search results are successful
    And  : User Selects first news Article from the search Results
    And  : User Clicks Username Icon and doing Signout
    
@manual
Scenario: Validate More dropdown by selecting any critera from the dropdown values in the Home Page
Given : User clicks More drop down 
When : User Selects a criteria from the drop down values 
             | criteria | 
	           |  Music |
Then : User verifies whether the search criteria music results are displayed  


@manual
Scenario: Change Display name in Settings
Given : User is navigated to Settings page  
When : User validates the Settings page title 
Then : User clicks on Edit icon corresponding to Display Name 
And  : User changes the display name and saving it 
And  : User verifies whether the display name is being changed
And  : SignOut



