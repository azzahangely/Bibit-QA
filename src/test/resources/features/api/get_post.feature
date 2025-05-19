Feature: Retrieve all posts

  Scenario: Get all posts and verify the data
    When user sends a GET request to retrieve all posts
    Then the response status code should be 200
    And each post should have a non-null id
    And the response should conform to the JSON schema "get_posts_schema.json"
