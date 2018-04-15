Feature: Add Pets

  Scenario: Add one new Pet
    Given a running API
    And a new Pet named Marte
    When hitting /pet to add
    Then return status 200
