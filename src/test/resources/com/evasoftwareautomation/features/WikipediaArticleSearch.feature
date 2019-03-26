@wikipedia-article-searching
Feature: Wikipedia Article Searching
  As a Wikipedia user,
  I want to search for articles,
  So that I learn about my interests.
  
    Scenario Outline: Article search
    Given a web browser is on the Wikipedia home page in the required language for "<user>"
    When the users subject of interest is searched for
    Then the article related to the users interest is displayed
    
    Examples: Users
    | user           |
    | HANS_GRUBER    |
    | NICO_COLLARD   |
    | MIGUEL_SANCHEZ |