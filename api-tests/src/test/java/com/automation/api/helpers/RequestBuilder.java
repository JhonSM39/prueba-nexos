package com.automation.api.helpers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public RequestSpecification getRequest() {
        return RestAssured.given()
                .log().all()
                .accept("application/json");
    }

    public RequestSpecification deleteRequest() {
        return RestAssured.given()
                .log().all()
                .accept("application/json");
    }

    public RequestSpecification postRequest() {
        return RestAssured.given()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .log().all();
    }

    public RequestSpecification putRequest() {
        return RestAssured.given()
                .log().all()
                .contentType("application/json")
                .accept("application/json");
    }

    public RequestSpecification patchRequest() {
        return RestAssured.given()
                .log().all()
                .contentType("application/json")
                .accept("application/json");
    }
}