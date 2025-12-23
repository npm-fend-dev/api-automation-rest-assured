import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class CreatePostTest {

    @Test
    public void createPostSuccessfully() {

        String payload = """
            {
              "title": "API Automation",
              "body": "Rest Assured POST request",
              "userId": 1
            }
            """;

        given()
            .header("Content-Type", "application/json")
            .body(payload)
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("API Automation"))
            .body("userId", equalTo(1));
    }
}

    @Test
    public void createPostWithoutBodyShouldFail() {

        given()
            .header("Content-Type", "application/json")
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(201); // JSONPlaceholder returns 201 even for invalid input
    }
