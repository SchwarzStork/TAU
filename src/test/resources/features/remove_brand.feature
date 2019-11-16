Feature: Remove CarBrand
  Remove CarBrand

  Scenario: Remove brand which is not named Audi
    Given create brands list
    When brands added to database
    When there is Audi
    But car name is not Audi
    Then remove this brand