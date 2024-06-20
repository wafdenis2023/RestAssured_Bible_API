package common;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    private static final String API_KEY = "9bbcfb59117ffd862fa4120c2b7f7128";

    public static Response getRequest(String endpoint) {
        return RestAssured
                .given()
                .header("api-key", API_KEY)
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response getRequestWithInvalidApiKey(String endpoint) {
        return RestAssured
                .given()
                .header("api-key", "invalid_api_key")
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response getRequestWithoutApiKey(String endpoint) {
        return RestAssured
                .given()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
