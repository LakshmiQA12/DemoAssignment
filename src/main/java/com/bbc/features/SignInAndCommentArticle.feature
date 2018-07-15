#Author: Lakshmi
#Summary : Sign In BBC and post comments for the news article

Feature: Sign In BBC and Post Comments on news articles Feature 
Background: User navigates to BBC Site
Given :  User is navigated to BBC News Articles Comments Page
Then : User clicks on Comments 
 
Scenario: User navigates to  BBC News Articles Comments Section and doing the Sign In Process
            Given : User clicks Sign In on BBC News Articles Comments Page 
            When : User is in SignIn Page and validates Sign In page title
            Then : User doing the Sign in process with Valid Email Id
                     | Username | Password |
                    | softwaretesting1286@gmail.com | Igateseetha@0 |
            And : User is posting comments for an article 
            And : SignOut