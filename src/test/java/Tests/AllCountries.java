package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AllCountries {
    @Test
    public void validateCountryCountIs195() {
        RestAssured.baseURI = "https://restcountries.com/v3.1";

        Response response = RestAssured.
                given().
                when().
                get("/independent?status=true").
                then().
                statusCode(200).
                extract().
                response();

        // Parse response as a list
        int countryCount = response.jsonPath().getList("$").size();

        System.out.println("✅ Number of countries received: " + countryCount);

        // Assert that there are 195 countries
        assertEquals(countryCount, 195, "Expected 195 countries in the response");

        System.out.println("✅ Country count test passed.");
    }
}
