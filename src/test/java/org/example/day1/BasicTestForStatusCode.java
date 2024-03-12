package org.example.day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicTestForStatusCode {

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
}
