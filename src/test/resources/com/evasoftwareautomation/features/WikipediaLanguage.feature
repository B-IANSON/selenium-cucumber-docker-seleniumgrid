@wikipedia-languages
Feature: Wikipedia Languages
  As a Wikipedia user,
  I want to select my language,
  So that I can use the site.
  
    Scenario Outline: Select Wikipedia language
    Given a web browser is on the Wikipedia home page
    When the "<language>" option is selected
    Then the site is translated to "<language>"
    
    Examples: Languages
    | language |
    | French   |
    | Spanish  |
    | German   |