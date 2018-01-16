Feature: Light up clockface according to location data

  Scenario: Starting clock state
    Given: There is no location data available
    When: Clock is first switched on
    Then: No locations light up

  Scenario: First location update received for a given userId
    Given: No location data is available
    When: First location update is received with userId, locationId, and timestamp
    Then: Store location update offline on clock
    And: Cause the hardware to show this locationId for this userId
    And: Leave the current locationIds for all other userIds unaffected

  Scenario: Second or later location update received for a given userId
    Given: Initial location data is available
    When: New location update is received with userId, locationId, and timestamp
    Then: Store location update offline on clock
    And: Cause the hardware to replace the previous locationId + userId with new locationId + userId
    And: Leave the current locationIds for all other userIds unaffected