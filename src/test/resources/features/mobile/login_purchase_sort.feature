@android
Feature: Basic Functionality on Android App

  Scenario: Login success with valid credentials
    Given the user opens the app
    # Perform Login
    When the user clicks element with accessibility id "View menu"
    When the user clicks element with accessibility id "Login Menu Item"
    When the user types "user" into element with id "com.saucelabs.mydemoapp.android:id/nameET"
    When the user types "user123_" into element with id "com.saucelabs.mydemoapp.android:id/passwordET"
    When the user clicks element with accessibility id "Tap to login with given credentials"

  Scenario: Purchase 2 Blue Sauce Lab Back Packs and perform sorting
    When the user clicks element with android UIAutomator "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(0)"
    And the user clicks element with accessibility id "Blue color"
    And the user clicks element with accessibility id "Displays selected product"
    And the user clicks element with accessibility id "Increase item quantity"
    And the user clicks element with accessibility id "Tap to add product to cart"
    And the user clicks element with id "com.saucelabs.mydemoapp.android:id/cartIV"
    And the user clicks element with accessibility id "Confirms products for checkout"
    And the user types "Azzah Azkiyah" into element with id "com.saucelabs.mydemoapp.android:id/fullNameET"
    And the user types "Street A 112" into element with id "com.saucelabs.mydemoapp.android:id/address1ET"
    And the user types "Street A Q2" into element with id "com.saucelabs.mydemoapp.android:id/address2ET"
    And the user types "East Jakarta" into element with id "com.saucelabs.mydemoapp.android:id/cityET"
    And the user types "East Jakarta" into element with id "com.saucelabs.mydemoapp.android:id/stateET"
    And the user types "12345" into element with id "com.saucelabs.mydemoapp.android:id/zipET"
    And the user types "Indonesia" into element with id "com.saucelabs.mydemoapp.android:id/countryET"
    And the user clicks element with accessibility id "Saves user info for checkout"
    And the user types "Azzah Azkiyah" into element with id "com.saucelabs.mydemoapp.android:id/nameET"
    And the user types "321456789012" into element with id "com.saucelabs.mydemoapp.android:id/cardNumberET"
    And the user types "01/29" into element with id "com.saucelabs.mydemoapp.android:id/expirationDateET"
    And the user types "000" into element with id "com.saucelabs.mydemoapp.android:id/securityCodeET"
    # Try to uncheck the checkbox to display additional form
    And the user clicks element with accessibility id "Select if User billing address and shipping address are same"
    When the user scrolls down 2 times
    # Check the checkbox again
    And the user clicks element with accessibility id "Select if User billing address and shipping address are same"
    And the user clicks element with id "com.saucelabs.mydemoapp.android:id/questionIV"
    And the user clicks element with accessibility id "Saves payment info and launches screen to review checkout data"
    And the user clicks element with accessibility id "Completes the process of checkout"
    And the user clicks element with accessibility id "Tap to open catalog"
    And the user clicks element with accessibility id "Shows current sorting order and displays available sorting options"
    And the user clicks element with accessibility id "Descending order by name"
    When the user scrolls down 7 times
    And the user clicks element with accessibility id "Shows current sorting order and displays available sorting options"
    And the user clicks element with accessibility id "Ascending order by price"
    When the user scrolls down 7 times
    And the user clicks element with accessibility id "View menu"
    And the user clicks element with accessibility id "Logout Menu Item"
    And the user clicks element with id "android:id/button1"
    # Validate user has logged out
    Then the user should see element with accessibility id "Tap to login with given credentials"