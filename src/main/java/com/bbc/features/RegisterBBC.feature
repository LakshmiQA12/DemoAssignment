#Author: Lakshmi
#Summary : Register New User to sign in BBC

Feature: Comment BBC News articles Feature 
Background: User launches BBC Site
Given :  User is navigated to BBC News Articles Comments Page
Then : User clicks on Comments 
 

Scenario: User navigates to  BBC News Articles Comments Section and doing the Registration process

            Given : User clicks Register in BBC News Articles Comments Page 
            When : User is in Registration Page 
            Then : User clicks the appropriate age selection
            And :  User starts the Registration process
                  | Day | Month | Year | Email | Password | Postcode | Gender | 
                   | 12 | 02 | 1988 | softwaretest1286@gmail.com | Igateseetha@0 | TW18 2DZ | Female | 
                    
            
 
