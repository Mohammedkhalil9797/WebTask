package com.qacart.todo.pages;

import com.github.javafaker.Faker;
import com.qacart.todo.apiUser.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class ApiRegister {
    private String accessToken;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }




    public void getStatus() {

        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Content-Type", "application/json").log().all()
                        .when()
                        .get("/status")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();
        Assert.assertEquals(response.getBody().jsonPath().get("status"),"OK");
        accessToken = response.path("access_token");


    }
    public void getListOfBock() {
        String type = "fiction"; // Can be "fiction" or "non-fiction"
        Integer limit = 10;
        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .queryParam("type", type)  // Add "type" query parameter
                        .queryParam("limit", limit)
                        .header("Content-Type", "application/json").log().all()
                        .when()
                        .get("/books")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();
      //  Assert.assertEquals(response.getBody().jsonPath().get("status"),"OK");
        List<String> books = response.jsonPath().getList("books");
        Assert.assertNotNull(books); // Check that the list is not null
        Assert.assertTrue(books.size() <= limit);

    }
    public void getSingleBock() {

        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Content-Type", "application/json").log().all()
                        .when()
                        .get("/books/1")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),"The Russian");


    }
    public void deleteOrder() {
        String authToken = "c39d4ee710dcad38aef5ec0e2565340c751c66b8c718c2589d3316861643b646"; // Replace with your actual token

        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Authorization", "Bearer " + authToken)
                        .header("Content-Type", "application/json").log().all()
                        .when()
                        .get("/orders/nRTVpCU57z1pOp2Xza6I_")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();



    }
    public void getAllOrder() {
        String authToken = "c39d4ee710dcad38aef5ec0e2565340c751c66b8c718c2589d3316861643b646"; // Replace with your actual token

        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Authorization", "Bearer " + authToken)
                        .header("Content-Type", "application/json").log().all()
                        .when()
                        .get("/orders")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();



    }
    public void updateOrder() {
        String authToken = "c39d4ee710dcad38aef5ec0e2565340c751c66b8c718c2589d3316861643b646"; // Replace with your actual token
        String requestBody = "{\n" +
                "  \"bookId\": 1,\n" +
                "  \"customerName\": \"Mohammed97\"\n" +
                "}";
        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Authorization", "Bearer " + authToken)
                        .header("Content-Type", "application/json").body(requestBody).log().all()
                        .when()
                        .patch("/orders/lspet4-gjXEHrh4xcqma4")
                        .then()
                        .log().all().assertThat().statusCode(204)
                        .extract().response();



    }


    public void auth() {
        String requestBody = "{\n" +
                "  \"clientName\": \"Mohammed\",\n" +
                "  \"clientEmail\": \"Mohammed@example.com\"\n" +
                "}";
        Response response =
                given().baseUri("https://simple-books-api.glitch.me")
                        .header("Content-Type", "application/json").body(requestBody).log().all()
                        .when()
                        .post("/api-clients/")
                        .then()
                        .log().all().assertThat().statusCode(200)
                        .extract().response();

    }
    public void submitOrder() {

        String authToken = "c39d4ee710dcad38aef5ec0e2565340c751c66b8c718c2589d3316861643b646"; // Replace with your actual token

        // Define the request body
        String requestBody = "{\n" +
                "  \"bookId\": 1,\n" +
                "  \"customerName\": \"Mohammed\"\n" +
                "}";

        // Perform the POST request
        Response response =  given().baseUri("https://simple-books-api.glitch.me")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log().all() // Logs request details for debugging
                .when()
                .post("/orders")
                .then()
                .log().all() // Logs response details for debugging
                .assertThat().statusCode(201) // Assert the status code
                .extract()
                .response();
        Assert.assertNotNull(response.getBody().jsonPath().get("orderId"));

    }

}
