@api
Feature: Create a new post via API

  Scenario: Successfully create a new post
    Given the user prepares the post with title "Learn API Testing", body "Practicing API testing", and userId 101
    When the user sends a POST request to create a new post
    Then the response status code should be 201
    And the response body should contain the same data as request
    And the response should conform to the JSON schema "create_post_schema.json"
