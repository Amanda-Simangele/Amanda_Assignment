package Tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
public class ValidateSineLanguage {

        @Test
        public void validateSASLIsPresentInSouthAfricaLanguages() {
            // Define endpoint
            String url = "https://restcountries.com/v3.1/name/South%20Africa";

            // Send GET request and extract response
            Response response = RestAssured
                    .given()
                    .when()
                    .get(url)
                    .then()
                    .statusCode(200)
                    .extract().response();

            // South Africa will be the first (and only) object in the array
            Map<String, Object> countryData = response.jsonPath().getMap("[0]");
            Map<String, String> languages = (Map<String, String>) countryData.get("languages");

            // Print for debug
            System.out.println("Languages: " + languages);

            // Assertion to check if SASL is present
            Assert.assertTrue(
                    languages.containsValue("South African Sign Language"),
                    "SASL is not listed as an official language of South Africa"
            );
        }


}
