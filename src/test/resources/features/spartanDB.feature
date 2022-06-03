Feature: Spartan Name Information Test
@wip
  Scenario: Verify one spartan name
    When the user retrives the name of spartan with ID 8
    Then the name of the spartan should be "Rodolfo"