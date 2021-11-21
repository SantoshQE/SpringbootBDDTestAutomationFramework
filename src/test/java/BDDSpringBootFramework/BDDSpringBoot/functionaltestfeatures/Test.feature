Feature: This is to test how this framework executes this test feature
  Automated test to check if everything in framework works fine

  @Frameworktest
  Scenario Outline: Verify google search functionality
    Given User is on google page in '<Env>' environment
    Then enter searchtext as '<SearchText>'

    Examples:
    |Env|SearchText|
    |ST |Selenium  |
    |ST |Docker|