Feature: Update CarBrand
  Update CarBrand

  Scenario Outline: Update Brand data
    Given prepare brands list
    When add brands to database
    When there is Audi
    And brand id is "<id>"
    Then update data of this Brand by new Brand "<response>"

    Examples:
      | id | response   |
      | 1  | NotUpdated |
      | 2  | Updated    |
      | 3  | NotUpdated |
      | 4  | Updated    |
      | 5  | NotUpdated |
      | 6  | Updated    |
      | 7  | NotUpdated |
      | 8  | Updated    |
      | 9  | NotUpdated |