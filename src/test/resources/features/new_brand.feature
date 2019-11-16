# new feature
# Tags: optional

Feature: New CarBrand
  Create new CarBrand

  Scenario: Create new CarBrand
    Given Create New CarBrand
    When CarBrand has been created
    Then CarBrand has been add to database