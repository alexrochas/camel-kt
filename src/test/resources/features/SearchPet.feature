Feature: Search for Pets

  Scenario: Fetch all Pets
    Given a running API
    When hitting /pets to search
    Then return status 200
