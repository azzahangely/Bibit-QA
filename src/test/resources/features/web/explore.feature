@web
Feature: Search Produk Investasi on Bibit Explore

  Scenario: Search for a product in the Explore page
    Given the user opens Chrome
    And the user navigates to "https://app.bibit.id/"
    And the user inputs PIN "073025"
    When the user clicks element with XPath "//*[@id='root']/div/div/div/div/div/div[2]/div/div[3]/div[2]/button"
    When the user clicks element with XPath "//*[@id='bit-tabbar']/div/div[3]"
    When the user clicks element with XPath "//div[contains(@class, 'bit-explore-button')]"
    When the user types "manulife" into input with selector "input.custom-input-search"
    Then the page should contain at least one list with text "Manulife"
    When the user clicks element with XPath "//div[contains(@class, 'ExploreSaham_card-watchlist-item') and @data-symbol='KLSE-MANULFE']"
    When the user clicks element with XPath "//*[@id='root']/div[2]/div[1]"
    When the user clicks element with XPath "//*[@id='root']/div/div/div/div/div[1]/div[1]/div/div[1]"
    When the user clicks element with XPath "//*[@id='bit-tabbar']/div/div[5]/div"
