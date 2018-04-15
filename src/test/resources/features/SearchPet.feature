Feature: Search for Pets

  Scenario: Fetch all Pets
    Given a running API
    When hitting /pets to search
    Then return status 200

  Scenario: Fetch for one Pet
    Given a running API
    When hitting /pets?name=Marte to search
    Then return status 200
    And return Pet with name Marte
