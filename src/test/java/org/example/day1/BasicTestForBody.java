package org.example.day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicTestForBody {

    @Test
    public void validateStatusCode()
    {
        given().
                baseUri("https://api.zippopotam.us").
        when().
                get("/AD/AD100").
        then().
                assertThat().statusCode(200);
    }

    @Test
    public void validateCountryInfo()
    {
        given().
                baseUri("https://api.zippopotam.us").
        when().
                get("/AD/AD100").
        then().
                assertThat().statusCode(200).
                body("country",equalTo("Andorra")).
                body("'post code'",equalTo("AD100")).
                body("'country abbreviation'",equalTo("AD"));
    }

    @Test
    public void validatePlacesInfo()
    {
        given().
                baseUri("https://api.zippopotam.us").
        when().
                get("/AD/AD100").
        then().
                assertThat().statusCode(200).
                body("places[0].'place name'",equalTo("Canillo")).
                body("places[0].longitude",equalTo("1.6667")).
                body("places[0].state",equalTo("")).
                body("places[0].'state abbreviation'",equalTo("")).
                body("places[0].latitude",equalTo("42.5833"));
    }
}
