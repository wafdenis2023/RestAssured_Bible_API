package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import common.ApiUtils;

import static org.hamcrest.Matchers.equalTo;

public class BooksTest {

    private static final String BASE_URL = "https://api.scripture.api.bible/v1/bibles";
    private static final String BIBLE_ID = "472735b48a27b402-01";
    private static final String BOOKS_ENDPOINT = BASE_URL + "/" + BIBLE_ID + "/books";

    @Test
    public void testGetBooksWithValidApiKey() {
        Response response = ApiUtils.getRequest(BOOKS_ENDPOINT);

        response.then().statusCode(200);

        // Validate specific fields in the response
        response.then().body("data[0].id", equalTo("MAT"));
        response.then().body("data[0].bibleId", equalTo(BIBLE_ID));
        response.then().body("data[0].abbreviation", equalTo("मत्तय"));
        response.then().body("data[0].name", equalTo("मत्तय"));
        response.then().body("data[0].nameLong", equalTo("मत्तयनी लिखेल येशु ख्रिस्तनं शुभवर्तमान"));

        response.then().body("data[1].id", equalTo("MRK"));
        response.then().body("data[1].bibleId", equalTo(BIBLE_ID));
        response.then().body("data[1].abbreviation", equalTo("मार्क"));
        response.then().body("data[1].name", equalTo("मार्क"));
        response.then().body("data[1].nameLong", equalTo("मार्कनी लिखेल येशु ख्रिस्तनं शुभवर्तमान"));
    }

    @Test
    public void testGetBooksWithInvalidApiKey() {
        Response response = ApiUtils.getRequestWithInvalidApiKey(BASE_URL);

        response.then().statusCode(500);
        response.then().body("message", equalTo("An internal server error occurred"));
    }

    @Test
    public void testGetBooksWithoutApiKey() {
        Response response = ApiUtils.getRequestWithoutApiKey(BOOKS_ENDPOINT);

        response.then().statusCode(401);

        response.then().body("error", equalTo("Unauthorized"));
        response.then().body("message", equalTo("missing key"));
    }
}
