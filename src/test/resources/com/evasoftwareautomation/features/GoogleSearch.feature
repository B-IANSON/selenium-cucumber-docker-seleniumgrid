@google-searching
Feature: Google Searching
  As a web user,
  I want to search Google,
  So that I can learn new things.
  
  Background:
  Given a web browser is on the Google home page 
  
  Scenario: Basic Google search
    When the search text "test automation" is entered
    Then results for entered text "test automation" are shown
    And the first suggested link contains content related to "test automation"
   
   Scenario: Google image search
    When the search text "devops" is entered
    And the Images option from the results page is selected
    Then the first suggested image for "devops" is displayed successfully
   
   Scenario: Google Ajax suggestions
    When the phrase "cucumber" is keyed into the search box
    Then suggestions for "cucumber" are displayed