package com.automation.api.services;

import com.automation.api.models.UserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserService {

    public Response getUsers() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get("/users?page=2")
                .andReturn();
    }

    public Response createUser(UserRequest user) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/users/add")
                .andReturn();
    }

    public Response updateUser(int id, Object body) {
        return RestAssured
                .given()
                .body(body)
                .put("/users/" + id)
                .andReturn();
    }

    public Response deleteUser(int id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .delete("/users/" + id)
                .andReturn();
    }
}