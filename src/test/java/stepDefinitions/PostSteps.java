package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.get;


public class PostSteps {

    private Response response;
    private final Map<String, Object> requestBody = new HashMap<>();
    private final Map<String, Object> updateRequestBody = new HashMap<>();


    @Given("the user prepares the post with title {string}, body {string}, and userId {int}")
    public void preparePostPayload(String title, String body, int userId) {
        requestBody.clear();
        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userId", userId);
    }

    @When("the user sends a POST request to create a new post")
    public void createPost() {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("https://jsonplaceholder.typicode.com/posts");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: " + response.asPrettyString());
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatus(int expectedStatusCode) {
        System.out.println("Expected status: " + expectedStatusCode);
        System.out.println("Actual status: " + response.getStatusCode());
        assertThat(response.getStatusCode(), equalTo(expectedStatusCode));
    }

    @Then("the response body should contain the same data as request")
    public void verifyResponseBody() {
        Map<String, Object> responseBody = response.jsonPath().getMap("$");
        assertThat(responseBody.get("title"), equalTo(requestBody.get("title")));
        assertThat(responseBody.get("body"), equalTo(requestBody.get("body")));
        assertThat(responseBody.get("userId"), equalTo(requestBody.get("userId")));
    }

    @Then("the response should conform to the JSON schema {string}")
    public void verifyResponseSchema(String schemaFile) {
        File schema = new File("src/test/resources/schemas/" + schemaFile);
        response.then().assertThat().body(matchesJsonSchema(schema));

    }

    @When("user sends a GET request to retrieve all posts")
    public void getAllPosts() {
        response = get("https://jsonplaceholder.typicode.com/posts");
        System.out.println("GET Response Status Code: " + response.getStatusCode());
        System.out.println("GET Response Body:");
        System.out.println(response.asPrettyString());
    }

    @Then("each post should have a non-null id")
    public void verifyEachPostId() {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");

        for (int i = 0; i < posts.size(); i++) {
            Object id = posts.get(i).get("id");
            System.out.println("Post " + (i+1) +" ID: " + id);
            assertThat("ID should not be null", id, notNullValue());
        }
    }

    @When("the user sends a DELETE request to delete post with id {int}")
    public void deletePostById(int postId) {
        response = given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/" + postId);

        System.out.println("DELETE Status: " + response.getStatusCode());
        System.out.println("DELETE Body: " + response.asPrettyString());
    }

    @Given("the user prepares the updated post with title {string}, body {string}, and userId {int}")
    public void prepareUpdatedPost(String title, String body, int userId) {
        updateRequestBody.clear();
        updateRequestBody.put("title", title);
        updateRequestBody.put("body", body);
        updateRequestBody.put("userId", userId);
    }

    @When("user sends a PUT request to update post with id {int}")
    public void sendPutRequest(int postId) {
        response = given()
                .header("Content-Type", "application/json")
                .body(updateRequestBody)
                .put("https://jsonplaceholder.typicode.com/posts/" + postId);

        System.out.println("PUT Response Status: " + response.getStatusCode());
        System.out.println("PUT Response Body:");
        System.out.println(response.asPrettyString());
    }

    @Then("the response body should contain the same data as the update payload")
    public void verifyUpdatedResponse() {
        Map<String, Object> responseBody = response.jsonPath().getMap("$");

        assertThat(responseBody.get("title"), equalTo(updateRequestBody.get("title")));
        assertThat(responseBody.get("body"), equalTo(updateRequestBody.get("body")));
        assertThat(responseBody.get("userId"), equalTo(updateRequestBody.get("userId")));
    }


}
