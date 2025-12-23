import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

public class GetUserTest {

    @Test
    public void validateUserDetails() {

        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/users/1")
        .then()
            .statusCode(200)
            .body("name", equalTo("Leanne Graham"))
            .body("username", equalTo("Bret"));
    }
}
