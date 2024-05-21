package com.qacart.todo.pages;

import com.github.javafaker.Faker;
import com.qacart.todo.apiUser.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.response.Response;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class ApiRegister {
    private String accessToken;
    private String userID;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public void reg() {
        User user = UserUtils.generateRandUser();
        Response response =
                given().baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type", "application/json").body(user).log().all()
                        .when()
                        .post("/api/v1/users/register")
                        .then()
                        .log().all().assertThat().statusCode(201)
                        .extract().response();
        accessToken = response.path("access_token");
        firstName = response.path("firstName");
        userID = response.path("userID");

    }

}
