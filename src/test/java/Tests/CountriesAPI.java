package Tests;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CountriesAPI {
    @Test
    public void validateCountryApiSchema() {
        RestAssured.baseURI = "https://restcountries.com/v3.1";

        given().
                when().
                get("/currency/rand").
                then().
                assertThat().
                statusCode(200).
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema/Africa.json"));

        System.out.println("✅ API schema validation test passed.");
    }
}

