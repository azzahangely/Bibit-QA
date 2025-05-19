Feature: Delete a post

  Scenario: Successfully delete a post by ID
    When the user sends a DELETE request to delete post with id 1
    Then the response status code should be 200
    And the response should conform to the JSON schema "delete_post_schema.json"
