package com.automation.api.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class ApiConfig {

    protected static RequestSpecification REQUEST_SPEC;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://dummyjson.com/";

        REQUEST_SPEC = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.requestSpecification = REQUEST_SPEC;
    }
}