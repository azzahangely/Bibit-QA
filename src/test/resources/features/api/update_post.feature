Feature: Update an existing post

  Scenario: Successfully update a post
    Given the user prepares the updated post with title "Updated Post Title", body "This is the updated body content.", and userId 99
    When user sends a PUT request to update post with id 1
    Then the response status code should be 200
    And the response body should contain the same data as the update payload
    And the response should conform to the JSON schema "update_post_schema.json"
