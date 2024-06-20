package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import common.ApiUtils;
import static org.hamcrest.Matchers.equalTo;

public class BiblesTest {

    private static final String BASE_URL = "https://api.scripture.api.bible/v1/bibles";

    @Test
    public void testGetBiblesWithValidApiKey() {
        Response response = ApiUtils.getRequest(BASE_URL);

        response.then().statusCode(200);

        // Validate specific fields in the response
        response.then().body("data[0].id", equalTo("472735b48a27b402-01"));
        response.then().body("data[0].name", equalTo("The New Testament in Ahirani language"));
        response.then().body("data[0].language.id", equalTo("ahr"));
        response.then().body("data[0].language.name", equalTo("Ahirani"));
        response.then().body("data[0].language.script", equalTo("Devanagari"));
    }

    @Test
    public void testGetBiblesWithInvalidApiKey() {
        Response response = ApiUtils.getRequestWithInvalidApiKey(BASE_URL);

        response.then().statusCode(500);

        response.then().body("message", equalTo("An internal server error occurred"));
    }

    @Test
    public void testGetBiblesWithoutApiKey() {
        Response response = ApiUtils.getRequestWithoutApiKey(BASE_URL);

        response.then().statusCode(401);

        response.then().body("error", equalTo("Unauthorized"));
        response.then().body("message", equalTo("missing key"));
    }
}
